package com.example.tom.instacard.feature

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tom.instacard.R
import com.example.tom.instacard.pojo.Card
import java.io.InputStream
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var pictures = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        userAvatar.setOnClickListener {
            showToast("userAvatar")
        }
        like.setOnClickListener{
            showToast("like")
        }
        comment.setOnClickListener{
        showToast("comment")
        }
        share.setOnClickListener {
            showToast("share")
        }
        save.setOnClickListener {
            showToast("save")
        }
        iconMore.setOnClickListener {
            showToast("iconmore")
        }
        takePhoto.setOnClickListener{
            showToast("takePhoto")
        }
        takemsg.setOnClickListener {
            showToast("takemsg")
        }

        bottomNavigationView.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.ic_home -> {
                    showToast("Home")
                }
                R.id.ic_search -> {
                    showToast("Search")
                }
                R.id.ic_add -> {
                    showToast("Add")
                }
                R.id.ic_like -> {
                    showToast("Like")
                }
                R.id.ic_avatar -> {
                    showToast("Avatar")
                }
            }
        }
    }

    private fun init() {
        val card = parseModel()
        val adapter = ImageAdapter(pictures)
        viewPager.adapter = adapter
        setSupportActionBar(findViewById(R.id.toolbar))
        locationName.text = card!!.title.place
        userName.text = card.title.name
    }

    private fun parseModel(): Card? {
        val myJson = inputStreamToString(this.resources.openRawResource(R.raw.card))
        val card = Gson().fromJson(myJson, Card::class.java)
        pictures = card.picture.museumName as ArrayList<String>
        return card
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun inputStreamToString(inputStream: InputStream): String {
        val bytes = ByteArray(inputStream.available())
        inputStream.read(bytes, 0, bytes.size)
        return String(bytes)
    }

}
