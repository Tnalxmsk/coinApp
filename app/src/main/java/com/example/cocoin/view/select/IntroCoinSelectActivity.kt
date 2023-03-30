package com.example.cocoin.view.select

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.cocoin.databinding.ActivityIntroCoinSelectBinding
import timber.log.Timber

class IntroCoinSelectActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroCoinSelectBinding
    private val viewModel: SelectViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroCoinSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getCurrentCoinList()
        viewModel.currentPriceResult.observe(this) {
            Timber.d(it.toString())
        }
    }
}