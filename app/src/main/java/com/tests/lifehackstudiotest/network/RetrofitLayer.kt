package com.tests.lifehackstudiotest.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tests.lifehackstudiotest.domain.CompaniesService
import com.tests.lifehackstudiotest.ui.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitLayer {
    companion object {
        fun newInstance(): RetrofitLayer = RetrofitLayer()
    }

    private val moshi: Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val dataService = retrofit.create(CompaniesService::class.java)

}