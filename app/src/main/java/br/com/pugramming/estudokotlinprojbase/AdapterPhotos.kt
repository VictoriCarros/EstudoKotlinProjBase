package br.com.pugramming.estudokotlinprojbase

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import br.com.pugramming.estudokotlinprojbase.remote.model.Car
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

//inner constructor makes the class available to everybody but the constructor only to inside the module
class AdapterPhotos(
    private val car: Car,
    private val context: Context) : PagerAdapter() {

    private var layoutInflater : LayoutInflater? = null

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view ===  `object`
    }

    override fun getCount(): Int {
        return car.photos?.size ?: 0
    }

    @SuppressLint("InflateParams")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = container.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = layoutInflater!!.inflate(R.layout.photo_item, null)
        val image = v.findViewById<View>(R.id.imgPhoto) as ImageView

        Glide.with(context)
            .load(car.photos!![position])
            .error(R.drawable.erroplaceholder)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(image)

        image.setOnClickListener {
            var bundle = bundleOf(
                "car" to car,
                "pagerPosition" to position)
            container.findNavController().navigate(R.id.action_list_to_details, bundle)
        }

        val vp = container as ViewPager
        vp.addView(v , 0)

        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val v = `object` as View
        vp.removeView(v)
    }
}