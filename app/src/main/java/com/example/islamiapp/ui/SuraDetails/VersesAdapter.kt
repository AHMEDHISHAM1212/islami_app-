package com.example.islamiapp.ui.SuraDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemVersesBinding

class VersesAdapter(var versesList: List<String>) :
    RecyclerView.Adapter<VersesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var viewBinding = ItemVersesBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.tvVerses.text = versesList?.get(position)

    }

    override fun getItemCount(): Int {
        return versesList?.size ?: 0
    }


    class ViewHolder(var viewBinding: ItemVersesBinding) : RecyclerView.ViewHolder(viewBinding.root)


}