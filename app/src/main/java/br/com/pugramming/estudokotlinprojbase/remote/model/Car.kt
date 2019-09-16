package br.com.pugramming.estudokotlinprojbase.remote.model

data class Car(
    val color: String,
    val doors: Int,
    val equipments: List<Equipment>,
    val fuel: String,
    val gear: String,
    val make: String,
    val manufactureYear: Int,
    val model: String,
    val modelYear: Int,
    val photos: List<String>,
    val price: Int,
    val trim: String
)