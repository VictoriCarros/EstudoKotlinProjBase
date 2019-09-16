package br.com.pugramming.estudokotlinprojbase.remote.webservices

import br.com.pugramming.estudokotlinprojbase.remote.model.Car
import retrofit2.Call
import retrofit2.http.GET

interface DealsService {
    @GET("deals")
    fun getDeals(): Call<List<Car>>
}