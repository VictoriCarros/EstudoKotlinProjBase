package br.com.pugramming.estudokotlinprojbase

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.com.pugramming.estudokotlinprojbase.view.PhotosFragment

class AdapterPhotos(manager: FragmentManager, private val photos: List<String>) :
    FragmentPagerAdapter(manager,
        FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getItem(position: Int): Fragment {
        return PhotosFragment.newInstance(photos.get(position))
    }

    override fun getCount(): Int {
        return photos.size
    }
}
