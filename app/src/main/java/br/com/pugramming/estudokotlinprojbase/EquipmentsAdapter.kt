package br.com.pugramming.estudokotlinprojbase

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.pugramming.estudokotlinprojbase.databinding.CarEquipmentsRowItemBinding
import br.com.pugramming.estudokotlinprojbase.remote.model.Equipment

class EquipmentsAdapter(private val equipementList:List<Equipment>)
    : RecyclerView.Adapter<EquipmentsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipmentsAdapter.ViewHolder {
        val binding:CarEquipmentsRowItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.car_equipments_row_item,
            parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = equipementList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        for(eq in equipementList){
            Log.d("eqpsOnBind", eq.category)
        }


        holder.bind(equipementList[position])
    }

    class ViewHolder(private val binding: CarEquipmentsRowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(equipment: Equipment) {
            with(binding){
                binding.tvCategory.text = equipment.category
                binding.tvDescription.text = equipment.description
                executePendingBindings()
            }
        }
    }
}


/*
class EquipmentsAdapter: ListAdapter<Equipment, EquipmentsAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: CarEquipmentsRowItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.car_equipments_row_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { equipment ->
            with (holder) {
                bind(equipment)
            }
        }
    }

    class ViewHolder(private val binding: CarEquipmentsRowItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(equipment: Equipment) {
            with (binding) {
                viewModel = AdapterEquipentsViewModel(equipment)
                executePendingBindings()
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Equipment>() {
        override fun areItemsTheSame(oldItem: Equipment, newItem: Equipment): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Equipment, newItem: Equipment): Boolean {
            return oldItem == newItem
        }
    }
}

 */