package com.tests.lifehackstudiotest.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tests.lifehackstudiotest.domain.CompaniesService
import com.tests.lifehackstudiotest.ui.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitLayer {
//        private val moshi: Moshi = Moshi.Builder()
//        .addLast(KotlinJsonAdapterFactory())
//                .build()
    var gson: Gson = GsonBuilder()
        .setLenient()
        .create()
//
//    val gson = Gson().newBuilder()
//        .setLenient()
//        .disableHtmlEscaping()
//        .create()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
//        .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val dataService: CompaniesService by lazy { retrofit.create(CompaniesService::class.java) }

    val apiClient = ApiClient(dataService)
}