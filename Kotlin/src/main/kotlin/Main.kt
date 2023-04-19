import java.io.File
import java.io.FileWriter
import kotlin.math.pow

fun main(){
    //apertura y wrapper de archivo
    val archivo = File("euler.dat")
    val archivoW =FileWriter(archivo)


    /*valores iniciales
    n: numero de intervalos
    x,y coordedanas iniciales*/
    val n = 5000
    var x = 0.50
    var xf = 8.0
    var y = 2.0
    val intervalo = intervaloH(x,xf,n)

    //escritura de primer punto
    var cadena = String.format("%.8f",x) + "\t" + String.format("%.8f",y) + "\n"
    archivoW.write(cadena)
    println("Apertura de archivo")

    //ciclo de cálculo y escritura en documento euler.dat

    println("Comenzando ciclo")
    for(indice in 1..n){
        var slope = diferencial(x,y)
        y = ySiguiente(slope,intervalo,y)
        x+=intervalo
        cadena = String.format("%.8f",x) + "\t" + String.format("%.8f",y) + "\n"
        archivoW.write(cadena)

    }

    //Cierre de archivo
    archivoW.close()
    println("Archivo generado, proceso terminado")
}

fun diferencial(xVariable:Double, yVariable:Double):Double{
    return xVariable.pow(2.0)-yVariable.pow(3.0)
}

fun intervaloH(xInicial:Double, xFinal:Double, nIntervalos: Int): Double{
    val h = (xFinal-xInicial)/nIntervalos.toDouble()
    return h
}

fun ySiguiente(pendiente:Double,intervalo:Double, yInicial:Double):Double{
    return yInicial + intervalo*pendiente
}

