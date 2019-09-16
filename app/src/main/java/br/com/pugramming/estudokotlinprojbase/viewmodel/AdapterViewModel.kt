package br.com.pugramming.estudokotlinprojbase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.pugramming.estudokotlinprojbase.remote.model.Car

class AdapterViewModel(car: Car):AndroidViewModel(Application()){

    val price = car.price.toString()
    val trim = car.trim
    val year = "${car.manufactureYear} / ${car.modelYear}"
    val color = car.color
    val gear = car.gear
    val fuel = car.fuel

}