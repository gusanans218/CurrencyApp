package com.example.currencyapp.data

import com.example.currencyapp.domain.ExchangeRepository
import com.example.currencyapp.domain.model.ExchangeInfoModel

class ExchangeRepositoryImpl(private val api : API): ExchangeRepository {
    override suspend fun getExchangeInfo(): ExchangeInfoModel? {
        return ExchangeMapper.changeExchangeInfo(api.getExchangeInfo().body())
    }
}