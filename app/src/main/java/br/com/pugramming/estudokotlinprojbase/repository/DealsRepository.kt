package br.com.pugramming.estudokotlinprojbase.repository

import br.com.pugramming.estudokotlinprojbase.remote.model.Car
import br.com.pugramming.estudokotlinprojbase.remote.webservices.DealsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DealsRepository(private val dealsService:DealsService){

    fun getDeals(dealsCallback: DealsCallback){
        val call = dealsService.getDeals()
        call.enqueue(object: Callback<List<Car>> {
            override fun onResponse(call: Call<List<Car>>,
                                    response: Response<List<Car>>
            ) {
               if(response.isSuccessful) {
                   val resp = response.body()
                   dealsCallback.onSuccess(resp ?: emptyList())
               }else{
                   dealsCallback.onError("erro")
               }
            }

            override fun onFailure(call: Call<List<Car>?>?,
                                   t: Throwable?) {
                dealsCallback.onError("erro2")
            }
        })
    }

    interface DealsCallback{
        fun onSuccess(carList: List<Car>)
        fun onError(error: String)
    }

}