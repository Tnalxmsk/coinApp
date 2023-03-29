package com.example.cocoin.repository

import com.example.cocoin.network.Api
import com.example.cocoin.network.RetrofitInstance

class NetWorkRepository {

    private val client = RetrofitInstance.getInstance().create(Api::class.java)

    suspend fun getCurrentCoinList() = client.getCurrentCoinList()
}