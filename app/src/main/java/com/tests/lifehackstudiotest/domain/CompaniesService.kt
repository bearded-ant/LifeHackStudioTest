package com.tests.lifehackstudiotest.domain


import retrofit2.http.GET
import retrofit2.http.Path

interface CompaniesService {

    @GET("test.php")
    fun getCompaniesList(): List<Companies>

    @GET("id={id}")
    fun getCompanyCardById(@Path("id") id: String): CompanyCard
}