package com.tests.lifehackstudiotest.domain


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CompaniesService {

    @GET("test.php")
    fun getCompaniesList(): Call<List<Companies>>

    @GET("test.php?id={id}")
    fun getCompanyCardById(@Path("id") id: String): CompanyCard
}