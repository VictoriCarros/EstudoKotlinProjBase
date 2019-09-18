package br.com.pugramming.estudokotlinprojbase.utils

import android.content.Context
import android.content.Intent
import java.text.NumberFormat


fun Int.currencyReal():String{
        val numberf = NumberFormat.getCurrencyInstance()
        return numberf.format(this.toDouble()).replace("R$", "").trim()
}
