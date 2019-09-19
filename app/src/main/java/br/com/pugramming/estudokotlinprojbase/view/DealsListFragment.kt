package br.com.pugramming.estudokotlinprojbase.view

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.pugramming.estudokotlinprojbase.DealsAdapter
import br.com.pugramming.estudokotlinprojbase.R
import br.com.pugramming.estudokotlinprojbase.databinding.CarItemBinding
import br.com.pugramming.estudokotlinprojbase.remote.model.Car
import br.com.pugramming.estudokotlinprojbase.remote.webservices.DealsServiceFactory
import br.com.pugramming.estudokotlinprojbase.repository.DealsRepository
import br.com.pugramming.estudokotlinprojbase.viewmodel.DealsListViewModel
import kotlinx.android.synthetic.main.fragment_deals_list.view.*

class DealsListFragment : Fragment() {
    private var listener: OnFragmentInteractionListener? = null
    private val repository = DealsRepository(DealsServiceFactory.createDealsService())
    private val viewModel = DealsListViewModel(repository)
    private lateinit var fragmentDealsListBinding:View
    private lateinit var adapter: DealsAdapter
    private var ctx: Context? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ctx = context

        fragmentDealsListBinding = inflater.inflate(R.layout.fragment_deals_list, container, false)
        val binding: CarItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.car_item, container, false)

        binding.lifecycleOwner = this

        bindObservable()

        viewModel.loadDeals()
        setupAdapter(fragmentDealsListBinding.rvCars)

        return fragmentDealsListBinding
    }

    private fun onItemClick(car: Car) {
        var bundle = bundleOf(Pair("car", car))
        fragmentDealsListBinding.findNavController().navigate(R.id.action_list_to_details, bundle)
    }

    private fun bindObservable() {
        viewModel.listOfDeals.observe(this, Observer { dealersList ->
            dealersList?.let {
                adapter.submitList(dealersList)
            }
        })
    }

    private fun setupAdapter(recyclerView: RecyclerView) {
        Log.d("NavMainActivity","setupAdapter")
        adapter = DealsAdapter(::onItemClick, ctx!!)

        recyclerView.adapter = adapter
        //recyclerView.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

}