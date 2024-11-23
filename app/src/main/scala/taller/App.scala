/*
 * This Scala source file was generated by the Gradle 'init' task.
 */
package taller
import org.scalameter.withWarmer
import org.scalameter.Warmer
import org.scalameter.measure
import org.scalameter.Warmer.Default


object App {
  def main(args: Array[String]): Unit = {

    val mat1 = new MatrizOps()

    //matrices 2x2
    val m1 = mat1.matrizAlAzar(2, 5)
    val m2 = mat1.matrizAlAzar(2, 5)

    //matrices 4x4
    val m3 = mat1.matrizAlAzar(4, 3)
    val m4 = mat1.matrizAlAzar(4, 3)

    //matrices 8x8
    val m5 = mat1.matrizAlAzar(8, 4)
    val m6 = mat1.matrizAlAzar(8, 4)

    //matrices 16x16
    val m7 = mat1.matrizAlAzar(16, 5)
    val m8 = mat1.matrizAlAzar(16, 5)

    //matrices 32x32
    val m9 = mat1.matrizAlAzar(32, 4)
    val m10 = mat1.matrizAlAzar(32, 4)


    // 10 Pruebas para la función Strassen
    def pruebas(): Unit = {

      println("Multiplicacion Strassen 32x32")
      println("Matriz 1: ")
      m9.foreach(row => println(row))
      println("Matriz 2: ")
      m10.foreach(row => println(row))
      println("Resultado: ")
      (mat1.multStrassen(m9, m10)).foreach(row => println(row))
      val comp9 = mat1.compararAlgoritmos(mat1.multStrassen, mat1.multStrassenPar)(m9, m10)
      println("Tiempo de ejecución de Strassen: " + comp9(0))
      println("Tiempo de ejecución de Strassen Paralelo: " + comp9(1))

      println("Multiplicacion Strassen 32x32")
      println("Matriz 1: ")
      m10.foreach(row => println(row))
      println("Matriz 2: ")
      m9.foreach(row => println(row))
      println("Resultado: ")
      (mat1.multStrassen(m10, m9)).foreach(row => println(row))
      val comp10 = mat1.compararAlgoritmos(mat1.multStrassen, mat1.multStrassenPar)(m10, m9)
      println("Tiempo de ejecución de Strassen: " + comp10(0))
      println("Tiempo de ejecución de Strassen Paralelo: " + comp10(1))

    }

    /*val resultados = for {
      i <- 1 to 10
      m1 = mat1.matrizAlAzar(math.pow(2, i).toInt, 2)
      m2 = mat1.matrizAlAzar(math.pow(2, i).toInt, 2)
    } yield (mat1.compararAlgoritmos(mat1.multStrassen, mat1.multStrassenPar)(m1, m2),math.pow(2, i).toInt)
    }*/

    pruebas()
  }

  def greeting(): String = "Hello, world!"
}
