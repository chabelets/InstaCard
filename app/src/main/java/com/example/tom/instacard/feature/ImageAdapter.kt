package com.example.tom.instacard.feature

import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.tom.instacard.R
import com.example.tom.instacard.pojo.Picture
import kotlinx.android.synthetic.main.picture_page.view.*

class ImageAdapter(private val pictures: List<Picture>): PagerAdapter(){

//    override fun isViewFromObject(p0: View, p1: Any): Boolean {
//        return p0 === p1 as android.view.View
//    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return pictures.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val picture = pictures[position]
        val view = LayoutInflater.from(container.context)
                .inflate(R.layout.picture_page, container, false)
        val ivPhoto: ImageView = view.photo1

        Glide.with(container.context)
                .load(picture.museumName[position])
                .into(ivPhoto)

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }
}