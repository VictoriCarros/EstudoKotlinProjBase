package br.com.pugramming.estudokotlinprojbase.remote.model

data class Car(
    val price:Int = 0,
    val trim:String = "teste",
    val year:String = "",
    val color:String = "colorteste",
    val gear:String = "",
    val fuel:String = ""
)