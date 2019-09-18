package br.com.pugramming.estudokotlinprojbase.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import br.com.pugramming.estudokotlinprojbase.AdapterPhotosDetails
import br.com.pugramming.estudokotlinprojbase.EquipmentsAdapter
import br.com.pugramming.estudokotlinprojbase.R
import br.com.pugramming.estudokotlinprojbase.databinding.ActivityDealsDetailsBinding
import br.com.pugramming.estudokotlinprojbase.remote.model.Car
import br.com.pugramming.estudokotlinprojbase.utils.currencyReal

class DealsDetailsActivity : AppCompatActivity(){

    private lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = intent.extras

        val binding = DataBindingUtil.setContentView<ActivityDealsDetailsBinding>(
            this, R.layout.activity_deals_details)

        car = bundle!!.getParcelable("car")!!

        setupBindings(binding)

        setupAdapters(binding.slider, bundle.getInt("pagerPosition"), binding.rvEquipments)
    }

    fun setupBindings(binding: ActivityDealsDetailsBinding){
        with(binding){
            binding.tvColor.text = car.color
            binding.tvTrim.text = car.trim
            binding.tvPrice.text = car.price.currencyReal()
            binding.tvGear.text = car.gear
            binding.tvFuel.text = car.fuel
            binding.tvMakeModel.text = "${car.make} ${car.model} - ${car.doors} portas"
            binding.tvYears.text = "${car.modelYear} / ${car.manufactureYear}"
            binding.rvEquipments.adapter = EquipmentsAdapter(car.equipments)

            Log.d("eqps", car.equipments.get(0).description)
            executePendingBindings()
        }
    }

    fun setupAdapters(slider:ViewPager, sliderPosition: Int = 0, recycler:RecyclerView){
        //setup slider
        if(!car.photos.isNullOrEmpty())
            slider.adapter = AdapterPhotosDetails(car.photos!!, sliderPosition, this)
        else{
            //viewmodel -> ocultar slider?
        }

        //setup recyclerview
        //recycler.adapter = EquipmentsAdapter(car.equipments)
    }
}