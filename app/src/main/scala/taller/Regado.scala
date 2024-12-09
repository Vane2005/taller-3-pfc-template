package taller
import scala.util.Random
import common._
import org.scalameter.withWarmer
import org.scalameter.Warmer
import org.scalameter.measure
import org.scalameter.Warmer.Default
import scala.collection.parallel.immutable.ParVector
import scala.collection.parallel.CollectionConverters._

class Regado() {
    
    //definicion de tipos
    type Tablon = (Int, Int, Int)  //tsi, tri, pi
    type Finca = Vector[Tablon]
    type Distancia = Vector[Vector[Int]]
    type ProgRiego = Vector[Int] //v(i) es el tuno de riego del tablon i
    type TiempoInicioRiego = Vector[Int] //t de este tipo, t(i) es la hora a la que inicia a regarse el tablon i

    //generación de entradas aleatorias
    val random = new Random()

    def fincaAlAzar(long:Int) : Finca = {
        val v = Vector.fill(long)(
            (random.nextInt(long*2)+1,
            random.nextInt(long) + 1,
            random.nextInt(4)+1)
        )
        v
    }

    def distanciaAlAzar(long:Int) : Distancia = {
        val v = Vector.fill(long, long)(random.nextInt(long*3)+1)
        Vector.tabulate(long,long)((i,j) => 
            if (i<j) v(i)(j)
            else if (i == j) 0
            else v(j)(i))
    }

    def generarProgRiegoAlAzar(n: Int): ProgRiego = {
        val random = new Random()
        random.shuffle((0 until n).toVector)
    }

    //exploracion de entradas
    def tsup(f:Finca, i:Int) : Int = {
        f(i)._1
    }

    def treg(f:Finca, i:Int) : Int = {
        f(i)._2
    }

    def prio(f:Finca, i:Int) : Int = {
        f(i)._3
    }


    //VERSIONES SECUENCIALES

    //tiempo de inicio de riego para cada tablon i
    def tIR(f: Finca, pi:ProgRiego) : TiempoInicioRiego = {
        val tiempos = Array.fill(f.length)(0)
        for (j <- 1 until pi.length) {
            val prevTablon = pi(j-1)
            val currTablon = pi(j)
            tiempos(currTablon) = tiempos(prevTablon) + treg(f, prevTablon) 
        }
        tiempos.toVector
    }


    //calculo de costos
    def costoRiegoTablon(i:Int, f:Finca, pi:ProgRiego) : Int = {
        val tiempoInicio = tIR(f, pi)(i)
        val tiempoFinal = tiempoInicio + treg(f, i)
        if (tsup(f,i) - treg(f, i) >= tiempoInicio) {
            tsup(f,i) - tiempoFinal
        } else  {
            prio(f,i) * (tiempoFinal - tsup(f,i))
        }
    }

    def costoRiegoFinca(f:Finca, pi:ProgRiego) : Int = {
        (0 until f.length).map(i => costoRiegoTablon(i, f, pi)).sum
    }

    def costoMovilidad(f:Finca, pi:ProgRiego, d:Distancia) : Int = {
        (0 until pi.length - 1).map(j => d(pi(j))(pi(j+1))).sum
    }

    def generarProgramacionesRiego(f:Finca) : Vector[ProgRiego] = {
        //devuelve todas las posibles prog de riego de la finca
        val indices = (0 until f.length).toVector
        indices.permutations.toVector
    }

    def ProgramacionRiegoOptimo(f:Finca, d:Distancia) : (ProgRiego, Int) = {
        val programaciones = generarProgramacionesRiego(f)
        val costos = programaciones.map(pi => 
            (pi, costoRiegoFinca(f, pi) + costoMovilidad(f, pi, d))
        )
        costos.minBy(_._2)
    }


    //VERSIONES PARALELAS

    def costoRiegoFincaPar(f:Finca, pi:ProgRiego) : Int = {
        (0 until f.length).par.map(i => costoRiegoTablon(i, f, pi)).sum
    }

    def costoMovilidadPar(f:Finca,pi:ProgRiego, d:Distancia) : Int = {
        (0 until pi.length - 1).par.map(j => d(pi(j))(pi(j+1))).sum
    }

    def generarProgramacionesRiegoPar(f:Finca) : Vector[ProgRiego] = {
        //devuelve todas las posibles prog de riego de la finca
        val indices = (0 until f.length).toVector
        indices.permutations.toVector.par.toVector
    }

    def ProgramacionRiegoOptimoPar(f:Finca, d:Distancia) : (ProgRiego, Int) = {
        val programaciones = generarProgramacionesRiegoPar(f)
        val costos = programaciones.par.map(pi => 
            (pi, costoRiegoFincaPar(f, pi) + costoMovilidadPar(f, pi, d))
        )
        costos.minBy(_._2)
    }

    def compararCostoRiegoFinca(seq : (Finca, ProgRiego) => Int,par : (Finca, ProgRiego) => Int)(finca : Finca, programRiego : ProgRiego): List[Double] = {
        val tiempoSeq = withWarmer(new Default) measure{seq(finca, programRiego)}
        val tiempoPar = withWarmer(new Default) measure{par(finca, programRiego)}

        List(tiempoSeq.value, tiempoPar.value, tiempoSeq.value / tiempoPar.value)
    }

    def compararCostoMovilidad(seq : (Finca, ProgRiego, Distancia) => Int,par : (Finca, ProgRiego, Distancia) => Int)(finca : Finca, programRiego : ProgRiego, distancias : Distancia): List[Double] = {
        val tiempoSeq = withWarmer(new Default) measure{seq(finca, programRiego, distancias)}
        val tiempoPar = withWarmer(new Default) measure{par(finca, programRiego, distancias)}

        List(tiempoSeq.value, tiempoPar.value, tiempoSeq.value / tiempoPar.value)
    }

    def compararProgramacionRiegoOptimo(seq : (Finca, Distancia) => (ProgRiego, Int),par : (Finca, Distancia) => (ProgRiego, Int))(finca : Finca, distancias : Distancia): List[Double] = {
        val tiempoSeq = withWarmer(new Default) measure{seq(finca, distancias)}
        val tiempoPar = withWarmer(new Default) measure{par(finca, distancias)}

        List(tiempoSeq.value, tiempoPar.value, tiempoSeq.value / tiempoPar.value)
    }

    def compararGenerarProgramacionesRiego(seq : (Finca) => Vector[ProgRiego], par : (Finca) => Vector[ProgRiego])(finca : Finca): List[Double] = {
        val tiempoSeq = withWarmer(new Default) measure{seq(finca)}
        val tiempoPar = withWarmer(new Default) measure{par(finca)}

        List(tiempoSeq.value, tiempoPar.value, tiempoSeq.value / tiempoPar.value)
    }


}