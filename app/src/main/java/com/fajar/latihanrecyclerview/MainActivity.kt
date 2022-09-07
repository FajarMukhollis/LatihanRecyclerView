package com.fajar.latihanrecyclerview

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvAnime: RecyclerView
    private val list = ArrayList<Anime>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAnime = findViewById(R.id.rv_anime)
        rvAnime.setHasFixedSize(true)

        list.addAll(listAnime)
        showRecyclerList()

        //Layout manager
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvAnime.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvAnime.layoutManager = LinearLayoutManager(this)
        }
    }

    private val listAnime: ArrayList<Anime>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
            val listAnime = ArrayList<Anime>()
            for (i in dataName.indices) {
                val anime = Anime(dataName[i],dataDescription[i], dataPhoto.getResourceId(i, -1))
                listAnime.add(anime)
            }
            return listAnime
        }
    private fun showRecyclerList() {
        rvAnime.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListAnimeAdapter(list)
        rvAnime.adapter = listHeroAdapter
    }
}