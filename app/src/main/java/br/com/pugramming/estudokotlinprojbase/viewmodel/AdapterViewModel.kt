package br.com.pugramming.estudokotlinprojbase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.pugramming.estudokotlinprojbase.remote.model.Car

class AdapterViewModel(car: Car):AndroidViewModel(Application()){

    val price = car.price
    val trim = car.trim
    val year = car.year
    val color = car.color
    val gear = car.gear
    val fuel = car.fuel

}