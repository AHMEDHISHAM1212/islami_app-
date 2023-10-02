package com.example.islamiapp.ui.home.tabs.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.islamiapp.databinding.FragmentTasbehBinding

class TasbehFragment : Fragment() {
    lateinit var viewBinding: FragmentTasbehBinding
    lateinit var viewModel: SebhaViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SebhaViewModel::class.java]

    }

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

    private var count = 0
    private fun initTasbeh() {
        viewBinding.btnTasbeh
            .setOnClickListener {
                viewModel.increaseCount()
                viewBinding.tvTasbehCount.text = viewModel.count.toString()
            }

//        }
    }

}