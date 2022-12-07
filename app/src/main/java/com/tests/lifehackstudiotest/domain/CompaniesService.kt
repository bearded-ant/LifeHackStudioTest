package com.tests.lifehackstudiotest.domain


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CompaniesService {

    @GET("test.php")
    suspend fun getCompaniesList(): Response<List<Companies>>

    @GET("test.php")
    suspend fun getCompanyCardById(@Query("id") id: String): Response<List<CompanyCard>>
}