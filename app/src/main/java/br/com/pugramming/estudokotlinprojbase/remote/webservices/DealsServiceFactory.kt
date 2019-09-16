package br.com.pugramming.estudokotlinprojbase.remote.webservices

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object DealsServiceFactory {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://private-525ce1-icarrostest.apiary-mock.com/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun createDealsService() = getRetrofit().create(DealsService::class.java)

}