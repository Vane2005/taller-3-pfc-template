package taller

import scala.collection.parallel.CollectionConverters._
import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MatrizTest extends AnyFunSuite {

  val objMatriz = new MatrizOps()

  //matrices de tamaño 2x2
  val matriz11 = Vector(Vector(1, 2), Vector(3, 4))
  val matriz12 = Vector(Vector(4, 3), Vector(2, 1))

  //matrices de tamaño 4x4
  val matriz1 = Vector(
    Vector(1, 2, 3,4), 
    Vector(5, 6, 7, 8), 
    Vector(9, 10, 11, 12), 
    Vector(13, 14, 15, 16))

  val matriz2 = Vector(
    Vector(16,15,14,13), 
    Vector(12,11,10,9), 
    Vector(8,7,6,5),
    Vector(4,3,2,1))

  //matrices de tamaño 8x8
  val matriz3 = Vector(
    Vector(1, 5, 3, 2, 4, 1, 5, 3),
    Vector(2, 4, 1, 5, 3, 2, 4, 1),
    Vector(5, 3, 2, 4, 1, 5, 3, 2),
    Vector(4, 1, 5, 3, 2, 4, 1, 5),
    Vector(3, 2, 4, 1, 5, 3, 2, 4),
    Vector(1, 5, 3, 2, 4, 1, 5, 3),
    Vector(2, 4, 1, 5, 3, 2, 4, 1),
    Vector(5, 3, 2, 4, 1, 5, 3, 2)
  )
  val matriz4 = Vector(
  Vector(1, 2, 3, 4, 5, 1, 2, 3),
  Vector(3, 4, 5, 1, 2, 3, 4, 5),
  Vector(2, 3, 4, 5, 1, 2, 3, 4),
  Vector(5, 1, 2, 3, 4, 5, 1, 2),
  Vector(4, 5, 1, 2, 3, 4, 5, 1),
  Vector(1, 2, 3, 4, 5, 1, 2, 3),
  Vector(3, 4, 5, 1, 2, 3, 4, 5),
  Vector(2, 3, 4, 5, 1, 2, 3, 4)
)


  //matrices de tamaño 16x16
  val matriz5 = Vector(
    Vector(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1),
    Vector(2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2),
    Vector(3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3),
    Vector(4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4),
    Vector(5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5),
    Vector(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1),
    Vector(2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2),
    Vector(3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3),
    Vector(4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4),
    Vector(5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5),
    Vector(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1),
    Vector(2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2),
    Vector(3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3),
    Vector(4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4),
    Vector(5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5),
    Vector(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1)
  )
  val matriz6 = Vector(
    Vector(1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1),
    Vector(4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4),
    Vector(2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2),
    Vector(3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3),
    Vector(5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5),
    Vector(1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1),
    Vector(4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4),
    Vector(2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2),
    Vector(3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3),
    Vector(5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5),
    Vector(1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1),
    Vector(4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4),
    Vector(2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2),
    Vector(3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3),
    Vector(5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5),
    Vector(1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1, 5, 3, 2, 4, 1)
  )

  //matrices diferentes de 8x8
  val matriz7 = Vector(
    Vector(1, 3, 5, 2, 4, 1, 3, 5),
    Vector(4, 2, 1, 3, 5, 4, 2, 1),
    Vector(2, 4, 1, 5, 3, 2, 4, 1),
    Vector(5, 3, 2, 4, 1, 5, 3, 2),
    Vector(1, 5, 3, 2, 4, 1, 5, 3),
    Vector(4, 1, 5, 3, 2, 4, 1, 5),
    Vector(2, 4, 1, 5, 3, 2, 4, 1),
    Vector(3, 2, 4, 1, 5, 3, 2, 4)
  )
  val matriz8 = Vector(
    Vector(1, 2, 3, 4, 5, 1, 2, 3),
    Vector(4, 5, 1, 2, 3, 4, 5, 1),
    Vector(3, 4, 5, 1, 2, 3, 4, 5),
    Vector(2, 3, 4, 5, 1, 2, 3, 4),
    Vector(5, 1, 2, 3, 4, 5, 1, 2),
    Vector(1, 2, 3, 4, 5, 1, 2, 3),
    Vector(4, 5, 1, 2, 3, 4, 5, 1),
    Vector(3, 4, 5, 1, 2, 3, 4, 5)
  )

  //matrices cuadradas 7x7
  val matriz9 = Vector(
    Vector(1, 2, 3, 4, 5, 6, 7),
    Vector(8, 9, 10, 11, 12, 13, 14),
    Vector(15, 16, 17, 18, 19, 20, 21),
    Vector(22, 23, 24, 25, 26, 27, 28),
    Vector(29, 30, 31, 32, 33, 34, 35),
    Vector(36, 37, 38, 39, 40, 41, 42),
    Vector(43, 44, 45, 46, 47, 48, 49)
  )

  val matriz10 = Vector(
    Vector(1, 2, 3, 4, 5, 6, 7),
    Vector(8, 9, 10, 11, 12, 13, 14),
    Vector(15, 16, 17, 18, 19, 20, 21),
    Vector(22, 23, 24, 25, 26, 27, 28),
    Vector(29, 30, 31, 32, 33, 34, 35),
    Vector(36, 37, 38, 39, 40, 41, 42),
    Vector(43, 44, 45, 46, 47, 48, 49)
  )

  //Restando matrices

  test("Restar la matriz11 con la matriz12 dará como resultado Vector(Vector(-3,-1), Vector(1,3))") {
    assert(objMatriz.restaMatriz(matriz11, matriz12) == Vector(Vector(-3,-1), Vector(1,3)))
  }

  test("Restar la matriz1 con la matriz2 dará como resultado Vector(Vector(-15,-13,-11,-9), Vector(-7,-5,-3,-1), Vector(1,3,5,7), Vector(9,11,13,15))") {
    assert(objMatriz.restaMatriz(matriz1, matriz2) == Vector(Vector(-15,-13,-11,-9), Vector(-7,-5,-3,-1), Vector(1,3,5,7), Vector(9,11,13,15)))
  }

  test("Resta de matriz3 por matriz4 dará como resultado Vector(Vector(0, 3, 0, -2, -1, 0, 3, 0), Vector(-1, 0, -4, 4, 1, -1, 0, -4), Vector(3, 0, -2, -1, 0, 3, 0, -2), Vector(-1, 0, 3, 0, -2, -1, 0, 3), Vector(-1, -3, 3, -1, 2, -1, -3, 3), Vector(0, 3, 0, -2, -1, 0, 3, 0), Vector(-1, 0, -4, 4, 1, -1, 0, -4), Vector(3, 0, -2, -1, 0, 3, 0, -2)))") {
    assert(objMatriz.restaMatriz(matriz3, matriz4) == Vector(Vector(0, 3, 0, -2, -1, 0, 3, 0), Vector(-1, 0, -4, 4, 1, -1, 0, -4), Vector(3, 0, -2, -1, 0, 3, 0, -2), Vector(-1, 0, 3, 0, -2, -1, 0, 3), Vector(-1, -3, 3, -1, 2, -1, -3, 3), Vector(0, 3, 0, -2, -1, 0, 3, 0), Vector(-1, 0, -4, 4, 1, -1, 0, -4), Vector(3, 0, -2, -1, 0, 3, 0, -2)))
  }

  test("Resta de matriz5 por matriz6 dará como resultado Vector(Vector(0, -3, 0, 2, 1, 0, -3, 0, 2, 1, 0, -3, 0, 2, 1, 0), Vector(-2, 2, -1, 2, -1, -2, 2, -1, 2, -1, -2, 2, -1, 2, -1, -2), Vector(1, 0, 4, -4, -1, 1, 0, 4, -4, -1, 1, 0, 4, -4, -1, 1), Vector(1, 3, -3, 1, -2, 1, 3, -3, 1, -2, 1, 3, -3, 1, -2, 1), Vector(0, -2, 0, -1, 3, 0, -2, 0, -1, 3, 0, -2, 0, -1, 3, 0), Vector(0, -3, 0, 2, 1, 0, -3, 0, 2, 1, 0, -3, 0, 2, 1, 0), Vector(-2, 2, -1, 2, -1, -2, 2, -1, 2, -1, -2, 2, -1, 2, -1, -2), Vector(1, 0, 4, -4, -1, 1, 0, 4, -4, -1, 1, 0, 4, -4, -1, 1), Vector(1, 3, -3, 1, -2, 1, 3, -3, 1, -2, 1, 3, -3, 1, -2, 1), Vector(0, -2, 0, -1, 3, 0, -2, 0, -1, 3, 0, -2, 0, -1, 3, 0), Vector(0, -3, 0, 2, 1, 0, -3, 0, 2, 1, 0, -3, 0, 2, 1, 0), Vector(-2, 2, -1, 2, -1, -2, 2, -1, 2, -1, -2, 2, -1, 2, -1, -2), Vector(1, 0, 4, -4, -1, 1, 0, 4, -4, -1, 1, 0, 4, -4, -1, 1), Vector(1, 3, -3, 1, -2, 1, 3, -3, 1, -2, 1, 3, -3, 1, -2, 1), Vector(0, -2, 0, -1, 3, 0, -2, 0, -1, 3, 0, -2, 0, -1, 3, 0), Vector(0, -3, 0, 2, 1, 0, -3, 0, 2, 1, 0, -3, 0, 2, 1, 0))") {
    assert(objMatriz.restaMatriz(matriz5, matriz6) == Vector(Vector(0, -3, 0, 2, 1, 0, -3, 0, 2, 1, 0, -3, 0, 2, 1, 0), Vector(-2, 2, -1, 2, -1, -2, 2, -1, 2, -1, -2, 2, -1, 2, -1, -2), Vector(1, 0, 4, -4, -1, 1, 0, 4, -4, -1, 1, 0, 4, -4, -1, 1), Vector(1, 3, -3, 1, -2, 1, 3, -3, 1, -2, 1, 3, -3, 1, -2, 1), Vector(0, -2, 0, -1, 3, 0, -2, 0, -1, 3, 0, -2, 0, -1, 3, 0), Vector(0, -3, 0, 2, 1, 0, -3, 0, 2, 1, 0, -3, 0, 2, 1, 0), Vector(-2, 2, -1, 2, -1, -2, 2, -1, 2, -1, -2, 2, -1, 2, -1, -2), Vector(1, 0, 4, -4, -1, 1, 0, 4, -4, -1, 1, 0, 4, -4, -1, 1), Vector(1, 3, -3, 1, -2, 1, 3, -3, 1, -2, 1, 3, -3, 1, -2, 1), Vector(0, -2, 0, -1, 3, 0, -2, 0, -1, 3, 0, -2, 0, -1, 3, 0), Vector(0, -3, 0, 2, 1, 0, -3, 0, 2, 1, 0, -3, 0, 2, 1, 0), Vector(-2, 2, -1, 2, -1, -2, 2, -1, 2, -1, -2, 2, -1, 2, -1, -2), Vector(1, 0, 4, -4, -1, 1, 0, 4, -4, -1, 1, 0, 4, -4, -1, 1), Vector(1, 3, -3, 1, -2, 1, 3, -3, 1, -2, 1, 3, -3, 1, -2, 1), Vector(0, -2, 0, -1, 3, 0, -2, 0, -1, 3, 0, -2, 0, -1, 3, 0), Vector(0, -3, 0, 2, 1, 0, -3, 0, 2, 1, 0, -3, 0, 2, 1, 0)))
  }

  test("Resta de matriz7 por matriz8 dará como resultado Vector(Vector(0, 1, 2, -2, -1, 0, 1, 2), Vector(0, -3, 0, 1, 2, 0, -3, 0), Vector(-1, 0, -4, 4, 1, -1, 0, -4), Vector(3, 0, -2, -1, 0, 3, 0, -2), Vector(-4, 4, 1, -1, 0, -4, 4, 1), Vector(3, -1, 2, -1, -3, 3, -1, 2), Vector(-2, -1, 0, 3, 0, -2, -1, 0), Vector(0, -2, -1, 0, 3, 0, -2, -1))") {
    assert(objMatriz.restaMatriz(matriz7, matriz8) == Vector(Vector(0, 1, 2, -2, -1, 0, 1, 2), Vector(0, -3, 0, 1, 2, 0, -3, 0), Vector(-1, 0, -4, 4, 1, -1, 0, -4), Vector(3, 0, -2, -1, 0, 3, 0, -2), Vector(-4, 4, 1, -1, 0, -4, 4, 1), Vector(3, -1, 2, -1, -3, 3, -1, 2), Vector(-2, -1, 0, 3, 0, -2, -1, 0), Vector(0, -2, -1, 0, 3, 0, -2, -1)))
  }

  //Multiplicando matrices recursivamente, version secuencial

  test("Multiplicar la matriz11 por la matriz12 dará como resultado Vector(Vector(8,5), Vector(20,13))") {
    assert(objMatriz.multMatrizRec(matriz11, matriz12) == Vector(Vector(8,5), Vector(20,13)))
  }

  test("Multiplicar la matriz1 por la matriz2 dará como resultado Vector(Vector(80,70,60,50), Vector(240,214,188,162), Vector(400,358,316,274), Vector(2084,1899,1714,1529))") {
    assert(objMatriz.multMatrizRec(matriz1, matriz2) == Vector(Vector(80, 70, 60, 50), Vector(240, 214, 188, 162), Vector(400, 358, 316, 274), Vector(560, 502, 444, 386)))
  }

  test("Multiplicar la matriz3 por la matriz4 dará como resultado Vector(70, 84, 88, 62, 56, 70, 84, 88), Vector(69, 66, 73, 55, 67, 69, 66, 73), Vector(60, 65, 85, 80, 85, 60, 65, 85), Vector(57, 67, 82, 97, 72, 57, 67, 82), Vector(59, 78, 77, 81, 65, 59, 78, 77), Vector(70, 84, 88, 62, 56, 70, 84, 88), Vector(69, 66, 73, 55, 67, 69, 66, 73), Vector(60, 65, 85, 80, 85, 60, 65, 85)") {
    assert(objMatriz.multMatrizRec(matriz3, matriz4) == Vector(Vector(70, 84, 88, 62, 56, 70, 84, 88), Vector(69, 66, 73, 55, 67, 69, 66, 73), Vector(60, 65, 85, 80, 85, 60, 65, 85), Vector(57, 67, 82, 97, 72, 57, 67, 82), Vector(59, 78, 77, 81, 65, 59, 78, 77), Vector(70, 84, 88, 62, 56, 70, 84, 88), Vector(69, 66, 73, 55, 67, 69, 66, 73), Vector(60, 65, 85, 80, 85, 60, 65, 85)))
  }

  test("Multiplicar la matriz5 por la matriz6 dará como resultado Vector(Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157))") {
  assert(objMatriz.multMatrizRec(matriz5, matriz6) == Vector(Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157)))
  }

  test("Multiplicar la matriz7 por la matriz8 dará como resultado Vector(Vector(80, 84, 78, 52, 66, 80, 84, 78), Vector(61, 58, 60, 72, 79, 61, 58, 60), Vector(67, 74, 56, 68, 65, 67, 74, 56), Vector(59, 79, 74, 79, 84, 59, 79, 74), Vector(84, 88, 62, 56, 70, 84, 88, 62), Vector(62, 77, 92, 67, 77, 62, 77, 92), Vector(67, 74, 56, 68, 65, 67, 74, 56), Vector(73, 72, 76, 60, 79, 73, 72, 76))") {
  assert(objMatriz.multMatrizRec(matriz7, matriz8) == Vector(Vector(80, 84, 78, 52, 66, 80, 84, 78), Vector(61, 58, 60, 72, 79, 61, 58, 60), Vector(67, 74, 56, 68, 65, 67, 74, 56), Vector(59, 79, 74, 79, 84, 59, 79, 74), Vector(84, 88, 62, 56, 70, 84, 88, 62), Vector(62, 77, 92, 67, 77, 62, 77, 92), Vector(67, 74, 56, 68, 65, 67, 74, 56), Vector(73, 72, 76, 60, 79, 73, 72, 76)))
  }

  //Multiplicando matrices recursivamente, version paralela

  test("multiplicar la matriz11 por la matriz12 dará como resultado Vector(Vector(8,5), Vector(20,13))") {
    assert(objMatriz.multMatrizRecPar(matriz11, matriz12) == Vector(Vector(8,5), Vector(20,13)))
  }

  test("multiplicar la matriz1 por la matriz2 dará como resultado Vector(Vector(80,70,60,50), Vector(240,214,188,162), Vector(400,358,316,274), Vector(2084,1899,1714,1529))") {
    assert(objMatriz.multMatrizRecPar(matriz1, matriz2) == Vector(Vector(80, 70, 60, 50), Vector(240, 214, 188, 162), Vector(400, 358, 316, 274), Vector(560, 502, 444, 386)))
  }

  test("multiplicar la matriz3 por la matriz4 dará como resultado Vector(70, 84, 88, 62, 56, 70, 84, 88), Vector(69, 66, 73, 55, 67, 69, 66, 73), Vector(60, 65, 85, 80, 85, 60, 65, 85), Vector(57, 67, 82, 97, 72, 57, 67, 82), Vector(59, 78, 77, 81, 65, 59, 78, 77), Vector(70, 84, 88, 62, 56, 70, 84, 88), Vector(69, 66, 73, 55, 67, 69, 66, 73), Vector(60, 65, 85, 80, 85, 60, 65, 85)") {
    assert(objMatriz.multMatrizRecPar(matriz3, matriz4) == Vector(Vector(70, 84, 88, 62, 56, 70, 84, 88), Vector(69, 66, 73, 55, 67, 69, 66, 73), Vector(60, 65, 85, 80, 85, 60, 65, 85), Vector(57, 67, 82, 97, 72, 57, 67, 82), Vector(59, 78, 77, 81, 65, 59, 78, 77), Vector(70, 84, 88, 62, 56, 70, 84, 88), Vector(69, 66, 73, 55, 67, 69, 66, 73), Vector(60, 65, 85, 80, 85, 60, 65, 85)))
  }

  test("multiplicar la matriz5 por la matriz6 dará como resultado Vector(Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157))") {
  assert(objMatriz.multMatrizRecPar(matriz5, matriz6) == Vector(Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157)))
  }

  test("multiplicar la matriz7 por la matriz8 dará como resultado Vector(Vector(80, 84, 78, 52, 66, 80, 84, 78), Vector(61, 58, 60, 72, 79, 61, 58, 60), Vector(67, 74, 56, 68, 65, 67, 74, 56), Vector(59, 79, 74, 79, 84, 59, 79, 74), Vector(84, 88, 62, 56, 70, 84, 88, 62), Vector(62, 77, 92, 67, 77, 62, 77, 92), Vector(67, 74, 56, 68, 65, 67, 74, 56), Vector(73, 72, 76, 60, 79, 73, 72, 76))") {
  assert(objMatriz.multMatrizRecPar(matriz7, matriz8) == Vector(Vector(80, 84, 78, 52, 66, 80, 84, 78), Vector(61, 58, 60, 72, 79, 61, 58, 60), Vector(67, 74, 56, 68, 65, 67, 74, 56), Vector(59, 79, 74, 79, 84, 59, 79, 74), Vector(84, 88, 62, 56, 70, 84, 88, 62), Vector(62, 77, 92, 67, 77, 62, 77, 92), Vector(67, 74, 56, 68, 65, 67, 74, 56), Vector(73, 72, 76, 60, 79, 73, 72, 76)))
  }

  //Multiplicaciones con el algoritmo de Strassen

  test("multiplicar la matriz11 por la matriz12 dará como resultado: Vector(Vector(8,5), Vector(20,13))") {
    assert(objMatriz.multStrassen(matriz11, matriz12) == Vector(Vector(8,5), Vector(20,13)))
  }

  test("multiplicar la matriz1 por la matriz2 dará como resultado: Vector(Vector(80,70,60,50), Vector(240,214,188,162), Vector(400,358,316,274), Vector(2084,1899,1714,1529))") {
    assert(objMatriz.multStrassen(matriz1, matriz2) == Vector(Vector(80, 70, 60, 50), Vector(240, 214, 188, 162), Vector(400, 358, 316, 274), Vector(560, 502, 444, 386)))
  }

  test("multiplicar la matriz3 por la matriz4 dará como resultado: Vector(70, 84, 88, 62, 56, 70, 84, 88), Vector(69, 66, 73, 55, 67, 69, 66, 73), Vector(60, 65, 85, 80, 85, 60, 65, 85), Vector(57, 67, 82, 97, 72, 57, 67, 82), Vector(59, 78, 77, 81, 65, 59, 78, 77), Vector(70, 84, 88, 62, 56, 70, 84, 88), Vector(69, 66, 73, 55, 67, 69, 66, 73), Vector(60, 65, 85, 80, 85, 60, 65, 85))") {
    assert(objMatriz.multStrassen(matriz3, matriz4) == Vector(
      Vector(70, 84, 88, 62, 56, 70, 84, 88), Vector(69, 66, 73, 55, 67, 69, 66, 73), Vector(60, 65, 85, 80, 85, 60, 65, 85), Vector(57, 67, 82, 97, 72, 57, 67, 82), Vector(59, 78, 77, 81, 65, 59, 78, 77), Vector(70, 84, 88, 62, 56, 70, 84, 88), Vector(69, 66, 73, 55, 67, 69, 66, 73), Vector(60, 65, 85, 80, 85, 60, 65, 85)))
  }

  test("multiplicar la matriz5 por la matriz6 dará como resultado: Vector(Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157))") {
    assert(objMatriz.multStrassen(matriz5, matriz6) == Vector(Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157)))
  }

  test("multiplicar la matriz7 por la matriz8 dará como resultado: Vector(Vector(80, 84, 78, 52, 66, 80, 84, 78), Vector(61, 58, 60, 72, 79, 61, 58, 60), Vector(67, 74, 56, 68, 65, 67, 74, 56), Vector(59, 79, 74, 79, 84, 59, 79, 74), Vector(84, 88, 62, 56, 70, 84, 88, 62), Vector(62, 77, 92, 67, 77, 62, 77, 92), Vector(67, 74, 56, 68, 65, 67, 74, 56), Vector(73, 72, 76, 60, 79, 73, 72, 76)) ") {
    assert(objMatriz.multStrassen(matriz7, matriz8) == Vector(Vector(80, 84, 78, 52, 66, 80, 84, 78), Vector(61, 58, 60, 72, 79, 61, 58, 60), Vector(67, 74, 56, 68, 65, 67, 74, 56), Vector(59, 79, 74, 79, 84, 59, 79, 74), Vector(84, 88, 62, 56, 70, 84, 88, 62), Vector(62, 77, 92, 67, 77, 62, 77, 92), Vector(67, 74, 56, 68, 65, 67, 74, 56), Vector(73, 72, 76, 60, 79, 73, 72, 76)) )
  }

  //Multiplicaciones con el algoritmo de Strassen Paralelizado

  test("Multiplicar la matriz11 por la matriz12 dará como resultado: Vector(Vector(8,5), Vector(20,13))") {
    assert(objMatriz.multStrassenPar(matriz11, matriz12) == Vector(Vector(8,5), Vector(20,13)))
  }

  test("Multiplicar la matriz1 por la matriz2 dará como resultado: Vector(Vector(80,70,60,50), Vector(240,214,188,162), Vector(400,358,316,274), Vector(2084,1899,1714,1529))") {
    assert(objMatriz.multStrassenPar(matriz1, matriz2) == Vector(Vector(80, 70, 60, 50), Vector(240, 214, 188, 162), Vector(400, 358, 316, 274), Vector(560, 502, 444, 386)))
  }

  test("Multiplicar la matriz3 por la matriz4 dará como resultado: Vector(70, 84, 88, 62, 56, 70, 84, 88), Vector(69, 66, 73, 55, 67, 69, 66, 73), Vector(60, 65, 85, 80, 85, 60, 65, 85), Vector(57, 67, 82, 97, 72, 57, 67, 82), Vector(59, 78, 77, 81, 65, 59, 78, 77), Vector(70, 84, 88, 62, 56, 70, 84, 88), Vector(69, 66, 73, 55, 67, 69, 66, 73), Vector(60, 65, 85, 80, 85, 60, 65, 85))") {
    assert(objMatriz.multStrassenPar(matriz3, matriz4) == Vector(
      Vector(70, 84, 88, 62, 56, 70, 84, 88), Vector(69, 66, 73, 55, 67, 69, 66, 73), Vector(60, 65, 85, 80, 85, 60, 65, 85), Vector(57, 67, 82, 97, 72, 57, 67, 82), Vector(59, 78, 77, 81, 65, 59, 78, 77), Vector(70, 84, 88, 62, 56, 70, 84, 88), Vector(69, 66, 73, 55, 67, 69, 66, 73), Vector(60, 65, 85, 80, 85, 60, 65, 85)))
  }

  test("Multiplicar la matriz5 por la matriz6 dará como resultado: Vector(Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157))") {
    assert(objMatriz.multStrassenPar(matriz5, matriz6) == Vector(Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157)))
  }

  test("Multiplicar la matriz7 por la matriz8 dará como resultado: Vector(Vector(80, 84, 78, 52, 66, 80, 84, 78), Vector(61, 58, 60, 72, 79, 61, 58, 60), Vector(67, 74, 56, 68, 65, 67, 74, 56), Vector(59, 79, 74, 79, 84, 59, 79, 74), Vector(84, 88, 62, 56, 70, 84, 88, 62), Vector(62, 77, 92, 67, 77, 62, 77, 92), Vector(67, 74, 56, 68, 65, 67, 74, 56), Vector(73, 72, 76, 60, 79, 73, 72, 76)) ") {
    assert(objMatriz.multStrassenPar(matriz7, matriz8) == Vector(Vector(80, 84, 78, 52, 66, 80, 84, 78), Vector(61, 58, 60, 72, 79, 61, 58, 60), Vector(67, 74, 56, 68, 65, 67, 74, 56), Vector(59, 79, 74, 79, 84, 59, 79, 74), Vector(84, 88, 62, 56, 70, 84, 88, 62), Vector(62, 77, 92, 67, 77, 62, 77, 92), Vector(67, 74, 56, 68, 65, 67, 74, 56), Vector(73, 72, 76, 60, 79, 73, 72, 76)) )
  }  

  //Producto punto

  test("El producto punto de los vectores Vector(1,2,3,4,5) y Vector(6,7,8,9,10) es 130") {
    assert(objMatriz.prodPunto(Vector(1,2,3,4,5), Vector(6,7,8,9,10)) == 130)
  }

  test("El producto punto de los vectores Vector(1,2,3,4,5,6) y Vector(7,8,9,10,11,12) es 217") {
    assert(objMatriz.prodPunto(Vector(1,2,3,4,5,6), Vector(7,8,9,10,11,12)) == 217)
  }

  test("El producto punto de los vectores Vector(1,2,3,4,5,6,7) y Vector(8,9,10,11,12,13,14) es 336") {
    assert(objMatriz.prodPunto(Vector(1,2,3,4,5,6,7), Vector(8,9,10,11,12,13,14)) == 336)
  }

  test("El producto punto de los vectores Vector(1,2,3,4,5,6,7,8) y Vector(9,10,11,12,13,14,15,16) es 492") {
    assert(objMatriz.prodPunto(Vector(1,2,3,4,5,6,7,8), Vector(9,10,11,12,13,14,15,16)) == 492)
  }

  test("El producto punto de los vectores Vector(1,2,3,4,5,6,7,8,9) y Vector(10,11,12,13,14,15,16,17,18) es 690") {
    assert(objMatriz.prodPunto(Vector(1,2,3,4,5,6,7,8,9), Vector(10,11,12,13,14,15,16,17,18)) == 690)
  }

  //Pructo punto paralelizado

  test("el producto punto de los vectores Vector(1,2,3,4,5) y Vector(6,7,8,9,10) es 130") {
    assert(objMatriz.prodPuntoParD(Vector(1,2,3,4,5).par, Vector(6,7,8,9,10).par) == 130)
  }

  test("el producto punto de los vectores Vector(1,2,3,4,5,6) y Vector(7,8,9,10,11,12) es 217") {
    assert(objMatriz.prodPuntoParD(Vector(1,2,3,4,5,6).par, Vector(7,8,9,10,11,12).par) == 217)
  }

  test("el producto punto de los vectores Vector(1,2,3,4,5,6,7) y Vector(8,9,10,11,12,13,14) es 336") {
    assert(objMatriz.prodPuntoParD(Vector(1,2,3,4,5,6,7).par, Vector(8,9,10,11,12,13,14).par) == 336)
  }

  test("el producto punto de los vectores Vector(1,2,3,4,5,6,7,8) y Vector(9,10,11,12,13,14,15,16) es 492") {
    assert(objMatriz.prodPuntoParD(Vector(1,2,3,4,5,6,7,8).par, Vector(9,10,11,12,13,14,15,16).par) == 492)
  }

  test("el producto punto de los vectores Vector(1,2,3,4,5,6,7,8,9) y Vector(10,11,12,13,14,15,16,17,18) es 690") {
    assert(objMatriz.prodPuntoParD(Vector(1,2,3,4,5,6,7,8,9).par, Vector(10,11,12,13,14,15,16,17,18).par) == 690)
  }


  //Test de transpuesta

  test("La transpuesta de la matriz 4x4 Vector(Vector(1,2,3,4),Vector(5,6,7,8),Vector(9,10,11,12),Vector(13,14,15,16)) es") {
    assert(objMatriz.transpuesta(Vector(Vector(1,2,3,4),Vector(5,6,7,8),Vector(9,10,11,12),Vector(13,14,15,16))) == Vector(Vector(1,5,9,13),Vector(2,6,10,14),Vector(3,7,11,15),Vector(4,8,12,16)))
  }

  test("La transpuesta de la matriz 3x3 Vector(Vector(1,2,3),Vector(4,5,6),Vector(7,8,9)) es") {
    assert(objMatriz.transpuesta(Vector(Vector(1,2,3),Vector(4,5,6),Vector(7,8,9))) == Vector(Vector(1,4,7),Vector(2,5,8),Vector(3,6,9)))
  }

  test("La transpuesta de la matriz 8x8 Vector(Vector(1, 5, 3, 2, 4, 1, 5, 3), Vector(2, 4, 1, 5, 3, 2, 4, 1), Vector(5, 3, 2, 4, 1, 5, 3, 2), Vector(4, 1, 5, 3, 2, 4, 1, 5), Vector(3, 2, 4, 1, 5, 3, 2, 4), Vector(1, 5, 3, 2, 4, 1, 5, 3), Vector(2, 4, 1, 5, 3, 2, 4, 1), Vector(5, 3, 2, 4, 1, 5, 3, 2)) es") {
    assert(objMatriz.transpuesta(matriz3) == Vector(
      Vector(1, 2, 5, 4, 3, 1, 2, 5),
      Vector(5, 4, 3, 1, 2, 5, 4, 3),
      Vector(3, 1, 2, 5, 4, 3, 1, 2),
      Vector(2, 5, 4, 3, 1, 2, 5, 4),
      Vector(4, 3, 1, 2, 5, 4, 3, 1),
      Vector(1, 2, 5, 4, 3, 1, 2, 5),
      Vector(5, 4, 3, 1, 2, 5, 4, 3),
      Vector(3, 1, 2, 5, 4, 3, 1, 2)
    ))
    }
    //Test de matriz traspuesta de una fila
    test("La transpuesta de la matriz 1x5 Vector(Vector(1,2,3,4,5)) es") {
      assert(objMatriz.transpuesta(Vector(Vector(1,2,3,4,5))) == Vector(Vector(1),Vector(2),Vector(3),Vector(4),Vector(5)))
    }
    //Test de matriz traspuesta de una columna
    test("La transpuesta de la matriz 5x1 Vector(Vector(1),Vector(2),Vector(3),Vector(4),Vector(5)) es") {
      assert(objMatriz.transpuesta(Vector(Vector(1),Vector(2),Vector(3),Vector(4),Vector(5))) == Vector(Vector(1,2,3,4,5)))
    }

    //Test para la funcion subMatriz
    test("La submatriz 2x2 de matriz1 comenzando en (0,0) es") {
      assert(objMatriz.subMatriz(matriz1, 0, 0, 2) == Vector(Vector(1, 2), Vector(5, 6))) 
    }

    test("La submatriz 2x2 de matriz2 comenzando en (1,1) es") {
      assert(objMatriz.subMatriz(matriz2, 1, 1, 2) == Vector(Vector(11, 10), Vector(7, 6)))
    }

    test("La submatriz 4x4 de matriz4 comenzando en (0,0) es") {
      assert(objMatriz.subMatriz(matriz4, 0, 0, 4) == Vector(Vector(1, 2, 3, 4), Vector(3, 4, 5, 1), Vector(2, 3, 4, 5), Vector(5, 1, 2, 3)))
    }

    test("La submatriz 1x1 de matriz1 en la posición (1,1) es") {
      assert(objMatriz.subMatriz(matriz1, 1, 1, 1) == Vector(Vector(6)))
    }

    test("La submatriz 4x4 de matriz5 comenzando en (2,2) es") {
      assert(objMatriz.subMatriz(matriz5, 2, 2, 4) == Vector(
        Vector(5, 1, 2, 3),
        Vector(1, 2, 3, 4),
        Vector(2, 3, 4, 5),
        Vector(3, 4, 5, 1)
      ))
    }

    //Test para la funcion sumaMatriz

    test("La suma de matriz11 y matriz12 es") {
      assert(objMatriz.sumMatriz(matriz11, matriz12) == Vector(Vector(5, 5), Vector(5, 5)))
    }

    test("La suma de matriz1 y matriz2 es") {
      assert(objMatriz.sumMatriz(matriz1, matriz2) == Vector(
        Vector(17, 17, 17, 17),
        Vector(17, 17, 17, 17),
        Vector(17, 17, 17, 17),
        Vector(17, 17, 17, 17)
      ))
    }
    test("Suma de matriz3 y matriz4 dará como resultado Vector(Vector(2, 7, 6, 6, 9, 2, 7, 6), Vector(5, 8, 6, 6, 5, 5, 8, 6), Vector(7, 6, 6, 9, 2, 7, 6, 6), Vector(9, 2, 7, 6, 6, 9, 2, 7), Vector(7, 7, 5, 3, 8, 7, 7, 5), Vector(2, 7, 6, 6, 9, 2, 7, 6), Vector(5, 8, 6, 6, 5, 5, 8, 6), Vector(7, 6, 6, 9, 2, 7, 6, 6)))") {
      assert(objMatriz.sumMatriz(matriz3, matriz4) == Vector(
          Vector(2, 7, 6, 6, 9, 2, 7, 6),
          Vector(5, 8, 6, 6, 5, 5, 8, 6),
          Vector(7, 6, 6, 9, 2, 7, 6, 6),
          Vector(9, 2, 7, 6, 6, 9, 2, 7),
          Vector(7, 7, 5, 3, 8, 7, 7, 5),
          Vector(2, 7, 6, 6, 9, 2, 7, 6),
          Vector(5, 8, 6, 6, 5, 5, 8, 6),
          Vector(7, 6, 6, 9, 2, 7, 6, 6)))
    }

    test("la suma de matriz7 y matriz8 ") {
      assert(objMatriz.sumMatriz(matriz7, matriz8) == Vector(
          Vector(2, 5, 8, 6, 9, 2, 5, 8), 
          Vector(8, 7, 2, 5, 8, 8, 7, 2), 
          Vector(5, 8, 6, 6, 5, 5, 8, 6), 
          Vector(7, 6, 6, 9, 2, 7, 6, 6), 
          Vector(6, 6, 5, 5, 8, 6, 6, 5), 
          Vector(5, 3, 8, 7, 7, 5, 3, 8), 
          Vector(6, 9, 2, 7, 6, 6, 9, 2), 
          Vector(6, 6, 9, 2, 7, 6, 6, 9)))
    }

    test("La suma de matriz5 y matriz6") {
      assert(objMatriz.sumMatriz(matriz5, matriz6) == Vector(
        Vector(2, 7, 6, 6, 9, 2, 7, 6, 6, 9, 2, 7, 6, 6, 9, 2), 
        Vector(6, 4, 9, 8, 3, 6, 4, 9, 8, 3, 6, 4, 9, 8, 3, 6), 
        Vector(5, 8, 6, 6, 5, 5, 8, 6, 6, 5, 5, 8, 6, 6, 5, 5), 
        Vector(7, 7, 5, 3, 8, 7, 7, 5, 3, 8, 7, 7, 5, 3, 8, 7), 
        Vector(10, 4, 4, 7, 5, 10, 4, 4, 7, 5, 10, 4, 4, 7, 5, 10), 
        Vector(2, 7, 6, 6, 9, 2, 7, 6, 6, 9, 2, 7, 6, 6, 9, 2), 
        Vector(6, 4, 9, 8, 3, 6, 4, 9, 8, 3, 6, 4, 9, 8, 3, 6), 
        Vector(5, 8, 6, 6, 5, 5, 8, 6, 6, 5, 5, 8, 6, 6, 5, 5), 
        Vector(7, 7, 5, 3, 8, 7, 7, 5, 3, 8, 7, 7, 5, 3, 8, 7), 
        Vector(10, 4, 4, 7, 5, 10, 4, 4, 7, 5, 10, 4, 4, 7, 5, 10), 
        Vector(2, 7, 6, 6, 9, 2, 7, 6, 6, 9, 2, 7, 6, 6, 9, 2), 
        Vector(6, 4, 9, 8, 3, 6, 4, 9, 8, 3, 6, 4, 9, 8, 3, 6), 
        Vector(5, 8, 6, 6, 5, 5, 8, 6, 6, 5, 5, 8, 6, 6, 5, 5), 
        Vector(7, 7, 5, 3, 8, 7, 7, 5, 3, 8, 7, 7, 5, 3, 8, 7), 
        Vector(10, 4, 4, 7, 5, 10, 4, 4, 7, 5, 10, 4, 4, 7, 5, 10), 
        Vector(2, 7, 6, 6, 9, 2, 7, 6, 6, 9, 2, 7, 6, 6, 9, 2)))
    }

    //Tests para la funcion multMatrizEstandar

    test("La multiplicación de matriz1 y matriz2") {
      assert(objMatriz.multMatrizEstandarSec(matriz1, matriz2) == Vector(
        Vector(80, 70, 60, 50),
        Vector(240, 214, 188, 162),
        Vector(400, 358, 316, 274),
        Vector(560, 502, 444, 386)))
    }

    test("La multiplicación de matriz3 y matriz4") {
      assert(objMatriz.multMatrizEstandarSec(matriz3, matriz4) == Vector(
        Vector(70, 84, 88, 62, 56, 70, 84, 88),
        Vector(69, 66, 73, 55, 67, 69, 66, 73),
        Vector(60, 65, 85, 80, 85, 60, 65, 85),
        Vector(57, 67, 82, 97, 72, 57, 67, 82),
        Vector(59, 78, 77, 81, 65, 59, 78, 77),
        Vector(70, 84, 88, 62, 56, 70, 84, 88),
        Vector(69, 66, 73, 55, 67, 69, 66, 73),
        Vector(60, 65, 85, 80, 85, 60, 65, 85)))
    }

    test("La multiplicación de matriz5 y matriz6") {
      assert(objMatriz.multMatrizEstandarSec(matriz5, matriz6) == Vector(
        Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157),
        Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128),
        Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129),
        Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145),
        Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131),
        Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157),
        Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128),
        Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129),
        Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145),
        Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131),
        Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157),
        Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128),
        Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129),
        Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145),
        Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131),
        Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157)))
    }

    test("La multiplicación de matriz7 y matriz8") {
      assert(objMatriz.multMatrizEstandarSec(matriz7, matriz8) == Vector(
        Vector(80, 84, 78, 52, 66, 80, 84, 78),
        Vector(61, 58, 60, 72, 79, 61, 58, 60),
        Vector(67, 74, 56, 68, 65, 67, 74, 56),
        Vector(59, 79, 74, 79, 84, 59, 79, 74),
        Vector(84, 88, 62, 56, 70, 84, 88, 62),
        Vector(62, 77, 92, 67, 77, 62, 77, 92),
        Vector(67, 74, 56, 68, 65, 67, 74, 56),
        Vector(73, 72, 76, 60, 79, 73, 72, 76))
      )
    }

    test("La multiplicacion de matriz9 y matriz10") {
      assert(objMatriz.multMatrizEstandarSec(matriz9, matriz10) == Vector(
        Vector(812, 840, 868, 896, 924, 952, 980), 
        Vector(1890, 1967, 2044, 2121, 2198, 2275, 2352), 
        Vector(2968, 3094, 3220, 3346, 3472, 3598, 3724), 
        Vector(4046, 4221, 4396, 4571, 4746, 4921, 5096), 
        Vector(5124, 5348, 5572, 5796, 6020, 6244, 6468), 
        Vector(6202, 6475, 6748, 7021, 7294, 7567, 7840), 
        Vector(7280, 7602, 7924, 8246, 8568, 8890, 9212)))
    }

    //Tests para la funcion multMatrizEstandarPar
    
    test("Multiplicar la matriz11 por la matriz12 usando multMatrizEstandarpar") {
      assert(objMatriz.multMatrizEstandarPar(matriz11, matriz12) == Vector(Vector(8, 5), Vector(20, 13)))
    }

    test("Multiplicar la matriz1 por la matriz2 usando multMatrizEstandarpar") {
      assert(objMatriz.multMatrizEstandarPar(matriz1, matriz2) == Vector(
        Vector(80, 70, 60, 50),
        Vector(240, 214, 188, 162),
        Vector(400, 358, 316, 274),
        Vector(560, 502, 444, 386)
      ))
    }

    test("Multiplicar la matriz3 por la matriz4 usando multMatrizEstandarpar") {
      assert(objMatriz.multMatrizEstandarPar(matriz3, matriz4) == Vector(
        Vector(70, 84, 88, 62, 56, 70, 84, 88), 
        Vector(69, 66, 73, 55, 67, 69, 66, 73), 
        Vector(60, 65, 85, 80, 85, 60, 65, 85), 
        Vector(57, 67, 82, 97, 72, 57, 67, 82), 
        Vector(59, 78, 77, 81, 65, 59, 78, 77), 
        Vector(70, 84, 88, 62, 56, 70, 84, 88), 
        Vector(69, 66, 73, 55, 67, 69, 66, 73), 
        Vector(60, 65, 85, 80, 85, 60, 65, 85)))
    }

    test("Multiplicar la matriz5 por la matriz6 usando multMatrizEstandarpar") {
      assert(objMatriz.multMatrizEstandarPar(matriz5, matriz6) == Vector(
        Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), 
        Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), 
        Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), 
        Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), 
        Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), 
        Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), 
        Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), 
        Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), 
        Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), 
        Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), 
        Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157), 
        Vector(128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128, 136, 147, 130, 164, 128), 
        Vector(129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129, 156, 135, 162, 138, 129), 
        Vector(145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145, 146, 168, 134, 142, 145), 
        Vector(131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131, 181, 141, 136, 161, 131), 
        Vector(157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157, 131, 129, 143, 130, 157)))
    }


    test("Multiplicar la matriz7 por la matriz8 usando multMatrizEstandarpar") {
      assert(objMatriz.multMatrizEstandarPar(matriz7, matriz8) == Vector(
        Vector(80, 84, 78, 52, 66, 80, 84, 78), 
        Vector(61, 58, 60, 72, 79, 61, 58, 60), 
        Vector(67, 74, 56, 68, 65, 67, 74, 56), 
        Vector(59, 79, 74, 79, 84, 59, 79, 74), 
        Vector(84, 88, 62, 56, 70, 84, 88, 62), 
        Vector(62, 77, 92, 67, 77, 62, 77, 92), 
        Vector(67, 74, 56, 68, 65, 67, 74, 56), 
        Vector(73, 72, 76, 60, 79, 73, 72, 76)))
    }

}
