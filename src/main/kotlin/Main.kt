import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    println("Введите координаты вершин треугольника (x1, y1, x2, y2, x3, y3):")
    val x1 = scanner.nextDouble()
    val y1 = scanner.nextDouble()
    val x2 = scanner.nextDouble()
    val y2 = scanner.nextDouble()
    val x3 = scanner.nextDouble()
    val y3 = scanner.nextDouble()

    println("Введите координаты точки (x, y):")
    val x = scanner.nextDouble()
    val y = scanner.nextDouble()

    val isInside = isPointInsideTriangle(x, y, x1, y1, x2, y2, x3, y3)

    if (isInside) {
        println("Точка находится внутри треугольника")
    } else {
        println("Точка находится вне треугольника")
    }
}

fun isPointInsideTriangle(x: Double, y: Double, x1: Double, y1: Double, x2: Double, y2: Double, x3:
Double, y3: Double): Boolean {
    val area = 0.5 * (-y2 * x3 + y1 * (-x2 + x3) + x1 * (y2 - y3) + x2 * y3)
    val sign = if (area < 0) -1 else 1

    val s = (y1 * x3 - x1 * y3 + (y3 - y1) * x + (x1 - x3) * y) * sign
    val t = (x1 * y2 - y1 * x2 + (y1 - y2) * x + (x2 - x1) * y) * sign

    return s > 0 && t > 0 && s + t < 2 * area * sign
}