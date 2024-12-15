/*
 * This Scala source file was generated by the Gradle 'init' task.
 */
package taller
import org.scalameter.withWarmer
import org.scalameter.Warmer
import org.scalameter.measure
import org.scalameter.Warmer.Default
import scala.collection.parallel.CollectionConverters._
import scala.util.Random


object App {
  def main(args: Array[String]): Unit = {
    val regado = new Regado()
    val finca = regado.fincaAlAzar(5)  //los valores n se van cambiando para realizar las pruebas
    val progRiego = regado.generarProgRiegoAlAzar(10)

    
    val finca1 = regado.fincaAlAzar(1)
    val finca2 = regado.fincaAlAzar(1)

    val finca3 = regado.fincaAlAzar(2)
    val finca4 = regado.fincaAlAzar(2)

    val finca5 = regado.fincaAlAzar(3)
    val finca6 = regado.fincaAlAzar(3)

    val finca7 = regado.fincaAlAzar(4)
    val finca8 = regado.fincaAlAzar(4)

    val finca9 = regado.fincaAlAzar(5)
    val finca10 = regado.fincaAlAzar(5)

    //Pruebas para costoRiegoFinca
    def pruebas1(): Unit = {
      val comp = regado.compararCostoRiegoFinca(regado.costoRiegoFinca, regado.costoRiegoFincaPar)(finca, progRiego)
      println("Secuencial: " + comp(0))
      println("Paralelo: " + comp(1))
    }

    def imprimirVectorFormateado(vector: Vector[Vector[Int]]): String = {
      vector.zipWithIndex.map { case (subVector, index) =>
        s"  $index: " + subVector.mkString("(", ", ", ")")
      }.mkString("\n")
    }

    //Pruebas para generarProgramacionesRiego

    def pruebas2(): Unit = {
      println("finca9: \n" + imprimirVectorFormateado(finca9.map { case (a, b, c) => Vector(a, b, c) }))
      println("Programación de riego con secuencial:\n" + regado.generarProgramacionesRiego(finca9))
      println("Programación de riego con paralela: \n" + regado.generarProgramacionesRiegoPar(finca9))
      val comp1 = regado.compararGenerarProgramacionesRiego(regado.generarProgramacionesRiego, regado.generarProgramacionesRiegoPar)(finca9)
      println("Secuencial: " + comp1(0))
      println("Paralelo: " + comp1(1))
      println("Aceleración: " + comp1(2))


      println("\nfinca10: \n" + imprimirVectorFormateado(finca10.map { case (a, b, c) => Vector(a, b, c) }))
      println("Programación de riego con secuencial:\n" + regado.generarProgramacionesRiego(finca10))
      println("Programación de riego con paralela: \n" + regado.generarProgramacionesRiegoPar(finca10))
      val comp2 = regado.compararGenerarProgramacionesRiego(regado.generarProgramacionesRiego, regado.generarProgramacionesRiegoPar)(finca10)
      println("Secuencial: " + comp1(0))
      println("Paralelo: " + comp1(1))
      println("Aceleración: " + comp1(2))
    }
    pruebas2()


    // Pruebas de costoRiegoTablon
    def pruebasCostoRiegoTablon(): Unit = {
      val finca1 = regado.fincaAlAzar(1)
      val finca2 = regado.fincaAlAzar(2)
      val finca3 = regado.fincaAlAzar(3)
      val finca4 = regado.fincaAlAzar(4)
      val finca5 = regado.fincaAlAzar(5)

      println("\n== Pruebas de costoRiegoTablon ==")
      regado.costoRiegoTablon(0, finca1, regado.generarProgRiegoAlAzar(1))
      regado.costoRiegoTablon(0, finca2, regado.generarProgRiegoAlAzar(2))
      regado.costoRiegoTablon(0, finca3, regado.generarProgRiegoAlAzar(3))
      regado.costoRiegoTablon(0, finca4, regado.generarProgRiegoAlAzar(4))
      regado.costoRiegoTablon(0, finca5, regado.generarProgRiegoAlAzar(5))
    }
    pruebasCostoRiegoTablon()

    // Pruebas de costoMovilidad
    def pruebasCostoMovilidad(): Unit = {
      val finca1 = regado.fincaAlAzar(1)
      val finca2 = regado.fincaAlAzar(2)
      val finca3 = regado.fincaAlAzar(3)
      val finca4 = regado.fincaAlAzar(4)
      val finca5 = regado.fincaAlAzar(5)
      val distancia1 = regado.distanciaAlAzar(1)
      val distancia2 = regado.distanciaAlAzar(2)
      val distancia3 = regado.distanciaAlAzar(3)
      val distancia4 = regado.distanciaAlAzar(4)
      val distancia5 = regado.distanciaAlAzar(5)

      println("\n== Pruebas de costoMovilidad ==")
      regado.costoMovilidad(finca1, regado.generarProgRiegoAlAzar(1), distancia1)
      regado.costoMovilidad(finca2, regado.generarProgRiegoAlAzar(2), distancia2)
      regado.costoMovilidad(finca3, regado.generarProgRiegoAlAzar(3), distancia3)
      regado.costoMovilidad(finca4, regado.generarProgRiegoAlAzar(4), distancia4)
      regado.costoMovilidad(finca5, regado.generarProgRiegoAlAzar(5), distancia5)
    }

    //pruebasCostoMovilidad()

    // Pruebas de costoMovilidadPar
    def pruebasCostoMovilidadPar(): Unit = {
      val finca1 = regado.fincaAlAzar(1)
      val finca2 = regado.fincaAlAzar(2)
      val finca3 = regado.fincaAlAzar(3)
      val finca4 = regado.fincaAlAzar(4)
      val finca5 = regado.fincaAlAzar(5)
      val distancia1 = regado.distanciaAlAzar(1)
      val distancia2 = regado.distanciaAlAzar(2)
      val distancia3 = regado.distanciaAlAzar(3)
      val distancia4 = regado.distanciaAlAzar(4)
      val distancia5 = regado.distanciaAlAzar(5)

      println("\n== Pruebas de costoMovilidadPar ==")
      regado.costoMovilidadPar(finca1, regado.generarProgRiegoAlAzar(1), distancia1)
      regado.costoMovilidadPar(finca2, regado.generarProgRiegoAlAzar(2), distancia2)
      regado.costoMovilidadPar(finca3, regado.generarProgRiegoAlAzar(3), distancia3)
      regado.costoMovilidadPar(finca4, regado.generarProgRiegoAlAzar(4), distancia4)
      regado.costoMovilidadPar(finca5, regado.generarProgRiegoAlAzar(5), distancia5)
    }

    //pruebasCostoMovilidadPar()
  }

  def greeting(): String = "Hello, world!"
}
