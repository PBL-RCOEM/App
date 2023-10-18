package com.example.smart_appointment.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIService {
    private const val BASE_URL = "base_url"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}