package br.com.pugramming.estudokotlinprojbase.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.pugramming.estudokotlinprojbase.R
import br.com.pugramming.estudokotlinprojbase.databinding.CarItemBinding
import br.com.pugramming.estudokotlinprojbase.databinding.PhotosItemBinding

class PhotosFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: PhotosItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.car_item, parent, false)

        val view = inflater.inflate(R.layout.first_fragment, container, false)
        val textView = view.findViewById<TextView>(R.id.txtMain)
        textView.setText(R.string.first_fragment)

        val imageView = view.findViewById<ImageView>(R.id.imgMain)
        imageView.setImageResource(R.mipmap.ic_launcher)

        return view
    }
}
