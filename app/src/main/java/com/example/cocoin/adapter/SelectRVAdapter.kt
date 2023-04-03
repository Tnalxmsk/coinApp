package com.example.cocoin.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cocoin.R
import com.example.cocoin.dataModel.CurrentPriceResult
import com.example.cocoin.databinding.ItemIntroCoinBinding

class SelectRVAdapter(val context: Context, private val coinPriceList: List<CurrentPriceResult>) : RecyclerView.Adapter<SelectRVAdapter.SelectViewHolder>() {
    inner class SelectViewHolder(private val binding: ItemIntroCoinBinding) : RecyclerView.ViewHolder(binding.root) {
        val selectedCoinList = ArrayList<String>()
        fun bind(currentPriceResult: CurrentPriceResult) {
            val fluctate_24H = coinPriceList[position].coinInfo.fluctate_24H
            with(binding) {
                itemCoinNameTv.text = coinPriceList[position].coinName

                val currentCoin = coinPriceList[position].coinName
                if (selectedCoinList.contains(currentCoin)) {
                    itemLikeBt.setImageResource(R.drawable.like_red)
                }
                else {
                    itemLikeBt.setImageResource(R.drawable.like_grey)
                }
                itemLikeBt.setOnClickListener {
                    // 포함하면
                    if (selectedCoinList.contains(currentCoin)) {
                        selectedCoinList.remove(currentCoin)
                        itemLikeBt.setImageResource(R.drawable.like_grey)
                    }
                    // 포함하지 않으면
                    else {
                        selectedCoinList.add(currentCoin)
                        itemLikeBt.setImageResource(R.drawable.like_red)
                    }
                }

                // 상승 하락 text
                if (fluctate_24H.contains("-")) {
                    itemCoinPriceUpDown.text = "하락입니다."
                    itemCoinPriceUpDown.setTextColor(Color.parseColor("#114fed"))
                }
                else {
                    itemCoinPriceUpDown.text = "상습입니다."
                    itemCoinPriceUpDown.setTextColor(Color.parseColor("#ed2e11"))
                }
            }

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