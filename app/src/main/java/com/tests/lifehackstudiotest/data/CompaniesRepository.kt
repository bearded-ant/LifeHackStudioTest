package com.tests.lifehackstudiotest.data

import com.tests.lifehackstudiotest.domain.Companies
import com.tests.lifehackstudiotest.domain.CompanyCard
import com.tests.lifehackstudiotest.network.RetrofitLayer

class CompaniesRepository {
    suspend fun getAllCompanies() : List<Companies>? {
        val requestCompaniesList = RetrofitLayer.apiClient.getAllCompanies()
        if (requestCompaniesList.isSuccessful) {
            return requestCompaniesList.body()!!
        }
        return null
    }

    suspend fun getCompanyById(companyId:String):List<CompanyCard>? {
        val requestCompanyCard = RetrofitLayer.apiClient.getCompanyById(companyId)
        if (requestCompanyCard.isSuccessful) {
            return requestCompanyCard.body()!!
        }
        return null
    }
}