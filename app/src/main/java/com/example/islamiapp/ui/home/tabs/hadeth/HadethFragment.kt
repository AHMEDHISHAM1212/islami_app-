package com.example.islamiapp.ui.home.tabs.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.FragmentHadethBinding
import com.example.islamiapp.ui.Constants.Constant
import com.example.islamiapp.ui.hadethDetails.HadethDetailsActivity
import com.example.islamiapp.ui.model.Hadeth

class HadethFragment : Fragment() {
    lateinit var viewBinding: FragmentHadethBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHadethBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    lateinit var adapter: HadethNameAdapter
    private fun initViews() {
        adapter = HadethNameAdapter(null)
        adapter.onItemClickListener = HadethNameAdapter.OnItemClickListener { position, hadeth ->
            //start act to the hadeth details
            //send the position to and the hadeth name and content
            sendHadethDetails(hadeth)
        }

        viewBinding.rvAhadethName.adapter = adapter
    }

    private fun sendHadethDetails(hadeth: Hadeth) {
        var intent = Intent(activity, HadethDetailsActivity::class.java)
        intent.putExtra(Constant.EXTRA_HADETH, hadeth)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        loadHadethFile()
        bindHadethList()
    }

    private fun bindHadethList() {
        adapter.bindHadethList(hadethList)
    }


    var hadethList = mutableListOf<Hadeth>()
    private fun loadHadethFile() {
        var file =
            requireActivity().assets.open("ahadeth.txt").bufferedReader().use { it.readText() }
        var singleHadethString = file.trim().split("#")
        singleHadethString.forEach { element ->
            val lines = element.trim().split("\n")
            var title = lines[0]
            var content = lines.joinToString("\n")
            var hadeth = Hadeth(title, content)
            hadethList.add(hadeth)

        }
    }

}