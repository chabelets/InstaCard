package com.example.tom.instacard.feature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.bumptech.glide.Glide
import com.example.tom.instacard.R
import com.example.tom.instacard.pojo.Card
import com.example.tom.instacard.pojo.Picture
import java.io.InputStream
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val pictures = ArrayList<Picture>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myJson = inputStreamToString(this.resources.openRawResource(R.raw.card))
        val card = Gson().fromJson(myJson, Card::class.java)
        pictures.add(card.picture)
        val adapter = ImageAdapter(pictures)
        viewPager.adapter = adapter

//        Glide.with(this)
//                .load(card.picture.museumName)
//                .into(photo)

        locationName.text = card.title.place
        userName.text = card.title.name

    }

    fun showToast(msg: String) {
        Toast.makeText(this, msg, LENGTH_LONG).show()
    }

    private fun inputStreamToString(inputStream: InputStream): String {
        val bytes = ByteArray(inputStream.available())
        inputStream.read(bytes, 0, bytes.size)
        return String(bytes)
    }
}
