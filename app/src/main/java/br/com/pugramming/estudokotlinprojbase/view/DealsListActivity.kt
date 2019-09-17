package br.com.pugramming.estudokotlinprojbase.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import br.com.pugramming.estudokotlinprojbase.DealsAdapter
import br.com.pugramming.estudokotlinprojbase.R
import br.com.pugramming.estudokotlinprojbase.databinding.ActivityDealslistBinding
import br.com.pugramming.estudokotlinprojbase.remote.model.Car
import br.com.pugramming.estudokotlinprojbase.remote.webservices.DealsServiceFactory
import br.com.pugramming.estudokotlinprojbase.repository.DealsRepository
import br.com.pugramming.estudokotlinprojbase.viewmodel.DealsListViewModel

//lar
class DealsListActivity : AppCompatActivity() {

    private val repository = DealsRepository(DealsServiceFactory.createDealsService())
    private val viewModel = DealsListViewModel(repository)
    private lateinit var adapter: DealsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityDealslistBinding>(
            this, R.layout.activity_dealslist)
        binding.lifecycleOwner = this

        bindObservable()

        viewModel.loadDeals()
        setupAdapter(binding.rvCars)

    }

    private fun setupAdapter(recyclerView: RecyclerView) {
        Log.d("DealsListActivity","setupAdapter")
        adapter =
            DealsAdapter(::onItemClick, this)

        recyclerView.adapter = adapter
        //recyclerView.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
    }

    private fun onItemClick(car: Car) {
       Log.d("onItemClick","clicou ${car.trim}")
    }

    private fun bindObservable() {
        viewModel.listOfDeals.observe(this, Observer { dealersList ->
            dealersList?.let {
                //Não é preciso declarar lista dentro do adapter, ele já tem uma por padrão
               adapter.submitList(dealersList)
            }
        })
    }
}
