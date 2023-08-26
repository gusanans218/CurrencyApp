package com.example.currencyapp.domain.model

data class ExchangeInfoModel(
    val success : Boolean,
    val terms: String,
    val privacy : String,
    val timestamp : Long,
    val source : String,
    val quotes : ExchangeDataModel
)
