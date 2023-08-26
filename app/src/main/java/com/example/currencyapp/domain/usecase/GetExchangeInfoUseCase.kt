package com.example.currencyapp.domain.usecase

import com.example.currencyapp.domain.ExchangeRepository
import com.example.currencyapp.domain.Resource
import com.example.currencyapp.domain.model.ExchangeInfoModel

class GetExchangeInfoUseCase(val repository: ExchangeRepository) :UseCase {
    suspend operator fun invoke(): Resource<ExchangeInfoModel?>{
        return try {
            val exchangeInfoModel = repository.getExchangeInfo()
            Resource.success(exchangeInfoModel)
        }catch (e: Exception) {
            Resource.error(e.message.toString())
        }
    }
}