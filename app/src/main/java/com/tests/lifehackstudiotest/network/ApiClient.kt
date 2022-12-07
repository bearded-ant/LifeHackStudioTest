package com.tests.lifehackstudiotest.network

import com.tests.lifehackstudiotest.domain.Companies
import com.tests.lifehackstudiotest.domain.CompaniesService
import com.tests.lifehackstudiotest.domain.CompanyCard
import retrofit2.Response

class ApiClient(
    private val companiesService: CompaniesService
) {
    suspend fun getAllCompanies(): Response<List<Companies>> = companiesService.getCompaniesList()
    suspend fun getCompanyById(companyId: String): Response<List<CompanyCard>> =
        companiesService.getCompanyCardById(companyId)
}