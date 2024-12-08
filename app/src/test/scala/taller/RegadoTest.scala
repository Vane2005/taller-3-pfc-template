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

}
