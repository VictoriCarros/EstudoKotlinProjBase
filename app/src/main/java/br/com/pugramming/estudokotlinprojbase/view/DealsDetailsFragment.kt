package br.com.pugramming.estudokotlinprojbase.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.pugramming.estudokotlinprojbase.AdapterPhotosDetails
import br.com.pugramming.estudokotlinprojbase.EquipmentsAdapter
import br.com.pugramming.estudokotlinprojbase.R
import br.com.pugramming.estudokotlinprojbase.remote.model.Car
import br.com.pugramming.estudokotlinprojbase.remote.model.Equipment
import br.com.pugramming.estudokotlinprojbase.utils.currencyReal
import kotlinx.android.synthetic.main.car_item.view.slider
import kotlinx.android.synthetic.main.car_item.view.tvColor
import kotlinx.android.synthetic.main.car_item.view.tvFuel
import kotlinx.android.synthetic.main.car_item.view.tvGear
import kotlinx.android.synthetic.main.car_item.view.tvPrice
import kotlinx.android.synthetic.main.car_item.view.tvTrim
import kotlinx.android.synthetic.main.car_item.view.tvYears
import kotlinx.android.synthetic.main.fragment_deals_details.view.*

class DealsDetailsFragment : Fragment() {

    lateinit var carEquipments:List<Equipment>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_deals_details, container, false)
        val car: Car? = arguments?.getParcelable("car")

        view.tvColor.text = car?.color
        view.tvTrim.text = car?.trim
        view.tvPrice.text = car?.price?.currencyReal()
        view.tvGear.text = car?.gear
        view.tvFuel.text = car?.fuel
        view.tvMakeModel.text = "${car?.make} ${car?.model} - ${car?.doors} portas"
        view.tvYears.text = "${car?.modelYear} / ${car?.manufactureYear}"


        view.rvEquipments.adapter = EquipmentsAdapter(groupList(car!!.equipments))

        val adapter = AdapterPhotosDetails(car.photos!!, arguments?.getInt("pagerPosition")?:0, context!!)
        view.slider.adapter = adapter

        return view
    }

    fun groupList(equipementList: List<Equipment>):List<Equipment>{
        val list = equipementList.groupBy({it.category}, {it.description})
        var groupedList = mutableListOf<Equipment>()

        for(eq in list){
            groupedList.add(Equipment(eq.key, eq.value.toString()
                .replace("[", "")
                .replace("]", "")))
        }

        return groupedList
    }

}