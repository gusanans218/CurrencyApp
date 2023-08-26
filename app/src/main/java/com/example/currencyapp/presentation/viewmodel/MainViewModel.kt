package com.example.currencyapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyapp.domain.Status
import com.example.currencyapp.domain.model.ExchangeInfoModel
import com.example.currencyapp.domain.usecase.GetExchangeInfoUseCase
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel(
    private val useCase: GetExchangeInfoUseCase
) : ViewModel() {
    private val _errorEvent = MutableLiveData<Unit>()
    val errorEvent: LiveData<Unit>? by :: _errorEvent

    private val _exchangeInfo = MutableLiveData<ExchangeInfoModel>()
    val exchangeInfo: LiveData<ExchangeInfoModel> by :: _exchangeInfo

    private val _exchangeTime = MutableLiveData<String>()
    val exchangeTime: LiveData<String> by :: _exchangeTime

    private val _exchangeNation = MutableLiveData<String>("한국(KRW)")//초기값
    val exchangeNation: LiveData<String>
        get() = _exchangeNation

    val exchangeMoney = MutableLiveData<String>("")

    fun changeNation(nation: String) {
        _exchangeNation.value = nation
    }

    fun getExchangeInfoModel() {
        viewModelScope.launch {
            val result = useCase()
            when (result.status) {
                Status.SUCCESS -> {
                    if (result.data != null) {
                        _exchangeInfo.value = result.data!!
                        val date = Date(result.data!!.timestamp * 1000)
                        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm")
                        _exchangeTime.value = formatter.format(date)
                    } else {
                        _errorEvent.value = null
                    }
                }
                else -> {
                    _errorEvent.value = null
                }
            }
        }
    }
}