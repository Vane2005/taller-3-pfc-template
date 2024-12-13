package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RegadoTest extends AnyFunSuite {

  val objregado = new Regado()

  val finca1: Vector[(Int, Int, Int)] = Vector(
      (12, 4, 3), // Tablón 0: tsi = 12, tri = 4, pi = 3
      (10, 3, 2), // Tablón 1: tsi = 10, tri = 3, pi = 2
      (15, 5, 1)  // Tablón 2: tsi = 15, tri = 5, pi = 1
  )
  val progRiego1 = Vector(2, 1, 0)

  val finca2: Vector[(Int, Int, Int)] = Vector(
      (10, 3, 1), // Tablón 0: tsi = 10, tri = 3, pi = 1
      (15, 5, 2), // Tablón 1: tsi = 15, tri = 5, pi = 2
      (8, 2, 3),  // Tablón 2: tsi = 8,  tri = 2, pi = 3
      (12, 4, 4)  // Tablón 3: tsi = 12, tri = 4, pi = 4
  )
  val progRiego2 = Vector(2, 1, 0, 3)

  val finca3: Vector[(Int, Int, Int)] = Vector(
      (10, 3, 2), // Tablón 0: tsi = 10, tri = 3, pi = 2
      (15, 4, 1), // Tablón 1: tsi = 15, tri = 4, pi = 1
      (20, 2, 3), // Tablón 2: tsi = 20, tri = 2, pi = 3
      (8, 5, 4),  // Tablón 3: tsi = 8,  tri = 5, pi = 4
      (12, 3, 2)  // Tablón 4: tsi = 12, tri = 3, pi = 2
  )
  val progRiego3 = Vector(4, 1, 0, 3, 2)

  val finca4: Vector[(Int, Int, Int)] = Vector(
      (14, 5, 1), // Tablón 0: tsi = 14, tri = 5, pi = 1
      (10, 3, 2), // Tablón 1: tsi = 10, tri = 3, pi = 2
      (18, 6, 3), // Tablón 2: tsi = 18, tri = 6, pi = 3
      (12, 4, 4), // Tablón 3: tsi = 12, tri = 4, pi = 4
      (16, 7, 2), // Tablón 4: tsi = 16, tri = 7, pi = 2
      (20, 8, 1)  // Tablón 5: tsi = 20, tri = 8, pi = 1
  )
  val progRiego4 = Vector(5, 0, 1, 3, 2, 4)

  val finca5: Vector[(Int, Int, Int)] = Vector(
      (12, 4, 1), // Tablón 0: tsi = 12, tri = 4, pi = 1
      (18, 6, 3), // Tablón 1: tsi = 18, tri = 6, pi = 3
      (10, 3, 2), // Tablón 2: tsi = 10, tri = 3, pi = 2
      (15, 5, 4), // Tablón 3: tsi = 15, tri = 5, pi = 4
      (20, 7, 1), // Tablón 4: tsi = 20, tri = 7, pi = 1
      (14, 4, 3), // Tablón 5: tsi = 14, tri = 4, pi = 3
      (16, 6, 2)  // Tablón 6: tsi = 16, tri = 6, pi = 2
  )
  val progRiego5 = Vector(2, 6, 5, 0, 3, 1, 4)

  val finca6: Vector[(Int, Int, Int)] = Vector(
    (10, 3, 2), // Tablón 0: tsi = 10, tri = 3, pi = 2
    (5, 2, 1)  // Tablón 1: tsi = 5, tri = 2, pi = 1
  )

  val finca7: Vector[(Int, Int, Int)] = Vector(
    (10, 3, 2), // Tablón 0: tsi = 10, tri = 3, pi = 2
    (17, 2, 1),  // Tablón 1: tsi = 17, tri = 2, pi = 1
    (15, 5, 3)  // Tablón 2: tsi = 15, tri = 5, pi = 3
  )
  //Funcion costoRiegoFinca VERSION SECUENCIAL
  test("costo de riego de finca1 da como resultado: 12") {
    assert(objregado.costoRiegoFinca(finca1, progRiego1) == 12)
  }

  test("costo de riego de finca2 da como resultado: 22") {
    assert(objregado.costoRiegoFincaPar(finca2, progRiego2) == 22)
  }

  test("costo de riego de finca3 da como resultado: 48") {
    assert(objregado.costoRiegoFinca(finca3, progRiego3) == 48)
  }

  test("costo de riego de finca4 da como resultado: 115") {
    assert(objregado.costoRiegoFincaPar(finca4, progRiego4) == 115)
  }

  test("costo de riego de finca5 da como resultado: 93") {
    assert(objregado.costoRiegoFinca(finca5, progRiego5) == 93)
  }

  //Funcion costoRiegoFinca VERSION PARALELA
  test("costo de riego de finca1 paralelo da como resultado: 12") {
      assert(objregado.costoRiegoFincaPar(finca1, progRiego1) == 12)
  }

  test("costo de riego de finca2 paralelo da como resultado: 22") {
      assert(objregado.costoRiegoFincaPar(finca2, progRiego2) == 22)
  }

  test("costo de riego de finca3 paralelo da como resultado: 48") {
      assert(objregado.costoRiegoFincaPar(finca3, progRiego3) == 48)
  }

  test("costo de riego de finca4 paralelo da como resultado: 115") {
      assert(objregado.costoRiegoFincaPar(finca4, progRiego4) == 115)
  }

  test("costo de riego de finca5 paralelo da como resultado: 93") {
      assert(objregado.costoRiegoFincaPar(finca5, progRiego5) == 93)
  }
  
  //Funcion generarProgramacionesRiego VERSION SECUENCIAL
  test("generar programaciones de riego para finca1 ") {
    assert(objregado.generarProgramacionesRiego(finca1) == Vector(
      Vector(0, 1, 2), 
      Vector(0, 2, 1), 
      Vector(1, 0, 2), 
      Vector(1, 2, 0), 
      Vector(2, 0, 1), 
      Vector(2, 1, 0)))
  }

  test("generar programaciones de riego para finca2 da como resultado: Vector(Vector(0, 1, 2, 3), Vector(0, 1, 3, 2), Vector(0, 2, 1, 3), Vector(0, 2, 3, 1), Vector(0, 3, 1, 2), Vector(0, 3, 2, 1), Vector(1, 0, 2, 3), Vector(1, 0, 3, 2), Vector(1, 2, 0, 3), Vector(1, 2, 3, 0), Vector(1, 3, 0, 2), Vector(1, 3, 2, 0), Vector(2, 0, 1, 3), Vector(2, 0, 3, 1), Vector(2, 1, 0, 3), Vector(2, 1, 3, 0), Vector(2, 3, 0, 1), Vector(2, 3, 1, 0), Vector(3, 0, 1, 2), Vector(3, 0, 2, 1), Vector(3, 1, 0, 2), Vector(3, 1, 2, 0), Vector(3, 2, 0, 1), Vector(3, 2, 1, 0))") {
    assert(objregado.generarProgramacionesRiego(finca2) == Vector(
      Vector(0, 1, 2, 3), 
      Vector(0, 1, 3, 2), 
      Vector(0, 2, 1, 3), 
      Vector(0, 2, 3, 1), 
      Vector(0, 3, 1, 2), 
      Vector(0, 3, 2, 1), 
      Vector(1, 0, 2, 3), 
      Vector(1, 0, 3, 2), 
      Vector(1, 2, 0, 3), 
      Vector(1, 2, 3, 0), 
      Vector(1, 3, 0, 2), 
      Vector(1, 3, 2, 0), 
      Vector(2, 0, 1, 3), 
      Vector(2, 0, 3, 1), 
      Vector(2, 1, 0, 3), 
      Vector(2, 1, 3, 0), 
      Vector(2, 3, 0, 1), 
      Vector(2, 3, 1, 0), 
      Vector(3, 0, 1, 2), 
      Vector(3, 0, 2, 1), 
      Vector(3, 1, 0, 2), 
      Vector(3, 1, 2, 0), 
      Vector(3, 2, 0, 1), 
      Vector(3, 2, 1, 0)))
  }
  test("generar programaciones de riego para finca3"){
    assert(objregado.generarProgramacionesRiego(finca3) == Vector(
      Vector(0, 1, 2, 3, 4), 
      Vector(0, 1, 2, 4, 3), 
      Vector(0, 1, 3, 2, 4), 
      Vector(0, 1, 3, 4, 2), 
      Vector(0, 1, 4, 2, 3), 
      Vector(0, 1, 4, 3, 2), 
      Vector(0, 2, 1, 3, 4), 
      Vector(0, 2, 1, 4, 3), 
      Vector(0, 2, 3, 1, 4), 
      Vector(0, 2, 3, 4, 1), 
      Vector(0, 2, 4, 1, 3), 
      Vector(0, 2, 4, 3, 1), 
      Vector(0, 3, 1, 2, 4), 
      Vector(0, 3, 1, 4, 2), 
      Vector(0, 3, 2, 1, 4), 
      Vector(0, 3, 2, 4, 1), 
      Vector(0, 3, 4, 1, 2), 
      Vector(0, 3, 4, 2, 1), 
      Vector(0, 4, 1, 2, 3), 
      Vector(0, 4, 1, 3, 2), 
      Vector(0, 4, 2, 1, 3), 
      Vector(0, 4, 2, 3, 1), 
      Vector(0, 4, 3, 1, 2), 
      Vector(0, 4, 3, 2, 1), 
      Vector(1, 0, 2, 3, 4), 
      Vector(1, 0, 2, 4, 3), 
      Vector(1, 0, 3, 2, 4), 
      Vector(1, 0, 3, 4, 2), 
      Vector(1, 0, 4, 2, 3), 
      Vector(1, 0, 4, 3, 2), 
      Vector(1, 2, 0, 3, 4), 
      Vector(1, 2, 0, 4, 3), 
      Vector(1, 2, 3, 0, 4), 
      Vector(1, 2, 3, 4, 0), 
      Vector(1, 2, 4, 0, 3), 
      Vector(1, 2, 4, 3, 0), 
      Vector(1, 3, 0, 2, 4), 
      Vector(1, 3, 0, 4, 2), 
      Vector(1, 3, 2, 0, 4), 
      Vector(1, 3, 2, 4, 0), 
      Vector(1, 3, 4, 0, 2), 
      Vector(1, 3, 4, 2, 0), 
      Vector(1, 4, 0, 2, 3), 
      Vector(1, 4, 0, 3, 2), 
      Vector(1, 4, 2, 0, 3), 
      Vector(1, 4, 2, 3, 0), 
      Vector(1, 4, 3, 0, 2), 
      Vector(1, 4, 3, 2, 0), 
      Vector(2, 0, 1, 3, 4), 
      Vector(2, 0, 1, 4, 3), 
      Vector(2, 0, 3, 1, 4), 
      Vector(2, 0, 3, 4, 1), 
      Vector(2, 0, 4, 1, 3), 
      Vector(2, 0, 4, 3, 1), 
      Vector(2, 1, 0, 3, 4), 
      Vector(2, 1, 0, 4, 3), 
      Vector(2, 1, 3, 0, 4), 
      Vector(2, 1, 3, 4, 0), 
      Vector(2, 1, 4, 0, 3), 
      Vector(2, 1, 4, 3, 0), 
      Vector(2, 3, 0, 1, 4), 
      Vector(2, 3, 0, 4, 1), 
      Vector(2, 3, 1, 0, 4), 
      Vector(2, 3, 1, 4, 0), 
      Vector(2, 3, 4, 0, 1), 
      Vector(2, 3, 4, 1, 0), 
      Vector(2, 4, 0, 1, 3), 
      Vector(2, 4, 0, 3, 1), 
      Vector(2, 4, 1, 0, 3), 
      Vector(2, 4, 1, 3, 0), 
      Vector(2, 4, 3, 0, 1), 
      Vector(2, 4, 3, 1, 0), 
      Vector(3, 0, 1, 2, 4), 
      Vector(3, 0, 1, 4, 2), 
      Vector(3, 0, 2, 1, 4), 
      Vector(3, 0, 2, 4, 1), 
      Vector(3, 0, 4, 1, 2), 
      Vector(3, 0, 4, 2, 1), 
      Vector(3, 1, 0, 2, 4), 
      Vector(3, 1, 0, 4, 2), 
      Vector(3, 1, 2, 0, 4), 
      Vector(3, 1, 2, 4, 0), 
      Vector(3, 1, 4, 0, 2), 
      Vector(3, 1, 4, 2, 0), 
      Vector(3, 2, 0, 1, 4), 
      Vector(3, 2, 0, 4, 1), 
      Vector(3, 2, 1, 0, 4), 
      Vector(3, 2, 1, 4, 0), 
      Vector(3, 2, 4, 0, 1), 
      Vector(3, 2, 4, 1, 0), 
      Vector(3, 4, 0, 1, 2), 
      Vector(3, 4, 0, 2, 1), 
      Vector(3, 4, 1, 0, 2), 
      Vector(3, 4, 1, 2, 0), 
      Vector(3, 4, 2, 0, 1), 
      Vector(3, 4, 2, 1, 0), 
      Vector(4, 0, 1, 2, 3), 
      Vector(4, 0, 1, 3, 2), 
      Vector(4, 0, 2, 1, 3), 
      Vector(4, 0, 2, 3, 1), 
      Vector(4, 0, 3, 1, 2), 
      Vector(4, 0, 3, 2, 1), 
      Vector(4, 1, 0, 2, 3), 
      Vector(4, 1, 0, 3, 2), 
      Vector(4, 1, 2, 0, 3), 
      Vector(4, 1, 2, 3, 0), 
      Vector(4, 1, 3, 0, 2), 
      Vector(4, 1, 3, 2, 0), 
      Vector(4, 2, 0, 1, 3), 
      Vector(4, 2, 0, 3, 1), 
      Vector(4, 2, 1, 0, 3), 
      Vector(4, 2, 1, 3, 0), 
      Vector(4, 2, 3, 0, 1), 
      Vector(4, 2, 3, 1, 0), 
      Vector(4, 3, 0, 1, 2), 
      Vector(4, 3, 0, 2, 1), 
      Vector(4, 3, 1, 0, 2), 
      Vector(4, 3, 1, 2, 0), 
      Vector(4, 3, 2, 0, 1), 
      Vector(4, 3, 2, 1, 0)))
  }


  test("generar programaciones de riego para finca6 da como resultado: Vector(Vector(0, 1), Vector(1, 0))") {
    assert(objregado.generarProgramacionesRiego(finca6) == Vector(
      Vector(0, 1), 
      Vector(1, 0)))
  }

 
  test("generar programaciones de riego para finca4"){
    assert(objregado.generarProgramacionesRiego(finca4) == Vector(
      Vector(0, 1, 2, 3, 4, 5), Vector(0, 1, 2, 3, 5, 4), Vector(0, 1, 2, 4, 3, 5), Vector(0, 1, 2, 4, 5, 3), 
      Vector(0, 1, 2, 5, 3, 4), Vector(0, 1, 2, 5, 4, 3), Vector(0, 1, 3, 2, 4, 5), Vector(0, 1, 3, 2, 5, 4), 
      Vector(0, 1, 3, 4, 2, 5), Vector(0, 1, 3, 4, 5, 2), Vector(0, 1, 3, 5, 2, 4), Vector(0, 1, 3, 5, 4, 2), 
      Vector(0, 1, 4, 2, 3, 5), Vector(0, 1, 4, 2, 5, 3), Vector(0, 1, 4, 3, 2, 5), Vector(0, 1, 4, 3, 5, 2), 
      Vector(0, 1, 4, 5, 2, 3), Vector(0, 1, 4, 5, 3, 2), Vector(0, 1, 5, 2, 3, 4), Vector(0, 1, 5, 2, 4, 3), 
      Vector(0, 1, 5, 3, 2, 4), Vector(0, 1, 5, 3, 4, 2), Vector(0, 1, 5, 4, 2, 3), Vector(0, 1, 5, 4, 3, 2), 
      Vector(0, 2, 1, 3, 4, 5), Vector(0, 2, 1, 3, 5, 4), Vector(0, 2, 1, 4, 3, 5), Vector(0, 2, 1, 4, 5, 3), 
      Vector(0, 2, 1, 5, 3, 4), Vector(0, 2, 1, 5, 4, 3), Vector(0, 2, 3, 1, 4, 5), Vector(0, 2, 3, 1, 5, 4), 
      Vector(0, 2, 3, 4, 1, 5), Vector(0, 2, 3, 4, 5, 1), Vector(0, 2, 3, 5, 1, 4), Vector(0, 2, 3, 5, 4, 1), 
      Vector(0, 2, 4, 1, 3, 5), Vector(0, 2, 4, 1, 5, 3), Vector(0, 2, 4, 3, 1, 5), Vector(0, 2, 4, 3, 5, 1), 
      Vector(0, 2, 4, 5, 1, 3), Vector(0, 2, 4, 5, 3, 1), Vector(0, 2, 5, 1, 3, 4), Vector(0, 2, 5, 1, 4, 3), 
      Vector(0, 2, 5, 3, 1, 4), Vector(0, 2, 5, 3, 4, 1), Vector(0, 2, 5, 4, 1, 3), Vector(0, 2, 5, 4, 3, 1), 
      Vector(0, 3, 1, 2, 4, 5), Vector(0, 3, 1, 2, 5, 4), Vector(0, 3, 1, 4, 2, 5), Vector(0, 3, 1, 4, 5, 2), 
      Vector(0, 3, 1, 5, 2, 4), Vector(0, 3, 1, 5, 4, 2), Vector(0, 3, 2, 1, 4, 5), Vector(0, 3, 2, 1, 5, 4), 
      Vector(0, 3, 2, 4, 1, 5), Vector(0, 3, 2, 4, 5, 1), Vector(0, 3, 2, 5, 1, 4), Vector(0, 3, 2, 5, 4, 1), 
      Vector(0, 3, 4, 1, 2, 5), Vector(0, 3, 4, 1, 5, 2), Vector(0, 3, 4, 2, 1, 5), Vector(0, 3, 4, 2, 5, 1), 
      Vector(0, 3, 4, 5, 1, 2), Vector(0, 3, 4, 5, 2, 1), Vector(0, 3, 5, 1, 2, 4), Vector(0, 3, 5, 1, 4, 2), 
      Vector(0, 3, 5, 2, 1, 4), Vector(0, 3, 5, 2, 4, 1), Vector(0, 3, 5, 4, 1, 2), Vector(0, 3, 5, 4, 2, 1), 
      Vector(0, 4, 1, 2, 3, 5), Vector(0, 4, 1, 2, 5, 3), Vector(0, 4, 1, 3, 2, 5), Vector(0, 4, 1, 3, 5, 2), 
      Vector(0, 4, 1, 5, 2, 3), Vector(0, 4, 1, 5, 3, 2), Vector(0, 4, 2, 1, 3, 5), Vector(0, 4, 2, 1, 5, 3), 
      Vector(0, 4, 2, 3, 1, 5), Vector(0, 4, 2, 3, 5, 1), Vector(0, 4, 2, 5, 1, 3), Vector(0, 4, 2, 5, 3, 1), 
      Vector(0, 4, 3, 1, 2, 5), Vector(0, 4, 3, 1, 5, 2), Vector(0, 4, 3, 2, 1, 5), Vector(0, 4, 3, 2, 5, 1), 
      Vector(0, 4, 3, 5, 1, 2), Vector(0, 4, 3, 5, 2, 1), Vector(0, 4, 5, 1, 2, 3), Vector(0, 4, 5, 1, 3, 2), 
      Vector(0, 4, 5, 2, 1, 3), Vector(0, 4, 5, 2, 3, 1), Vector(0, 4, 5, 3, 1, 2), Vector(0, 4, 5, 3, 2, 1), 
      Vector(0, 5, 1, 2, 3, 4), Vector(0, 5, 1, 2, 4, 3), Vector(0, 5, 1, 3, 2, 4), Vector(0, 5, 1, 3, 4, 2), 
      Vector(0, 5, 1, 4, 2, 3), Vector(0, 5, 1, 4, 3, 2), Vector(0, 5, 2, 1, 3, 4), Vector(0, 5, 2, 1, 4, 3), 
      Vector(0, 5, 2, 3, 1, 4), Vector(0, 5, 2, 3, 4, 1), Vector(0, 5, 2, 4, 1, 3), Vector(0, 5, 2, 4, 3, 1), 
      Vector(0, 5, 3, 1, 2, 4), Vector(0, 5, 3, 1, 4, 2), Vector(0, 5, 3, 2, 1, 4), Vector(0, 5, 3, 2, 4, 1), 
      Vector(0, 5, 3, 4, 1, 2), Vector(0, 5, 3, 4, 2, 1), Vector(0, 5, 4, 1, 2, 3), Vector(0, 5, 4, 1, 3, 2), 
      Vector(0, 5, 4, 2, 1, 3), Vector(0, 5, 4, 2, 3, 1), Vector(0, 5, 4, 3, 1, 2), Vector(0, 5, 4, 3, 2, 1), 
      Vector(1, 0, 2, 3, 4, 5), Vector(1, 0, 2, 3, 5, 4), Vector(1, 0, 2, 4, 3, 5), Vector(1, 0, 2, 4, 5, 3), 
      Vector(1, 0, 2, 5, 3, 4), Vector(1, 0, 2, 5, 4, 3), Vector(1, 0, 3, 2, 4, 5), Vector(1, 0, 3, 2, 5, 4), 
      Vector(1, 0, 3, 4, 2, 5), Vector(1, 0, 3, 4, 5, 2), Vector(1, 0, 3, 5, 2, 4), Vector(1, 0, 3, 5, 4, 2), 
      Vector(1, 0, 4, 2, 3, 5), Vector(1, 0, 4, 2, 5, 3), Vector(1, 0, 4, 3, 2, 5), Vector(1, 0, 4, 3, 5, 2), 
      Vector(1, 0, 4, 5, 2, 3), Vector(1, 0, 4, 5, 3, 2), Vector(1, 0, 5, 2, 3, 4), Vector(1, 0, 5, 2, 4, 3), 
      Vector(1, 0, 5, 3, 2, 4), Vector(1, 0, 5, 3, 4, 2), Vector(1, 0, 5, 4, 2, 3), Vector(1, 0, 5, 4, 3, 2), 
      Vector(1, 2, 0, 3, 4, 5), Vector(1, 2, 0, 3, 5, 4), Vector(1, 2, 0, 4, 3, 5), Vector(1, 2, 0, 4, 5, 3), 
      Vector(1, 2, 0, 5, 3, 4), Vector(1, 2, 0, 5, 4, 3), Vector(1, 2, 3, 0, 4, 5), Vector(1, 2, 3, 0, 5, 4), 
      Vector(1, 2, 3, 4, 0, 5), Vector(1, 2, 3, 4, 5, 0), Vector(1, 2, 3, 5, 0, 4), Vector(1, 2, 3, 5, 4, 0), 
      Vector(1, 2, 4, 0, 3, 5), Vector(1, 2, 4, 0, 5, 3), Vector(1, 2, 4, 3, 0, 5), Vector(1, 2, 4, 3, 5, 0), 
      Vector(1, 2, 4, 5, 0, 3), Vector(1, 2, 4, 5, 3, 0), Vector(1, 2, 5, 0, 3, 4), Vector(1, 2, 5, 0, 4, 3), 
      Vector(1, 2, 5, 3, 0, 4), Vector(1, 2, 5, 3, 4, 0), Vector(1, 2, 5, 4, 0, 3), Vector(1, 2, 5, 4, 3, 0), 
      Vector(1, 3, 0, 2, 4, 5), Vector(1, 3, 0, 2, 5, 4), Vector(1, 3, 0, 4, 2, 5), Vector(1, 3, 0, 4, 5, 2), 
      Vector(1, 3, 0, 5, 2, 4), Vector(1, 3, 0, 5, 4, 2), Vector(1, 3, 2, 0, 4, 5), Vector(1, 3, 2, 0, 5, 4), 
      Vector(1, 3, 2, 4, 0, 5), Vector(1, 3, 2, 4, 5, 0), Vector(1, 3, 2, 5, 0, 4), Vector(1, 3, 2, 5, 4, 0), 
      Vector(1, 3, 4, 0, 2, 5), Vector(1, 3, 4, 0, 5, 2), Vector(1, 3, 4, 2, 0, 5), Vector(1, 3, 4, 2, 5, 0), 
      Vector(1, 3, 4, 5, 0, 2), Vector(1, 3, 4, 5, 2, 0), Vector(1, 3, 5, 0, 2, 4), Vector(1, 3, 5, 0, 4, 2), 
      Vector(1, 3, 5, 2, 0, 4), Vector(1, 3, 5, 2, 4, 0), Vector(1, 3, 5, 4, 0, 2), Vector(1, 3, 5, 4, 2, 0), 
      Vector(1, 4, 0, 2, 3, 5), Vector(1, 4, 0, 2, 5, 3), Vector(1, 4, 0, 3, 2, 5), Vector(1, 4, 0, 3, 5, 2), 
      Vector(1, 4, 0, 5, 2, 3), Vector(1, 4, 0, 5, 3, 2), Vector(1, 4, 2, 0, 3, 5), Vector(1, 4, 2, 0, 5, 3), 
      Vector(1, 4, 2, 3, 0, 5), Vector(1, 4, 2, 3, 5, 0), Vector(1, 4, 2, 5, 0, 3), Vector(1, 4, 2, 5, 3, 0), 
      Vector(1, 4, 3, 0, 2, 5), Vector(1, 4, 3, 0, 5, 2), Vector(1, 4, 3, 2, 0, 5), Vector(1, 4, 3, 2, 5, 0), 
      Vector(1, 4, 3, 5, 0, 2), Vector(1, 4, 3, 5, 2, 0), Vector(1, 4, 5, 0, 2, 3), Vector(1, 4, 5, 0, 3, 2), 
      Vector(1, 4, 5, 2, 0, 3), Vector(1, 4, 5, 2, 3, 0), Vector(1, 4, 5, 3, 0, 2), Vector(1, 4, 5, 3, 2, 0), 
      Vector(1, 5, 0, 2, 3, 4), Vector(1, 5, 0, 2, 4, 3), Vector(1, 5, 0, 3, 2, 4), Vector(1, 5, 0, 3, 4, 2), 
      Vector(1, 5, 0, 4, 2, 3), Vector(1, 5, 0, 4, 3, 2), Vector(1, 5, 2, 0, 3, 4), Vector(1, 5, 2, 0, 4, 3), 
      Vector(1, 5, 2, 3, 0, 4), Vector(1, 5, 2, 3, 4, 0), Vector(1, 5, 2, 4, 0, 3), Vector(1, 5, 2, 4, 3, 0), 
      Vector(1, 5, 3, 0, 2, 4), Vector(1, 5, 3, 0, 4, 2), Vector(1, 5, 3, 2, 0, 4), Vector(1, 5, 3, 2, 4, 0), 
      Vector(1, 5, 3, 4, 0, 2), Vector(1, 5, 3, 4, 2, 0), Vector(1, 5, 4, 0, 2, 3), Vector(1, 5, 4, 0, 3, 2), 
      Vector(1, 5, 4, 2, 0, 3), Vector(1, 5, 4, 2, 3, 0), Vector(1, 5, 4, 3, 0, 2), Vector(1, 5, 4, 3, 2, 0), 
      Vector(2, 0, 1, 3, 4, 5), Vector(2, 0, 1, 3, 5, 4), Vector(2, 0, 1, 4, 3, 5), Vector(2, 0, 1, 4, 5, 3), 
      Vector(2, 0, 1, 5, 3, 4), Vector(2, 0, 1, 5, 4, 3), Vector(2, 0, 3, 1, 4, 5), Vector(2, 0, 3, 1, 5, 4), 
      Vector(2, 0, 3, 4, 1, 5), Vector(2, 0, 3, 4, 5, 1), Vector(2, 0, 3, 5, 1, 4), Vector(2, 0, 3, 5, 4, 1), 
      Vector(2, 0, 4, 1, 3, 5), Vector(2, 0, 4, 1, 5, 3), Vector(2, 0, 4, 3, 1, 5), Vector(2, 0, 4, 3, 5, 1), 
      Vector(2, 0, 4, 5, 1, 3), Vector(2, 0, 4, 5, 3, 1), Vector(2, 0, 5, 1, 3, 4), Vector(2, 0, 5, 1, 4, 3), 
      Vector(2, 0, 5, 3, 1, 4), Vector(2, 0, 5, 3, 4, 1), Vector(2, 0, 5, 4, 1, 3), Vector(2, 0, 5, 4, 3, 1), 
      Vector(2, 1, 0, 3, 4, 5), Vector(2, 1, 0, 3, 5, 4), Vector(2, 1, 0, 4, 3, 5), Vector(2, 1, 0, 4, 5, 3), 
      Vector(2, 1, 0, 5, 3, 4), Vector(2, 1, 0, 5, 4, 3), Vector(2, 1, 3, 0, 4, 5), Vector(2, 1, 3, 0, 5, 4), 
      Vector(2, 1, 3, 4, 0, 5), Vector(2, 1, 3, 4, 5, 0), Vector(2, 1, 3, 5, 0, 4), Vector(2, 1, 3, 5, 4, 0), 
      Vector(2, 1, 4, 0, 3, 5), Vector(2, 1, 4, 0, 5, 3), Vector(2, 1, 4, 3, 0, 5), Vector(2, 1, 4, 3, 5, 0), 
      Vector(2, 1, 4, 5, 0, 3), Vector(2, 1, 4, 5, 3, 0), Vector(2, 1, 5, 0, 3, 4), Vector(2, 1, 5, 0, 4, 3), 
      Vector(2, 1, 5, 3, 0, 4), Vector(2, 1, 5, 3, 4, 0), Vector(2, 1, 5, 4, 0, 3), Vector(2, 1, 5, 4, 3, 0), 
      Vector(2, 3, 0, 1, 4, 5), Vector(2, 3, 0, 1, 5, 4), Vector(2, 3, 0, 4, 1, 5), Vector(2, 3, 0, 4, 5, 1), 
      Vector(2, 3, 0, 5, 1, 4), Vector(2, 3, 0, 5, 4, 1), Vector(2, 3, 1, 0, 4, 5), Vector(2, 3, 1, 0, 5, 4), 
      Vector(2, 3, 1, 4, 0, 5), Vector(2, 3, 1, 4, 5, 0), Vector(2, 3, 1, 5, 0, 4), Vector(2, 3, 1, 5, 4, 0), 
      Vector(2, 3, 4, 0, 1, 5), Vector(2, 3, 4, 0, 5, 1), Vector(2, 3, 4, 1, 0, 5), Vector(2, 3, 4, 1, 5, 0), 
      Vector(2, 3, 4, 5, 0, 1), Vector(2, 3, 4, 5, 1, 0), Vector(2, 3, 5, 0, 1, 4), Vector(2, 3, 5, 0, 4, 1), 
      Vector(2, 3, 5, 1, 0, 4), Vector(2, 3, 5, 1, 4, 0), Vector(2, 3, 5, 4, 0, 1), Vector(2, 3, 5, 4, 1, 0), 
      Vector(2, 4, 0, 1, 3, 5), Vector(2, 4, 0, 1, 5, 3), Vector(2, 4, 0, 3, 1, 5), Vector(2, 4, 0, 3, 5, 1), 
      Vector(2, 4, 0, 5, 1, 3), Vector(2, 4, 0, 5, 3, 1), Vector(2, 4, 1, 0, 3, 5), Vector(2, 4, 1, 0, 5, 3), 
      Vector(2, 4, 1, 3, 0, 5), Vector(2, 4, 1, 3, 5, 0), Vector(2, 4, 1, 5, 0, 3), Vector(2, 4, 1, 5, 3, 0), 
      Vector(2, 4, 3, 0, 1, 5), Vector(2, 4, 3, 0, 5, 1), Vector(2, 4, 3, 1, 0, 5), Vector(2, 4, 3, 1, 5, 0), 
      Vector(2, 4, 3, 5, 0, 1), Vector(2, 4, 3, 5, 1, 0), Vector(2, 4, 5, 0, 1, 3), Vector(2, 4, 5, 0, 3, 1), 
      Vector(2, 4, 5, 1, 0, 3), Vector(2, 4, 5, 1, 3, 0), Vector(2, 4, 5, 3, 0, 1), Vector(2, 4, 5, 3, 1, 0), 
      Vector(2, 5, 0, 1, 3, 4), Vector(2, 5, 0, 1, 4, 3), Vector(2, 5, 0, 3, 1, 4), Vector(2, 5, 0, 3, 4, 1), 
      Vector(2, 5, 0, 4, 1, 3), Vector(2, 5, 0, 4, 3, 1), Vector(2, 5, 1, 0, 3, 4), Vector(2, 5, 1, 0, 4, 3), 
      Vector(2, 5, 1, 3, 0, 4), Vector(2, 5, 1, 3, 4, 0), Vector(2, 5, 1, 4, 0, 3), Vector(2, 5, 1, 4, 3, 0), 
      Vector(2, 5, 3, 0, 1, 4), Vector(2, 5, 3, 0, 4, 1), Vector(2, 5, 3, 1, 0, 4), Vector(2, 5, 3, 1, 4, 0), 
      Vector(2, 5, 3, 4, 0, 1), Vector(2, 5, 3, 4, 1, 0), Vector(2, 5, 4, 0, 1, 3), Vector(2, 5, 4, 0, 3, 1), 
      Vector(2, 5, 4, 1, 0, 3), Vector(2, 5, 4, 1, 3, 0), Vector(2, 5, 4, 3, 0, 1), Vector(2, 5, 4, 3, 1, 0), 
      Vector(3, 0, 1, 2, 4, 5), Vector(3, 0, 1, 2, 5, 4), Vector(3, 0, 1, 4, 2, 5), Vector(3, 0, 1, 4, 5, 2), 
      Vector(3, 0, 1, 5, 2, 4), Vector(3, 0, 1, 5, 4, 2), Vector(3, 0, 2, 1, 4, 5), Vector(3, 0, 2, 1, 5, 4), 
      Vector(3, 0, 2, 4, 1, 5), Vector(3, 0, 2, 4, 5, 1), Vector(3, 0, 2, 5, 1, 4), Vector(3, 0, 2, 5, 4, 1), 
      Vector(3, 0, 4, 1, 2, 5), Vector(3, 0, 4, 1, 5, 2), Vector(3, 0, 4, 2, 1, 5), Vector(3, 0, 4, 2, 5, 1), 
      Vector(3, 0, 4, 5, 1, 2), Vector(3, 0, 4, 5, 2, 1), Vector(3, 0, 5, 1, 2, 4), Vector(3, 0, 5, 1, 4, 2), 
      Vector(3, 0, 5, 2, 1, 4), Vector(3, 0, 5, 2, 4, 1), Vector(3, 0, 5, 4, 1, 2), Vector(3, 0, 5, 4, 2, 1), 
      Vector(3, 1, 0, 2, 4, 5), Vector(3, 1, 0, 2, 5, 4), Vector(3, 1, 0, 4, 2, 5), Vector(3, 1, 0, 4, 5, 2), 
      Vector(3, 1, 0, 5, 2, 4), Vector(3, 1, 0, 5, 4, 2), Vector(3, 1, 2, 0, 4, 5), Vector(3, 1, 2, 0, 5, 4), 
      Vector(3, 1, 2, 4, 0, 5), Vector(3, 1, 2, 4, 5, 0), Vector(3, 1, 2, 5, 0, 4), Vector(3, 1, 2, 5, 4, 0), 
      Vector(3, 1, 4, 0, 2, 5), Vector(3, 1, 4, 0, 5, 2), Vector(3, 1, 4, 2, 0, 5), Vector(3, 1, 4, 2, 5, 0), 
      Vector(3, 1, 4, 5, 0, 2), Vector(3, 1, 4, 5, 2, 0), Vector(3, 1, 5, 0, 2, 4), Vector(3, 1, 5, 0, 4, 2), 
      Vector(3, 1, 5, 2, 0, 4), Vector(3, 1, 5, 2, 4, 0), Vector(3, 1, 5, 4, 0, 2), Vector(3, 1, 5, 4, 2, 0), 
      Vector(3, 2, 0, 1, 4, 5), Vector(3, 2, 0, 1, 5, 4), Vector(3, 2, 0, 4, 1, 5), Vector(3, 2, 0, 4, 5, 1), 
      Vector(3, 2, 0, 5, 1, 4), Vector(3, 2, 0, 5, 4, 1), Vector(3, 2, 1, 0, 4, 5), Vector(3, 2, 1, 0, 5, 4), 
      Vector(3, 2, 1, 4, 0, 5), Vector(3, 2, 1, 4, 5, 0), Vector(3, 2, 1, 5, 0, 4), Vector(3, 2, 1, 5, 4, 0), 
      Vector(3, 2, 4, 0, 1, 5), Vector(3, 2, 4, 0, 5, 1), Vector(3, 2, 4, 1, 0, 5), Vector(3, 2, 4, 1, 5, 0), 
      Vector(3, 2, 4, 5, 0, 1), Vector(3, 2, 4, 5, 1, 0), Vector(3, 2, 5, 0, 1, 4), Vector(3, 2, 5, 0, 4, 1), 
      Vector(3, 2, 5, 1, 0, 4), Vector(3, 2, 5, 1, 4, 0), Vector(3, 2, 5, 4, 0, 1), Vector(3, 2, 5, 4, 1, 0), 
      Vector(3, 4, 0, 1, 2, 5), Vector(3, 4, 0, 1, 5, 2), Vector(3, 4, 0, 2, 1, 5), Vector(3, 4, 0, 2, 5, 1), 
      Vector(3, 4, 0, 5, 1, 2), Vector(3, 4, 0, 5, 2, 1), Vector(3, 4, 1, 0, 2, 5), Vector(3, 4, 1, 0, 5, 2), 
      Vector(3, 4, 1, 2, 0, 5), Vector(3, 4, 1, 2, 5, 0), Vector(3, 4, 1, 5, 0, 2), Vector(3, 4, 1, 5, 2, 0), 
      Vector(3, 4, 2, 0, 1, 5), Vector(3, 4, 2, 0, 5, 1), Vector(3, 4, 2, 1, 0, 5), Vector(3, 4, 2, 1, 5, 0), 
      Vector(3, 4, 2, 5, 0, 1), Vector(3, 4, 2, 5, 1, 0), Vector(3, 4, 5, 0, 1, 2), Vector(3, 4, 5, 0, 2, 1), 
      Vector(3, 4, 5, 1, 0, 2), Vector(3, 4, 5, 1, 2, 0), Vector(3, 4, 5, 2, 0, 1), Vector(3, 4, 5, 2, 1, 0), 
      Vector(3, 5, 0, 1, 2, 4), Vector(3, 5, 0, 1, 4, 2), Vector(3, 5, 0, 2, 1, 4), Vector(3, 5, 0, 2, 4, 1), 
      Vector(3, 5, 0, 4, 1, 2), Vector(3, 5, 0, 4, 2, 1), Vector(3, 5, 1, 0, 2, 4), Vector(3, 5, 1, 0, 4, 2), 
      Vector(3, 5, 1, 2, 0, 4), Vector(3, 5, 1, 2, 4, 0), Vector(3, 5, 1, 4, 0, 2), Vector(3, 5, 1, 4, 2, 0), 
      Vector(3, 5, 2, 0, 1, 4), Vector(3, 5, 2, 0, 4, 1), Vector(3, 5, 2, 1, 0, 4), Vector(3, 5, 2, 1, 4, 0), 
      Vector(3, 5, 2, 4, 0, 1), Vector(3, 5, 2, 4, 1, 0), Vector(3, 5, 4, 0, 1, 2), Vector(3, 5, 4, 0, 2, 1), 
      Vector(3, 5, 4, 1, 0, 2), Vector(3, 5, 4, 1, 2, 0), Vector(3, 5, 4, 2, 0, 1), Vector(3, 5, 4, 2, 1, 0), 
      Vector(4, 0, 1, 2, 3, 5), Vector(4, 0, 1, 2, 5, 3), Vector(4, 0, 1, 3, 2, 5), Vector(4, 0, 1, 3, 5, 2), 
      Vector(4, 0, 1, 5, 2, 3), Vector(4, 0, 1, 5, 3, 2), Vector(4, 0, 2, 1, 3, 5), Vector(4, 0, 2, 1, 5, 3), 
      Vector(4, 0, 2, 3, 1, 5), Vector(4, 0, 2, 3, 5, 1), Vector(4, 0, 2, 5, 1, 3), Vector(4, 0, 2, 5, 3, 1),    
      Vector(4, 0, 3, 1, 2, 5), Vector(4, 0, 3, 1, 5, 2), Vector(4, 0, 3, 2, 1, 5), Vector(4, 0, 3, 2, 5, 1), 
      Vector(4, 0, 3, 5, 1, 2), Vector(4, 0, 3, 5, 2, 1), Vector(4, 0, 5, 1, 2, 3), Vector(4, 0, 5, 1, 3, 2), 
      Vector(4, 0, 5, 2, 1, 3), Vector(4, 0, 5, 2, 3, 1), Vector(4, 0, 5, 3, 1, 2), Vector(4, 0, 5, 3, 2, 1), 
      Vector(4, 1, 0, 2, 3, 5), Vector(4, 1, 0, 2, 5, 3), Vector(4, 1, 0, 3, 2, 5), Vector(4, 1, 0, 3, 5, 2), 
      Vector(4, 1, 0, 5, 2, 3), Vector(4, 1, 0, 5, 3, 2), Vector(4, 1, 2, 0, 3, 5), Vector(4, 1, 2, 0, 5, 3), 
      Vector(4, 1, 2, 3, 0, 5), Vector(4, 1, 2, 3, 5, 0), Vector(4, 1, 2, 5, 0, 3), Vector(4, 1, 2, 5, 3, 0), 
      Vector(4, 1, 3, 0, 2, 5), Vector(4, 1, 3, 0, 5, 2), Vector(4, 1, 3, 2, 0, 5), Vector(4, 1, 3, 2, 5, 0), 
      Vector(4, 1, 3, 5, 0, 2), Vector(4, 1, 3, 5, 2, 0), Vector(4, 1, 5, 0, 2, 3), Vector(4, 1, 5, 0, 3, 2), 
      Vector(4, 1, 5, 2, 0, 3), Vector(4, 1, 5, 2, 3, 0), Vector(4, 1, 5, 3, 0, 2), Vector(4, 1, 5, 3, 2, 0), 
      Vector(4, 2, 0, 1, 3, 5), Vector(4, 2, 0, 1, 5, 3), Vector(4, 2, 0, 3, 1, 5), Vector(4, 2, 0, 3, 5, 1), 
      Vector(4, 2, 0, 5, 1, 3), Vector(4, 2, 0, 5, 3, 1), Vector(4, 2, 1, 0, 3, 5), Vector(4, 2, 1, 0, 5, 3), 
      Vector(4, 2, 1, 3, 0, 5), Vector(4, 2, 1, 3, 5, 0), Vector(4, 2, 1, 5, 0, 3), Vector(4, 2, 1, 5, 3, 0), 
      Vector(4, 2, 3, 0, 1, 5), Vector(4, 2, 3, 0, 5, 1), Vector(4, 2, 3, 1, 0, 5), Vector(4, 2, 3, 1, 5, 0), 
      Vector(4, 2, 3, 5, 0, 1), Vector(4, 2, 3, 5, 1, 0), Vector(4, 2, 5, 0, 1, 3), Vector(4, 2, 5, 0, 3, 1), 
      Vector(4, 2, 5, 1, 0, 3), Vector(4, 2, 5, 1, 3, 0), Vector(4, 2, 5, 3, 0, 1), Vector(4, 2, 5, 3, 1, 0), 
      Vector(4, 3, 0, 1, 2, 5), Vector(4, 3, 0, 1, 5, 2), Vector(4, 3, 0, 2, 1, 5), Vector(4, 3, 0, 2, 5, 1), 
      Vector(4, 3, 0, 5, 1, 2), Vector(4, 3, 0, 5, 2, 1), Vector(4, 3, 1, 0, 2, 5), Vector(4, 3, 1, 0, 5, 2), 
      Vector(4, 3, 1, 2, 0, 5), Vector(4, 3, 1, 2, 5, 0), Vector(4, 3, 1, 5, 0, 2), Vector(4, 3, 1, 5, 2, 0), 
      Vector(4, 3, 2, 0, 1, 5), Vector(4, 3, 2, 0, 5, 1), Vector(4, 3, 2, 1, 0, 5), Vector(4, 3, 2, 1, 5, 0), 
      Vector(4, 3, 2, 5, 0, 1), Vector(4, 3, 2, 5, 1, 0), Vector(4, 3, 5, 0, 1, 2), Vector(4, 3, 5, 0, 2, 1), 
      Vector(4, 3, 5, 1, 0, 2), Vector(4, 3, 5, 1, 2, 0), Vector(4, 3, 5, 2, 0, 1), Vector(4, 3, 5, 2, 1, 0), 
      Vector(4, 5, 0, 1, 2, 3), Vector(4, 5, 0, 1, 3, 2), Vector(4, 5, 0, 2, 1, 3), Vector(4, 5, 0, 2, 3, 1), 
      Vector(4, 5, 0, 3, 1, 2), Vector(4, 5, 0, 3, 2, 1), Vector(4, 5, 1, 0, 2, 3), Vector(4, 5, 1, 0, 3, 2), 
      Vector(4, 5, 1, 2, 0, 3), Vector(4, 5, 1, 2, 3, 0), Vector(4, 5, 1, 3, 0, 2), Vector(4, 5, 1, 3, 2, 0), 
      Vector(4, 5, 2, 0, 1, 3), Vector(4, 5, 2, 0, 3, 1), Vector(4, 5, 2, 1, 0, 3), Vector(4, 5, 2, 1, 3, 0), 
      Vector(4, 5, 2, 3, 0, 1), Vector(4, 5, 2, 3, 1, 0), Vector(4, 5, 3, 0, 1, 2), Vector(4, 5, 3, 0, 2, 1), 
      Vector(4, 5, 3, 1, 0, 2), Vector(4, 5, 3, 1, 2, 0), Vector(4, 5, 3, 2, 0, 1), Vector(4, 5, 3, 2, 1, 0), 
      Vector(5, 0, 1, 2, 3, 4), Vector(5, 0, 1, 2, 4, 3), Vector(5, 0, 1, 3, 2, 4), Vector(5, 0, 1, 3, 4, 2), 
      Vector(5, 0, 1, 4, 2, 3), Vector(5, 0, 1, 4, 3, 2), Vector(5, 0, 2, 1, 3, 4), Vector(5, 0, 2, 1, 4, 3), 
      Vector(5, 0, 2, 3, 1, 4), Vector(5, 0, 2, 3, 4, 1), Vector(5, 0, 2, 4, 1, 3), Vector(5, 0, 2, 4, 3, 1), 
      Vector(5, 0, 3, 1, 2, 4), Vector(5, 0, 3, 1, 4, 2), Vector(5, 0, 3, 2, 1, 4), Vector(5, 0, 3, 2, 4, 1), 
      Vector(5, 0, 3, 4, 1, 2), Vector(5, 0, 3, 4, 2, 1), Vector(5, 0, 4, 1, 2, 3), Vector(5, 0, 4, 1, 3, 2), 
      Vector(5, 0, 4, 2, 1, 3), Vector(5, 0, 4, 2, 3, 1), Vector(5, 0, 4, 3, 1, 2), Vector(5, 0, 4, 3, 2, 1), 
      Vector(5, 1, 0, 2, 3, 4), Vector(5, 1, 0, 2, 4, 3), Vector(5, 1, 0, 3, 2, 4), Vector(5, 1, 0, 3, 4, 2), 
      Vector(5, 1, 0, 4, 2, 3), Vector(5, 1, 0, 4, 3, 2), Vector(5, 1, 2, 0, 3, 4), Vector(5, 1, 2, 0, 4, 3), 
      Vector(5, 1, 2, 3, 0, 4), Vector(5, 1, 2, 3, 4, 0), Vector(5, 1, 2, 4, 0, 3), Vector(5, 1, 2, 4, 3, 0), 
      Vector(5, 1, 3, 0, 2, 4), Vector(5, 1, 3, 0, 4, 2), Vector(5, 1, 3, 2, 0, 4), Vector(5, 1, 3, 2, 4, 0), 
      Vector(5, 1, 3, 4, 0, 2), Vector(5, 1, 3, 4, 2, 0), Vector(5, 1, 4, 0, 2, 3), Vector(5, 1, 4, 0, 3, 2), 
      Vector(5, 1, 4, 2, 0, 3), Vector(5, 1, 4, 2, 3, 0), Vector(5, 1, 4, 3, 0, 2), Vector(5, 1, 4, 3, 2, 0), 
      Vector(5, 2, 0, 1, 3, 4), Vector(5, 2, 0, 1, 4, 3), Vector(5, 2, 0, 3, 1, 4), Vector(5, 2, 0, 3, 4, 1), 
      Vector(5, 2, 0, 4, 1, 3), Vector(5, 2, 0, 4, 3, 1), Vector(5, 2, 1, 0, 3, 4), Vector(5, 2, 1, 0, 4, 3), 
      Vector(5, 2, 1, 3, 0, 4), Vector(5, 2, 1, 3, 4, 0), Vector(5, 2, 1, 4, 0, 3), Vector(5, 2, 1, 4, 3, 0), 
      Vector(5, 2, 3, 0, 1, 4), Vector(5, 2, 3, 0, 4, 1), Vector(5, 2, 3, 1, 0, 4), Vector(5, 2, 3, 1, 4, 0), 
      Vector(5, 2, 3, 4, 0, 1), Vector(5, 2, 3, 4, 1, 0), Vector(5, 2, 4, 0, 1, 3), Vector(5, 2, 4, 0, 3, 1), 
      Vector(5, 2, 4, 1, 0, 3), Vector(5, 2, 4, 1, 3, 0), Vector(5, 2, 4, 3, 0, 1), Vector(5, 2, 4, 3, 1, 0), 
      Vector(5, 3, 0, 1, 2, 4), Vector(5, 3, 0, 1, 4, 2), Vector(5, 3, 0, 2, 1, 4), Vector(5, 3, 0, 2, 4, 1), 
      Vector(5, 3, 0, 4, 1, 2), Vector(5, 3, 0, 4, 2, 1), Vector(5, 3, 1, 0, 2, 4), Vector(5, 3, 1, 0, 4, 2), 
      Vector(5, 3, 1, 2, 0, 4), Vector(5, 3, 1, 2, 4, 0), Vector(5, 3, 1, 4, 0, 2), Vector(5, 3, 1, 4, 2, 0), 
      Vector(5, 3, 2, 0, 1, 4), Vector(5, 3, 2, 0, 4, 1), Vector(5, 3, 2, 1, 0, 4), Vector(5, 3, 2, 1, 4, 0), 
      Vector(5, 3, 2, 4, 0, 1), Vector(5, 3, 2, 4, 1, 0), Vector(5, 3, 4, 0, 1, 2), Vector(5, 3, 4, 0, 2, 1), 
      Vector(5, 3, 4, 1, 0, 2), Vector(5, 3, 4, 1, 2, 0), Vector(5, 3, 4, 2, 0, 1), Vector(5, 3, 4, 2, 1, 0), 
      Vector(5, 4, 0, 1, 2, 3), Vector(5, 4, 0, 1, 3, 2), Vector(5, 4, 0, 2, 1, 3), Vector(5, 4, 0, 2, 3, 1), 
      Vector(5, 4, 0, 3, 1, 2), Vector(5, 4, 0, 3, 2, 1), Vector(5, 4, 1, 0, 2, 3), Vector(5, 4, 1, 0, 3, 2), 
      Vector(5, 4, 1, 2, 0, 3), Vector(5, 4, 1, 2, 3, 0), Vector(5, 4, 1, 3, 0, 2), Vector(5, 4, 1, 3, 2, 0), 
      Vector(5, 4, 2, 0, 1, 3), Vector(5, 4, 2, 0, 3, 1), Vector(5, 4, 2, 1, 0, 3), Vector(5, 4, 2, 1, 3, 0), 
      Vector(5, 4, 2, 3, 0, 1), Vector(5, 4, 2, 3, 1, 0), Vector(5, 4, 3, 0, 1, 2), Vector(5, 4, 3, 0, 2, 1), 
      Vector(5, 4, 3, 1, 0, 2), Vector(5, 4, 3, 1, 2, 0), Vector(5, 4, 3, 2, 0, 1), Vector(5, 4, 3, 2, 1, 0)))
  }


  //Funcion generarProgramacionesRiegoPar (VERSION SECUENCIAL)
  test("generar programaciones de riego para finca1 version paralela") {
    assert(objregado.generarProgramacionesRiegoPar(finca1) == Vector(
      Vector(0, 1, 2), 
      Vector(0, 2, 1), 
      Vector(1, 0, 2), 
      Vector(1, 2, 0), 
      Vector(2, 0, 1), 
      Vector(2, 1, 0)))
  }

  test("generar programaciones de riego para finca2 versión paralelada como resultado: Vector(Vector(0, 1, 2, 3), Vector(0, 1, 3, 2), Vector(0, 2, 1, 3), Vector(0, 2, 3, 1), Vector(0, 3, 1, 2), Vector(0, 3, 2, 1), Vector(1, 0, 2, 3), Vector(1, 0, 3, 2), Vector(1, 2, 0, 3), Vector(1, 2, 3, 0), Vector(1, 3, 0, 2), Vector(1, 3, 2, 0), Vector(2, 0, 1, 3), Vector(2, 0, 3, 1), Vector(2, 1, 0, 3), Vector(2, 1, 3, 0), Vector(2, 3, 0, 1), Vector(2, 3, 1, 0), Vector(3, 0, 1, 2), Vector(3, 0, 2, 1), Vector(3, 1, 0, 2), Vector(3, 1, 2, 0), Vector(3, 2, 0, 1), Vector(3, 2, 1, 0))") {
    assert(objregado.generarProgramacionesRiegoPar(finca2) == Vector(
      Vector(0, 1, 2, 3), 
      Vector(0, 1, 3, 2), 
      Vector(0, 2, 1, 3), 
      Vector(0, 2, 3, 1), 
      Vector(0, 3, 1, 2), 
      Vector(0, 3, 2, 1), 
      Vector(1, 0, 2, 3), 
      Vector(1, 0, 3, 2), 
      Vector(1, 2, 0, 3), 
      Vector(1, 2, 3, 0), 
      Vector(1, 3, 0, 2), 
      Vector(1, 3, 2, 0), 
      Vector(2, 0, 1, 3), 
      Vector(2, 0, 3, 1), 
      Vector(2, 1, 0, 3), 
      Vector(2, 1, 3, 0), 
      Vector(2, 3, 0, 1), 
      Vector(2, 3, 1, 0), 
      Vector(3, 0, 1, 2), 
      Vector(3, 0, 2, 1), 
      Vector(3, 1, 0, 2), 
      Vector(3, 1, 2, 0), 
      Vector(3, 2, 0, 1), 
      Vector(3, 2, 1, 0)))
  }
  test("generar programaciones de riego para finca3 version paralela") {
    assert(objregado.generarProgramacionesRiegoPar(finca3) == Vector(
      Vector(0, 1, 2, 3, 4), 
      Vector(0, 1, 2, 4, 3), 
      Vector(0, 1, 3, 2, 4), 
      Vector(0, 1, 3, 4, 2), 
      Vector(0, 1, 4, 2, 3), 
      Vector(0, 1, 4, 3, 2), 
      Vector(0, 2, 1, 3, 4), 
      Vector(0, 2, 1, 4, 3), 
      Vector(0, 2, 3, 1, 4), 
      Vector(0, 2, 3, 4, 1), 
      Vector(0, 2, 4, 1, 3), 
      Vector(0, 2, 4, 3, 1), 
      Vector(0, 3, 1, 2, 4), 
      Vector(0, 3, 1, 4, 2), 
      Vector(0, 3, 2, 1, 4), 
      Vector(0, 3, 2, 4, 1), 
      Vector(0, 3, 4, 1, 2), 
      Vector(0, 3, 4, 2, 1), 
      Vector(0, 4, 1, 2, 3), 
      Vector(0, 4, 1, 3, 2), 
      Vector(0, 4, 2, 1, 3), 
      Vector(0, 4, 2, 3, 1), 
      Vector(0, 4, 3, 1, 2), 
      Vector(0, 4, 3, 2, 1), 
      Vector(1, 0, 2, 3, 4), 
      Vector(1, 0, 2, 4, 3), 
      Vector(1, 0, 3, 2, 4), 
      Vector(1, 0, 3, 4, 2), 
      Vector(1, 0, 4, 2, 3), 
      Vector(1, 0, 4, 3, 2), 
      Vector(1, 2, 0, 3, 4), 
      Vector(1, 2, 0, 4, 3), 
      Vector(1, 2, 3, 0, 4), 
      Vector(1, 2, 3, 4, 0), 
      Vector(1, 2, 4, 0, 3), 
      Vector(1, 2, 4, 3, 0), 
      Vector(1, 3, 0, 2, 4), 
      Vector(1, 3, 0, 4, 2), 
      Vector(1, 3, 2, 0, 4), 
      Vector(1, 3, 2, 4, 0), 
      Vector(1, 3, 4, 0, 2), 
      Vector(1, 3, 4, 2, 0), 
      Vector(1, 4, 0, 2, 3), 
      Vector(1, 4, 0, 3, 2), 
      Vector(1, 4, 2, 0, 3), 
      Vector(1, 4, 2, 3, 0), 
      Vector(1, 4, 3, 0, 2), 
      Vector(1, 4, 3, 2, 0), 
      Vector(2, 0, 1, 3, 4), 
      Vector(2, 0, 1, 4, 3), 
      Vector(2, 0, 3, 1, 4), 
      Vector(2, 0, 3, 4, 1), 
      Vector(2, 0, 4, 1, 3), 
      Vector(2, 0, 4, 3, 1), 
      Vector(2, 1, 0, 3, 4), 
      Vector(2, 1, 0, 4, 3), 
      Vector(2, 1, 3, 0, 4), 
      Vector(2, 1, 3, 4, 0), 
      Vector(2, 1, 4, 0, 3), 
      Vector(2, 1, 4, 3, 0), 
      Vector(2, 3, 0, 1, 4), 
      Vector(2, 3, 0, 4, 1), 
      Vector(2, 3, 1, 0, 4), 
      Vector(2, 3, 1, 4, 0), 
      Vector(2, 3, 4, 0, 1), 
      Vector(2, 3, 4, 1, 0), 
      Vector(2, 4, 0, 1, 3), 
      Vector(2, 4, 0, 3, 1), 
      Vector(2, 4, 1, 0, 3), 
      Vector(2, 4, 1, 3, 0), 
      Vector(2, 4, 3, 0, 1), 
      Vector(2, 4, 3, 1, 0), 
      Vector(3, 0, 1, 2, 4), 
      Vector(3, 0, 1, 4, 2), 
      Vector(3, 0, 2, 1, 4), 
      Vector(3, 0, 2, 4, 1), 
      Vector(3, 0, 4, 1, 2), 
      Vector(3, 0, 4, 2, 1), 
      Vector(3, 1, 0, 2, 4), 
      Vector(3, 1, 0, 4, 2), 
      Vector(3, 1, 2, 0, 4), 
      Vector(3, 1, 2, 4, 0), 
      Vector(3, 1, 4, 0, 2), 
      Vector(3, 1, 4, 2, 0), 
      Vector(3, 2, 0, 1, 4), 
      Vector(3, 2, 0, 4, 1), 
      Vector(3, 2, 1, 0, 4), 
      Vector(3, 2, 1, 4, 0), 
      Vector(3, 2, 4, 0, 1), 
      Vector(3, 2, 4, 1, 0), 
      Vector(3, 4, 0, 1, 2), 
      Vector(3, 4, 0, 2, 1), 
      Vector(3, 4, 1, 0, 2), 
      Vector(3, 4, 1, 2, 0), 
      Vector(3, 4, 2, 0, 1), 
      Vector(3, 4, 2, 1, 0), 
      Vector(4, 0, 1, 2, 3), 
      Vector(4, 0, 1, 3, 2), 
      Vector(4, 0, 2, 1, 3), 
      Vector(4, 0, 2, 3, 1), 
      Vector(4, 0, 3, 1, 2), 
      Vector(4, 0, 3, 2, 1), 
      Vector(4, 1, 0, 2, 3), 
      Vector(4, 1, 0, 3, 2), 
      Vector(4, 1, 2, 0, 3), 
      Vector(4, 1, 2, 3, 0), 
      Vector(4, 1, 3, 0, 2), 
      Vector(4, 1, 3, 2, 0), 
      Vector(4, 2, 0, 1, 3), 
      Vector(4, 2, 0, 3, 1), 
      Vector(4, 2, 1, 0, 3), 
      Vector(4, 2, 1, 3, 0), 
      Vector(4, 2, 3, 0, 1), 
      Vector(4, 2, 3, 1, 0), 
      Vector(4, 3, 0, 1, 2), 
      Vector(4, 3, 0, 2, 1), 
      Vector(4, 3, 1, 0, 2), 
      Vector(4, 3, 1, 2, 0), 
      Vector(4, 3, 2, 0, 1), 
      Vector(4, 3, 2, 1, 0)))
  }
  test("generar programaciones de riego para finca6 version paralela da como resultado: Vector(Vector(0, 1), Vector(1, 0))") {
    assert(objregado.generarProgramacionesRiegoPar(finca6) == Vector(
      Vector(0, 1), 
      Vector(1, 0)))
  }
  test("generar programaciones de riego para finca7 version paralela"){
    assert(objregado.generarProgramacionesRiegoPar(finca7) == Vector(
      Vector(0, 1, 2), Vector(0, 2, 1), 
      Vector(1, 0, 2), Vector(1, 2, 0), 
      Vector(2, 0, 1), Vector(2, 1, 0)))
  }


  test("genera costoRiegoTablon"){
    assert(objregado.costoRiegoTablon(0, finca1, Vector(0, 1, 2)) == 8)
    assert(objregado.costoRiegoTablon(1, finca2, Vector(0, 1, 2, 3)) == 7)
    assert(objregado.costoRiegoTablon(2, finca3, Vector(0, 1, 2, 3, 4)) == 11)
    assert(objregado.costoRiegoTablon(0, finca6, Vector(0, 1)) == 7)
    assert(objregado.costoRiegoTablon(1, finca7, Vector(0, 1, 2)) == 12)
    assert(objregado.costoRiegoTablon(2, finca7, Vector(0, 1, 2)) == 5)
  }
  test("genera costoRiegoFinca"){
    assert(objregado.costoRiegoFinca(finca1, Vector(0, 1, 2)) == 14)
    assert(objregado.costoRiegoFinca(finca2, Vector(0, 1, 2, 3)) == 28)
    assert(objregado.costoRiegoFinca(finca3, Vector(0, 1, 2, 3, 4)) == 60)
    assert(objregado.costoRiegoFinca(finca6, Vector(0, 1)) == 7)
  }
}