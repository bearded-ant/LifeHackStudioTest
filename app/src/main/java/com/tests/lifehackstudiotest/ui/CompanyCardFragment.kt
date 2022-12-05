package com.tests.lifehackstudiotest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tests.lifehackstudiotest.databinding.FragmentCompanyCardBinding

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

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
