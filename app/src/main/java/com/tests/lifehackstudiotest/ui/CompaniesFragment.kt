package com.tests.lifehackstudiotest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tests.lifehackstudiotest.databinding.FragmentCompaniesBinding
import com.tests.lifehackstudiotest.domain.Companies
import com.tests.lifehackstudiotest.domain.CompaniesViewModel


class CompaniesFragment : Fragment(), OnCompanyCardClick {

    private var _binding: FragmentCompaniesBinding? = null
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
        _binding = FragmentCompaniesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        companiesViewModel.companiesListRefresh()
        companiesViewModel.companiesListLiveData.observe(requireActivity()) { response ->
            initRecycler(response)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun companyCardClicked(companyId: String) {
        Toast.makeText(requireContext(), "$companyId", Toast.LENGTH_SHORT).show()
        val action =
            CompaniesFragmentDirections.actionCompaniesFragmentToCompanyCardFragment(companyId)
        findNavController().navigate(action)
    }

    private fun initRecycler(companies: List<Companies>) {
        val recyclerView = binding.companiesRecycler
        recyclerView.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.VERTICAL, false
        )
        recyclerView.adapter = CompaniesViewHolderAdapter(companies, this)
        //            adapter.notifyDataSetChanged()
    }
}