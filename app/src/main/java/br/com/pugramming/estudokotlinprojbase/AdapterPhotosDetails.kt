package br.com.pugramming.estudokotlinprojbase

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class AdapterPhotosDetails(
    private val photos: List<String>,
    private var sliderPosition: Int,
    private val act: Activity) : PagerAdapter() {

    private var carregouSlideSelecionado = false
    private var layoutInflater : LayoutInflater? = null

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view ===  `object`
    }

    override fun getCount(): Int {
        return photos.size
    }

    @SuppressLint("InflateParams")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = container.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = layoutInflater!!.inflate(R.layout.photo_item, null)
        val image = v.findViewById<View>(R.id.imgPhoto) as ImageView

        val vp = container as ViewPager
        vp.addView(v , 0)

        if(!carregouSlideSelecionado)
            vp.currentItem = sliderPosition
        carregouSlideSelecionado = true

        Glide.with(act)
            .load(photos[position])
            .error(R.drawable.erroplaceholder)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(image)

        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val v = `object` as View
        vp.removeView(v)
    }
}