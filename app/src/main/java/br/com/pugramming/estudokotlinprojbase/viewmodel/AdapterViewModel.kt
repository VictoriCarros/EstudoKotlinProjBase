package br.com.pugramming.estudokotlinprojbase.viewmodel

import android.app.Application
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.AndroidViewModel
import br.com.pugramming.estudokotlinprojbase.remote.model.Car
import br.com.pugramming.estudokotlinprojbase.utils.currencyReal
import com.bumptech.glide.Glide

class AdapterViewModel(car: Car):AndroidViewModel(Application()){

    val price = "R$ ${car.price.currencyReal()}"
    val trim = car.trim
    val year = "${car.manufactureYear} / ${car.modelYear}"
    val color = car.color
    val gear = car.gear
    val fuel = car.fuel
    val photos = car.photos

    //fun loadPhoto(view:ImageView, url:String) = Glide.with(view.context).load(url).into(view)

}