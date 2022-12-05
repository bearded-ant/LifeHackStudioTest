package com.tests.lifehackstudiotest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tests.lifehackstudiotest.databinding.FragmentCompaniesBinding
import com.tests.lifehackstudiotest.domain.Companies
import com.tests.lifehackstudiotest.domain.CompaniesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class CompaniesFragment : Fragment() {

    private var _binding: FragmentCompaniesBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCompaniesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val dataResponse = initRetrofit()

        dataResponse.getCompaniesList().enqueue(object : Callback<List<Companies>> {
            override fun onResponse(
                call: Call<List<Companies>>,
                response: Response<List<Companies>>
            ) {
                if (!response.isSuccessful) {
                    Toast.makeText(requireContext(), "${response.code()}", Toast.LENGTH_SHORT)
                        .show()
                    return
                }
                Toast.makeText(requireContext(), "all is ok", Toast.LENGTH_SHORT).show()
                initRecycler(response.body()!!)
            }

            override fun onFailure(call: Call<List<Companies>>, t: Throwable) {
                Toast.makeText(requireContext(), "ERROR", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun initRecycler(companies: List<Companies>) {
        val recyclerView = binding.companiesRecycler
        recyclerView.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.VERTICAL, false
        )
        recyclerView.adapter = CompaniesViewHolderAdapter(companies)
    }
}

private fun initRetrofit(): CompaniesService {

    val moshi: Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
    return retrofit.create(CompaniesService::class.java)
}
