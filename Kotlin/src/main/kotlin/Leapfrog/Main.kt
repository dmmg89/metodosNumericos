package Leapfrog

import java.io.File
import java.io.FileWriter
import kotlin.math.pow

fun main(){

    //apertura y wrapper de archivo

    val archivo = File("leapfrog.dat")
    val archivoW = FileWriter(archivo)
    println("Apertura de archivo")
    //Condiciones iniciales
    var dTiempo = 0.05
    var xInicial = 1.0
    var vInicial = 0.8
    var tiempo = 0.0
    var tiempoFinal = 10.0

    var cadena = String.format("%.8f",tiempo) + "\t" + String.format("%.8f",xInicial)+ "\t" +String.format("%.8f",vInicial) +"\n"
    archivoW.write(cadena)



    var xVariable:Double = xInicial
    var vVariable:Double = vInicial
    var aceleracion:Double
/*    //Ciclo de cálculo, calcula aceleración, variable posterior,
    velocidad posterior y tiempo, se formatea la cadena
    para escribir en el archivo*/
    println("Cálculo en proceso...")
    do{
        aceleracion = aceleration(xVariable)
        xVariable += dxJump(dTiempo,vVariable,aceleracion)
        vVariable += dvJump(dTiempo,aceleracion, aceleration(xVariable))
        tiempo += dTiempo

        cadena = String.format("%.8f",tiempo) + "\t" + String.format("%.8f",xVariable)+ "\t" +String.format("%.8f",vVariable) +"\n"
        archivoW.write(cadena)
    }while (tiempo<=tiempoFinal)


    //Cierre de archivo
    archivoW.close()
    println("Archivo generado, proceso terminado")


}


//ecuación para la aceleración
fun aceleration(xSet:Double):Double{
    return -3.0*xSet
}

//Aumento a la velocidad
fun dvJump(dTime: Double,aSet: Double,a2Set:Double):Double{
    return 0.5*(aSet+a2Set)*dTime
}

//Aumento a la posición
fun dxJump(dTime:Double,vSet:Double, aSet:Double):Double{
    return vSet*dTime+0.5*aSet*dTime.pow(2.0)
}

