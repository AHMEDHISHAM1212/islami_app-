package com.example.islamiapp.ui.hadethDetails

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapp.databinding.ActivityHadethDetailsBinding
import com.example.islamiapp.ui.Constants.Constant
import com.example.islamiapp.ui.model.Hadeth

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHadethDetailsBinding

    override fun onCreate(
        savedInstanceState:
        Bundle?
    ) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initParams()
        bindHadeth()
        intiViews()

    }

    private fun bindHadeth() {
        viewBinding.suraDetailsContent.tvTitleHadeth.text = hadeth?.title
        viewBinding.suraDetailsContent.tvHadethContent.text = hadeth?.content
    }

    private fun intiViews() {
        setSupportActionBar(viewBinding.toolBarLayout)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private var hadeth: Hadeth? = null
    private fun initParams() {
        hadeth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constant.EXTRA_HADETH, Hadeth::class.java)!!
        } else {
            intent.getParcelableExtra(Constant.EXTRA_HADETH) as Hadeth?
        }

    }
}