package com.tests.lifehackstudiotest.domain


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CompaniesService {

    @GET("test.php")
    fun getCompaniesList(): Call<List<Companies>>

    @GET("test.php")
    fun getCompanyCardById(@Query("id") id: String): Call<List<CompanyCard>>
}