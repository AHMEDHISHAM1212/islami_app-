package com.example.islamiapp.ui.SuraDetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapp.databinding.ActivitySuraDetailsBinding
import com.example.islamiapp.ui.Constants.Constant

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivitySuraDetailsBinding
    lateinit var suraName: String
    var suraPosition: Int? = null
    lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initAppBar()
        getParameters()
        intiRecyclerView()

    }

    private fun initAppBar() {
        setSupportActionBar(viewBinding.toolBarLayout)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }


    private fun intiRecyclerView() {
        getDataFromAsset()
        adapter = VersesAdapter(data)
        viewBinding.suraDetailsContent.rvVerses.adapter = adapter

    }

    private lateinit var data: List<String>
    private fun getDataFromAsset() {
        var newPos = suraPosition?.plus(1)
        var file = assets.open("$newPos.txt").bufferedReader().use { it.readText() }
        data = file.trim().split("\n")

    }

    private fun getParameters() {
        suraName = intent.getStringExtra("suraName").toString()
        suraPosition = intent.getIntExtra(Constant.SURA_POSITION_KEY, 1)
        viewBinding.suraDetailsContent.tvTitle.text = suraName
    }


}