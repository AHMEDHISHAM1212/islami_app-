package com.example.islamiapp.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islamiapp.R
import com.example.islamiapp.databinding.ActivityHomeBinding
import com.example.islamiapp.ui.home.tabs.hadeth.HadethFragment
import com.example.islamiapp.ui.home.tabs.quarn.QuranFragment
import com.example.islamiapp.ui.home.tabs.radio.RadioFragment
import com.example.islamiapp.ui.home.tabs.tasbeh.TasbehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setOnNavClick()

    }

    private fun setOnNavClick() {
        viewBinding.homeContent.navHome
            .setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.nav_quran -> {
                        openNewTab(QuranFragment())
                    }

                    R.id.nav_hadeth -> {
                        openNewTab(HadethFragment())
                    }

                    R.id.nav_sebha -> {
                        openNewTab(TasbehFragment())
                    }

                    R.id.nav_radio -> {
                        openNewTab(RadioFragment())
                    }
                }
                true
            }
        // to set the quran fragment is a default selection fragment
        // and the arrangement is must
        viewBinding.homeContent.navHome.selectedItemId = R.id.nav_quran
    }

    private fun openNewTab(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragments_container, fragment)
            .commit()

    }
}