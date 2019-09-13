package br.com.pugramming.estudokotlinprojbase.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.pugramming.estudokotlinprojbase.remote.model.Car
import br.com.pugramming.estudokotlinprojbase.repository.DealsRepository

class DealsListViewModel(private val repository: DealsRepository) : ViewModel(){

    private val mutableDeals = MutableLiveData<List<Car>>()
    val listOfDeals:LiveData<List<Car>> = mutableDeals

    fun loadDeals(){
        Log.d("DealsListViewModel","loadDeals")
        mutableDeals.value = repository.getAllDeals().value
    }

}