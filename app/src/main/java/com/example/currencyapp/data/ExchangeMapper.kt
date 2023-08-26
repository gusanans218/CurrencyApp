package com.example.currencyapp.data

import com.example.currencyapp.domain.model.ExchangeDataModel
import com.example.currencyapp.domain.model.ExchangeInfoModel

object ExchangeMapper {
    fun changeExchangeInfo(exchangeInfo: ExchangeInfo?):ExchangeInfoModel? {
        if(exchangeInfo == null){
            return null
        }
        return ExchangeInfoModel(
            success = exchangeInfo.success,
            terms = exchangeInfo.terms,
            privacy = exchangeInfo.privacy,
            timestamp = exchangeInfo.timestamp,
            source = exchangeInfo.source,
            quotes = changeExchangeData(exchangeInfo.quotes)
        )
    }

    fun changeExchangeData(exchangeData: ExchangeData): ExchangeDataModel {
        return ExchangeDataModel(
            usaToKor = exchangeData.usdkrw,
            usaToJpn = exchangeData.usdjpy,
            usaToPhp = exchangeData.usdphp
        )
    }
}