package br.com.pugramming.estudokotlinprojbase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.pugramming.estudokotlinprojbase.remote.model.Equipment


class AdapterEquipentsViewModel(equipment: Equipment): AndroidViewModel(Application()){

    val category = equipment.category
    val description = equipment.description
}