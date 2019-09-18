package br.com.pugramming.estudokotlinprojbase.remote.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Equipment(
    val category: String,
    val description: String
):Parcelable