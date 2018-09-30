package com.example.tom.instacard.feature

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tom.instacard.R
import kotlinx.android.synthetic.main.picture_page.view.*

class ImageAdapter(private val pictures: List<String>): PagerAdapter(){

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
                .load(picture)
                .apply(RequestOptions().centerInside().override(ivPhoto.maxWidth, ivPhoto.maxHeight))
                .into(ivPhoto)

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }
}