package com.tests.lifehackstudiotest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.tests.lifehackstudiotest.databinding.FragmentCompanyCardBinding
import com.tests.lifehackstudiotest.domain.CompanyCard
import com.tests.lifehackstudiotest.network.RetrofitLayer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompanyCardFragment : Fragment() {

    private var _binding: FragmentCompanyCardBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCompanyCardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (arguments != null) {
            val myArguments = CompanyCardFragmentArgs.fromBundle(requireArguments()).clickPosition
            val dataResponse = RetrofitLayer.newInstance().dataService

            dataResponse.getCompanyCardById(myArguments).enqueue(object :
                Callback<List<CompanyCard>> {
                override fun onResponse(call: Call<List<CompanyCard>>, response: Response<List<CompanyCard>>) {
                    binding.fragmentCompanyName.text = response.body()!![0].name
                    binding.fragmentCompanyPhone.text = response.body()!![0].phone
                    binding.fragmentCompanySite.text = response.body()!![0].www
                }

                override fun onFailure(call: Call<List<CompanyCard>>, t: Throwable) {
                    Toast.makeText(requireContext(), "ERROR", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
