package com.tests.lifehackstudiotest.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tests.lifehackstudiotest.data.CompaniesRepository
import kotlinx.coroutines.launch

class CompaniesViewModel : ViewModel() {
    private val repository = CompaniesRepository()
    private val _companiesListLiveData = MutableLiveData<List<Companies>>()
    val companiesListLiveData: LiveData<List<Companies>> = _companiesListLiveData

    fun companiesListRefresh() {
        viewModelScope.launch {
            val response = repository.getAllCompanies()
            _companiesListLiveData.postValue(response!!)
        }
    }

    private val _companyCardLiveDat = MutableLiveData<List<CompanyCard>>()
    val companyCardLiveData: LiveData<List<CompanyCard>> = _companyCardLiveDat

    fun companyCardRefresh(companyId:String) {
        viewModelScope.launch {
            val response = repository.getCompanyById(companyId)
            _companyCardLiveDat.postValue(response!!)
        }
    }
}