package taller

import scala.util.Random
import common._
import org.scalameter.withWarmer
import org.scalameter.Warmer
import org.scalameter.measure
import org.scalameter.Warmer.Default
import scala.collection.parallel.immutable.ParVector
import scala.collection.parallel.CollectionConverters._

class MatrizOps(){
    
    type Matriz = Vector[Vector[Int]]

    def matrizAlAzar(long:Int, vals:Int) : Matriz = {
        //Crea una matriz de enteros cuadrada de long x long ,
        // con valores aleatorios entre 0 y vals
        val v = Vector.fill(long ,long){Random.nextInt(vals)}
        v
    }

    def vectorAlAzar(long:Int, vals:Int) : Vector[Int] = {
        //Crea un vector de enteros de longitud long ,
        // con valores aleatorios entre 0 y vals
        val v = Vector.fill(long){Random.nextInt(vals)}
        v
    }

    def prodPunto(v1:Vector[Int], v2:Vector[Int]) : Int = {
        //Calcula el producto punto de dos vectores
        (v1 zip v2).map({case (i,j) => i*j}).sum
    }

    def prodPuntoParD(v1: ParVector [ Int ] ,v2: ParVector [ Int ]) : Int = {
        (v1 zip v2).map({case (i,j) => (i * j)}).sum
    }

    def transpuesta(m:Matriz) : Matriz = {
        val l = m.length
        Vector.tabulate(l,l)((i,j) => m(j)(i))
    }

    def subMatriz(m:Matriz, i:Int, j:Int, l:Int) : Matriz = {
        //Extrae una submatriz de m de tamaño l x l
        Vector.tabulate(l,l)((a,b) => m(i+a)(j+b))  //se crea un vector de dimensiones lxl, donde a,b son sus indices
        //y se extraen los valores de la matriz m en las posiciones i+a y j+b para llenar la submatriz
    }

    def sumMatriz(m1:Matriz, m2:Matriz) : Matriz = {
        //Suma dos matrices
        Vector.tabulate(m1.length,m1.length)((i,j) => m1(i)(j) + m2(i)(j))  
        //se crea un vector de mismas dimensiones, donde i,j son sus indices
        //y se suman los valores de las matrices m1 y m2 en las posiciones i,j para llenar la matriz resultante
    }

    def restaMatriz(m1:Matriz, m2:Matriz):Matriz ={
        //Resta dos matrices
        Vector.tabulate(m1.length,m1.length)((i,j) => m1(i)(j) - m2(i)(j))
        //se crea un vector de mismas dimensiones, donde i,j son sus indices
        //y se restan los valores de las matrices m1 y m2 en las posiciones i,j para llenar la matriz resultante
    }

    def multMatrizRec(m1: Matriz, m2: Matriz): Matriz = {
        val n = m1.length
        if (n == 1) {
            // Caso base: matrices de tamaño 1x1
            Vector(Vector(m1(0)(0) * m2(0)(0)))
        } else {
            val mid = n / 2

            // Dividimos las matrices en 4 submatrices
            val (a11, a12, a21, a22) = (
                subMatriz(m1, 0, 0, mid),
                subMatriz(m1, 0, mid, mid),
                subMatriz(m1, mid, 0, mid),
                subMatriz(m1, mid, mid, mid)
            )
            val (b11, b12, b21, b22) = (
                subMatriz(m2, 0, 0, mid),
                subMatriz(m2, 0, mid, mid),
                subMatriz(m2, mid, 0, mid),
                subMatriz(m2, mid, mid, mid)
            )

            // Calculamos las submatrices de la matriz resultante
            val c11 = sumMatriz(multMatrizRec(a11, b11), multMatrizRec(a12, b21))
            val c12 = sumMatriz(multMatrizRec(a11, b12), multMatrizRec(a12, b22))
            val c21 = sumMatriz(multMatrizRec(a21, b11), multMatrizRec(a22, b21))
            val c22 = sumMatriz(multMatrizRec(a21, b12), multMatrizRec(a22, b22))

            // Combinamos las submatrices para formar la matriz completa
            val top = c11.zip(c12).map { case (left, right) => left ++ right }
            val bottom = c21.zip(c22).map { case (left, right) => left ++ right }
            top ++ bottom
            }
        }

    def multMatrizRecPar(m1: Matriz, m2: Matriz): Matriz = {
        val n = m1.length
        val umbral = 16  // Establecemos un umbral para evitar paralelización innecesaria en matrices pequeñas

        if (n <= umbral) {
            // Caso base: cuando la matriz es lo suficientemente pequeña, calculamos de manera secuencial
            multMatrizRec(m1, m2)  // Usamos la función recursiva secuencial como base
        } else {
            val mid = n / 2

            // Dividimos las matrices en submatrices
            val (a11, a12, a21, a22) = (
                subMatriz(m1, 0, 0, mid),
                subMatriz(m1, 0, mid, mid),
                subMatriz(m1, mid, 0, mid),
                subMatriz(m1, mid, mid, mid)
            )
            val (b11, b12, b21, b22) = (
                subMatriz(m2, 0, 0, mid),
                subMatriz(m2, 0, mid, mid),
                subMatriz(m2, mid, 0, mid),
                subMatriz(m2, mid, mid, mid)
            )

            // Paralelizamos las multiplicaciones de las submatrices
            val (c11, c12, c21, c22) = parallel(
                sumMatriz(multMatrizRecPar(a11, b11), multMatrizRecPar(a12, b21)),
                sumMatriz(multMatrizRecPar(a11, b12), multMatrizRecPar(a12, b22)),
                sumMatriz(multMatrizRecPar(a21, b11), multMatrizRecPar(a22, b21)),
                sumMatriz(multMatrizRecPar(a21, b12), multMatrizRecPar(a22, b22))
            )

            // Combinamos las submatrices para formar la matriz resultante
            val top = c11.zip(c12).map { case (left, right) => left ++ right }
            val bottom = c21.zip(c22).map { case (left, right) => left ++ right }
            top ++ bottom
        }
    }


