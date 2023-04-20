package Euler_Impro


import Euler.ySiguiente
import java.io.File
import java.io.FileWriter
import kotlin.math.pow

fun main() {
    //apertura y wrapper de archivo
    val archivo = File("euler_improved.dat")
    val archivoW = FileWriter(archivo)


    /*valores iniciales
    n: numero de intervalos
    x,y coordedanas iniciales*/
    val n = 20
    var x = 0.50
    var xf = 6.0
    var y = 2.0
    val intervalo = intervaloH(x, xf, n)

    //escritura de primer punto
    var cadena = String.format("%.8f",x) + "\t" + String.format("%.8f",y) + "\n"
    archivoW.write(cadena)
    println("Apertura de archivo")

    //ciclo de cálculo y escritura en documento euler.dat

    println("Comenzando ciclo")
    for(indice in 1..n){
        var slope1 = diferencial(x, y)
        var yIntermedio = y + dyEuler(slope1,intervalo)
        x+=intervalo
        var slope2 = diferencial(x,yIntermedio)
        y += dyEulerImproved(intervalo,slope1,slope2)
        println(x.toString()+" " + y.toString())
        cadena = String.format("%.8f",x) + "\t" + String.format("%.8f",y) + "\n"
        archivoW.write(cadena)

    }

    //Cierre de archivo
    archivoW.close()
    println("Archivo generado, proceso terminado")




}
//Ecuación Diferencial

fun diferencial(xVariable:Double, yVariable:Double):Double{
    return yVariable/xVariable
}

//calculador de intervalo
fun intervaloH(xInicial:Double, xFinal:Double, nIntervalos: Int): Double {
    val h = (xFinal - xInicial) / nIntervalos.toDouble()
    return h
}

//calculo de y intermedia
fun dyEuler(pendiente:Double,intervalo:Double):Double{
    return intervalo*pendiente
}

//Calculo y final
fun dyEulerImproved(intervalo: Double,pendiente1:Double,pendiente2:Double):Double{
    return intervalo*(pendiente1+pendiente2)/2.0
}