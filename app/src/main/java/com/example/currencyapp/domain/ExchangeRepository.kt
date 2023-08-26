package com.example.currencyapp.domain

import com.example.currencyapp.domain.model.ExchangeInfoModel

interface ExchangeRepository {
    suspend fun getExchangeInfo(): ExchangeInfoModel?
}