package com.example.cocoin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cocoin.dataModel.CurrentPriceResult
import com.example.cocoin.databinding.ItemIntroCoinBinding

class SelectRVAdapter(val context: Context, private val coinPriceList: List<CurrentPriceResult>) : RecyclerView.Adapter<SelectRVAdapter.SelectViewHolder>() {
    inner class SelectViewHolder(private val binding: ItemIntroCoinBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currentPriceResult: CurrentPriceResult) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectViewHolder {
        val binding = ItemIntroCoinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectViewHolder, position: Int) {
        holder.bind(coinPriceList[position])
    }

    override fun getItemCount(): Int = coinPriceList.size
}