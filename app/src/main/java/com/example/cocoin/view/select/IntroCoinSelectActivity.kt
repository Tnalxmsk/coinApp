package com.example.cocoin.view.select

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocoin.adapter.SelectRVAdapter
import com.example.cocoin.databinding.ActivityIntroCoinSelectBinding
import com.example.cocoin.view.MainActivity
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
            viewModel.setUpFirstFlag()

            selectCoinBt.setOnClickListener {
                val intent = Intent(this@IntroCoinSelectActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}