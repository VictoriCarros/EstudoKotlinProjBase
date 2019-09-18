package br.com.pugramming.estudokotlinprojbase

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.pugramming.estudokotlinprojbase.databinding.CarItemBinding
import br.com.pugramming.estudokotlinprojbase.remote.model.Car
import br.com.pugramming.estudokotlinprojbase.viewmodel.AdapterDealsListViewModel

//Ao implementar o ListAdapter não é necessário dar overrite no getItemCount()
class DealsAdapter(private val itemClick: (Car) -> Unit, private val act: Activity):ListAdapter<Car, DealsAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealsAdapter.ViewHolder {
        val binding:CarItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.car_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DealsAdapter.ViewHolder, position: Int) {
        getItem(position)?.let { car ->
            with (holder) {
                itemView.tag = car
                bind(car, createOnClickListener(car), act)
           }
        }
    }

    private fun createOnClickListener(car: Car): View.OnClickListener {
        return View.OnClickListener { itemClick(car) }
    }

    class ViewHolder(private val binding: CarItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(carDeal: Car, listener: View.OnClickListener, act: Activity) {
            with (binding) {
                viewModel = AdapterDealsListViewModel(carDeal)
                clickListener = listener

                val adapter = AdapterPhotos(carDeal, act)
                binding.slider.adapter = adapter

                executePendingBindings()
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Car>() {
        override fun areItemsTheSame(oldItem: Car, newItem: Car): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Car, newItem: Car): Boolean {
            return oldItem == newItem
        }
    }
}
