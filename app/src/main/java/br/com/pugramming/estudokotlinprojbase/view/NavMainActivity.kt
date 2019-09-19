package br.com.pugramming.estudokotlinprojbase.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.pugramming.estudokotlinprojbase.R
import br.com.pugramming.estudokotlinprojbase.databinding.ActivityMainNavBinding

class NavMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainNavBinding>(this,
            R.layout.activity_main_nav)
        binding.executePendingBindings()
    }

}
