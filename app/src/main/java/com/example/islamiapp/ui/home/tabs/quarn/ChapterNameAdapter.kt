package com.example.islamiapp.ui.home.tabs.quarn

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemChapterNameBinding
import com.example.islamiapp.ui.model.Sura

class ChapterNameAdapter(var sura: List<Sura>) :
    RecyclerView.Adapter<ChapterNameAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemChapterNameBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.tvSuraName.text = sura[position].suraName
        holder.viewBinding.suraAyatCount.text = sura[position].ayatSuraCount.toString()
        if (onItemClickListener != null) {
            holder.viewBinding.root
                .setOnClickListener {
                    onItemClickListener?.onItemClick(position, sura[position])
                }
        }

    }

    override fun getItemCount(): Int {
        return sura.size
    }

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, sura: Sura)
    }

    class ViewHolder(val viewBinding: ItemChapterNameBinding) :
        RecyclerView.ViewHolder(viewBinding.root)
}