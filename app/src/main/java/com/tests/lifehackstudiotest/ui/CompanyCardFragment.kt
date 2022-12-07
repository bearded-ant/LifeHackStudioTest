package com.tests.lifehackstudiotest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tests.lifehackstudiotest.databinding.FragmentCompanyCardBinding
import com.tests.lifehackstudiotest.domain.CompaniesViewModel

class CompanyCardFragment : Fragment() {

    private var _binding: FragmentCompanyCardBinding? = null
    private val binding
        get() = _binding!!

    val companiesViewModel: CompaniesViewModel by lazy {
        ViewModelProvider(this)[CompaniesViewModel::class.java]
    }

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
            companiesViewModel.companyCardRefresh(myArguments)
            companiesViewModel.companyCardLiveData.observe(requireActivity()) { response ->

                val dataResponse = response[0]

                binding.fragmentCompanyName.text = dataResponse.name
                binding.fragmentCompanyPhone.text = dataResponse.phone
                binding.fragmentCompanySite.text = dataResponse.www
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
