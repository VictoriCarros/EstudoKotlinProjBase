package br.com.pugramming.estudokotlinprojbase.repository

import androidx.lifecycle.LiveData
import br.com.pugramming.estudokotlinprojbase.remote.model.Car
import br.com.pugramming.estudokotlinprojbase.remote.webservices.DealsWS

class DealsRepository:DealsWS{

    override fun getAllDeals(): LiveData<List<Car>> {
        return super.getAllDeals()
    }

}