class Point(val x: Double, val y: Double)
class Triangle(val vertex1: Point, val vertex2: Point, val vertex3: Point)
class Circle(val center: Point, val radius: Double)

fun Triangle.getInscribedCircle(): Circle {
// Вычисляем длины сторон треугольника
    val side1 = Math.sqrt(Math.pow(vertex2.x - vertex1.x, 2.0) + Math.pow(vertex2.y - vertex1.y, 2.0))
    val side2 = Math.sqrt(Math.pow(vertex3.x - vertex2.x, 2.0) + Math.pow(vertex3.y - vertex2.y, 2.0))
    val side3 = Math.sqrt(Math.pow(vertex1.x - vertex3.x, 2.0) + Math.pow(vertex1.y - vertex3.y, 2.0))
// Вычисляем полупериметр треугольника
    val semiperimeter = (side1 + side2 + side3) / 2
// Вычисляем радиус окружности
    val radius = Math.sqrt((semiperimeter - side1) * (semiperimeter - side2) * (semiperimeter - side3) / semiperimeter)
// Вычисляем координаты центра окружности

    val centerX = (side2 * vertex1.x + side3 * vertex2.x + side1 * vertex3.x) / (side1 + side2 + side3)
    val centerY = (side2 * vertex1.y + side3 * vertex2.y + side1 * vertex3.y) / (side1 + side2 + side3)
    return Circle(Point(centerX, centerY), radius)
}

fun main() {
    println("Введите координаты вершин треугольника:")
    println("Введите координаты первой вершины:")
    val x1 = readLine()?.toDoubleOrNull() ?: return
    val y1 = readLine()?.toDoubleOrNull() ?: return
    val vertex1 = Point(x1, y1)

    println("Введите координаты второй вершины:")
    val x2 = readLine()?.toDoubleOrNull() ?: return
    val y2 = readLine()?.toDoubleOrNull() ?: return
    val vertex2 = Point(x2, y2)

    println("Введите координаты третьей вершины:")
    val x3 = readLine()?.toDoubleOrNull() ?: return
    val y3 = readLine()?.toDoubleOrNull() ?: return
    val vertex3 = Point(x3, y3)

// Создаем объект класса "Треугольник" с заданными вершинами
    val triangle = Triangle(vertex1, vertex2, vertex3)

// Вычисляем вписанную окружность
    val inscribedCircle = triangle.getInscribedCircle()

    println("Координаты центра окружности: (${inscribedCircle.center.x}, ${inscribedCircle.center.y})")
    println("Радиус окружности: ${inscribedCircle.radius}")
}