    def multStrassen(m1:Matriz,m2:Matriz):Matriz={
        //Multiplicación de matrices por el método de Strassen
        val n = m1.length
        if(n == 1){
            //caso base: cuando la matriz es de tamaño 1x1
            Vector(Vector(m1(0)(0)*m2(0)(0)))
        }else{
            val m = n/2 //=> al ser la matriz de tamaño n que es potencia de 2,  de tamaño m
            //cada matriz se divide en 4 submatrices
            val a = subMatriz(m1,0,0,m)
            val b = subMatriz(m1,0,m,m)
            val c = subMatriz(m1,m,0,m)
            val d = subMatriz(m1,m,m,m)

            val e = subMatriz(m2,0,0,m)
            val f = subMatriz(m2,0,m,m)
            val g = subMatriz(m2,m,0,m)
            val h = subMatriz(m2,m,m,m)

            // se calcula los productos de las submatrices
            val p1 = multStrassen(a,restaMatriz(f,h))   
            val p2 = multStrassen(sumMatriz(a,b),h)
            val p3 = multStrassen(sumMatriz(c,d),e)
            val p4 = multStrassen(d,restaMatriz(g,e))
            val p5 = multStrassen(sumMatriz(a,d),sumMatriz(e,h))
            val p6 = multStrassen(restaMatriz(b,d),sumMatriz(g,h))
            val p7 = multStrassen(restaMatriz(a,c),sumMatriz(e,f))

            //se calculan las submatrices de la matriz resultante
            val c11 = sumMatriz(restaMatriz(sumMatriz(p5,p4),p2),p6)
            val c12 = sumMatriz(p1,p2)
            val c21 = sumMatriz(p3,p4)
            val c22 = restaMatriz(restaMatriz(sumMatriz(p1,p5),p3),p7)

            //se concatenan las submatrices para formar la matriz resultante
            
            val c1 = c11.zip(c12).map({case (i,j) => i ++ j})
            val c2 = c21.zip(c22).map({case (i,j) => i ++ j})
            c1 ++ c2
        }
    }

    def multStrassenPar(m1:Matriz,m2:Matriz) : Matriz = {

        //Se crea las 4 submatrices de la matriz m1
        val (a11, a12, a21, a22) = (
            subMatriz(m1,0,0,m1.length/2),
            subMatriz(m1,0,m1.length/2,m1.length/2),
            subMatriz(m1,m1.length/2,0,m1.length/2),
            subMatriz(m1,m1.length/2,m1.length/2,m1.length/2)
            )
        
        //Se crea las 4 submatrices de la matriz m2
        val (b11, b12, b21, b22) = (
            subMatriz(m2,0,0,m2.length/2),
            subMatriz(m2,0,m2.length/2,m2.length/2),
            subMatriz(m2,m2.length/2,0,m2.length/2),
            subMatriz(m2,m2.length/2,m2.length/2,m2.length/2)
            )
        
        //hallo las 4 submatrices de la matriz resultante, paralell de 4
        val (c11, c12, c21, c22) = parallel(
            sumMatriz(multStrassen(a11,b11),multStrassen(a12,b21)),
            sumMatriz(multStrassen(a11,b12),multStrassen(a12,b22)),
            sumMatriz(multStrassen(a21,b11),multStrassen(a22,b21)),
            sumMatriz(multStrassen(a21,b12),multStrassen(a22,b22))
        )

        //concateno las submatrices para formar la matriz resultante
        val c1 = c11.zip(c12).map({case (i,j) => i ++ j})
        val c2 = c21.zip(c22).map({case (i,j) => i ++ j})
        c1 ++ c2

    }

    def compararAlgoritmos(f1 : (Matriz, Matriz) => Matriz,f2 : (Matriz, Matriz) => Matriz)(m1:Matriz, m2:Matriz): List[Double] = {
        val timef1 = withWarmer(new Default) measure{f1(m1,m2)}
        val timef2 = withWarmer(new Default) measure{f2(m1,m2)}

        List(timef1.value, timef2.value, timef1.value / timef2.value)
    }

    //Comparacion de producto punto secuencial y paralelo

    def compararProdPunto(f1 : (Vector[Int], Vector[Int]) => Int, f2 : (ParVector[Int], ParVector[Int]) => Int)(v1:Vector[Int], v2:Vector[Int]): List[Double] = {
        val timef1 = withWarmer(new Default) measure{f1(v1,v2)}
        val timef2 = withWarmer(new Default) measure{f2(v1.par,v2.par)}

        List(timef1.value, timef2.value, timef1.value / timef2.value)
    }

}