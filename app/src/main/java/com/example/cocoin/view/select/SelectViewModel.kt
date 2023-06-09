package com.example.cocoin.view.select

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocoin.dataModel.CurrentPrice
import com.example.cocoin.dataModel.CurrentPriceResult
import com.example.cocoin.dataStore.MyDataStore
import com.example.cocoin.repository.NetWorkRepository
import com.google.gson.Gson
import kotlinx.coroutines.launch
import timber.log.Timber

class SelectViewModel : ViewModel() {

    private val netWorkRepository = NetWorkRepository()

    private lateinit var currentPriceResultList: ArrayList<CurrentPriceResult>

    private val _currentPriceResult = MutableLiveData<List<CurrentPriceResult>>()
    val currentPriceResult: LiveData<List<CurrentPriceResult>>
        get() = _currentPriceResult
    fun getCurrentCoinList() = viewModelScope.launch {
        val result = netWorkRepository.getCurrentCoinList()

        currentPriceResultList = ArrayList()

        for (coin in result.data) {
            try {
                val gson = Gson()
                val gsonToJson = gson.toJson(result.data[coin.key])
                val gsonFromJson = gson.fromJson(gsonToJson, CurrentPrice::class.java)

                val currentPriceResult = CurrentPriceResult(coin.key, gsonFromJson)

                currentPriceResultList.add(currentPriceResult)
            }catch (e: java.lang.Exception) {
                Timber.d(e.toString())
            }
        }
        _currentPriceResult.value = currentPriceResultList
    }
    fun setUpFirstFlag() = viewModelScope.launch {
        MyDataStore().setupFirstData()
    }
}