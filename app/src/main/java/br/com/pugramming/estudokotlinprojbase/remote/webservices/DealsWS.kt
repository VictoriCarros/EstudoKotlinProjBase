package br.com.pugramming.estudokotlinprojbase.remote.webservices

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.pugramming.estudokotlinprojbase.remote.model.Car

interface DealsWS{

    //Função que vai pegar um retorno do WS
    fun getAllDeals():LiveData<List<Car>>{
        val mutableDeals = MutableLiveData<List<Car>>()
        mutableDeals.value = listOf(Car(), Car(), Car()) //Setar valores reais
        return mutableDeals
    }

}