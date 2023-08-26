package com.example.currencyapp.data

import com.google.gson.annotations.SerializedName

data class ExchangeData(
    @SerializedName("USDKRW")
    val usdkrw: Float,
    @SerializedName("USDJPY")
    val usdjpy: Float,
    @SerializedName("USDPHP")
    val usdphp: Float
)