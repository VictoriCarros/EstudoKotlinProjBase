package br.com.pugramming.estudokotlinprojbase

import android.widget.ImageView
import com.bumptech.glide.Glide
import androidx.databinding.BindingAdapter

class PhotosBinding {

    @BindingAdapter("bind:imageUrl")
    fun setImageUrl(view: ImageView, url: String) {
        Glide.with(view.context).load(url).into(view)
    }

}