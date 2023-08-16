package com.example.islamiapp.ui.home.tabs.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.FragmentTasbehBinding

class TasbehFragment : Fragment() {
    lateinit var viewBinding: FragmentTasbehBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentTasbehBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTasbeh()
    }

    private fun initTasbeh() {
        var tasbeh_count = 0
        var rotateAngel = 0f
        viewBinding.ivSebhaHeader.rotation = (rotateAngel)
        viewBinding.tvTasbehCount.text = ("$tasbeh_count")
        viewBinding.root.setOnClickListener {
            it
            tasbeh_count++
            rotateAngel += 6
            viewBinding.ivSebhaHeader.rotation = (rotateAngel)
            viewBinding.tvTasbehCount.setText("$tasbeh_count")

        }
    }

}