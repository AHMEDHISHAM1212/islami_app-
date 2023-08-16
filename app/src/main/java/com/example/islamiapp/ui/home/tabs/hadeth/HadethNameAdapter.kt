package com.example.islamiapp.ui.home.tabs.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemHadethBinding
import com.example.islamiapp.ui.model.Hadeth

class HadethNameAdapter(private var hadeth: List<Hadeth>? = null) :
    RecyclerView.Adapter<HadethNameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemHadethBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // !! this operator means -> not be equal null
        holder.viewBinding.tvHadethName.text = hadeth!![position].title

        if (onItemClickListener != null) {
            holder.viewBinding.root
                .setOnClickListener {
                    onItemClickListener?.onItemClick(position, hadeth!![position])
                }
        }

    }


    override fun getItemCount(): Int {
        return hadeth?.size ?: 0
    }

    fun bindHadethList(newList: List<Hadeth>) {
        hadeth = newList
        notifyDataSetChanged()
    }

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, hadeth: Hadeth)
    }

    class ViewHolder(val viewBinding: ItemHadethBinding) : RecyclerView.ViewHolder(viewBinding.root)
}