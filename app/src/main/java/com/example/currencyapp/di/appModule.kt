package com.example.currencyapp.di

import com.example.currencyapp.BuildConfig
import com.example.currencyapp.data.API
import com.example.currencyapp.data.ExchangeRepositoryImpl
import com.example.currencyapp.domain.ExchangeRepository
import com.example.currencyapp.domain.usecase.GetExchangeInfoUseCase
import com.example.currencyapp.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        GsonConverterFactory.create()as Converter.Factory
    }

    single {
        Retrofit.Builder()
            .addConverterFactory(get())
            .baseUrl("http://api.currencylayer.com/")
            .build()
            .create(API::class.java)
    }
    single {
        val repository: ExchangeRepository = ExchangeRepositoryImpl(get())
        repository
    }
    single {
        GetExchangeInfoUseCase(get())
    }
    viewModel { MainViewModel(get()) }
}