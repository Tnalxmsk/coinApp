package com.example.cocoin.view.select

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocoin.adapter.SelectRVAdapter
import com.example.cocoin.databinding.ActivityIntroCoinSelectBinding
import timber.log.Timber

class IntroCoinSelectActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroCoinSelectBinding
    private val viewModel: SelectViewModel by viewModels()
    private lateinit var selectRVAdapter: SelectRVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroCoinSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            viewModel.getCurrentCoinList()
            viewModel.currentPriceResult.observe(this@IntroCoinSelectActivity) {
                selectRVAdapter = SelectRVAdapter(this@IntroCoinSelectActivity, it)

                selectCoinRv.adapter = selectRVAdapter
                selectCoinRv.layoutManager = LinearLayoutManager(this@IntroCoinSelectActivity)

                Timber.d(it.toString())
            }
        }
    }
}