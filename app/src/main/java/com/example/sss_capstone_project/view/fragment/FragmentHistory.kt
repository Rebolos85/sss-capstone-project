package com.example.sss_capstone_project.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sss_capstone_project.R
import com.example.sss_capstone_project.databinding.FragmentAboutUsBinding
import com.example.sss_capstone_project.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHistory: Fragment() {

    private var _binding: FragmentHistoryBinding? = null
//    private val _mainViewModel: MainViewModel by viewModels()

    // para sure nga dili null ang binding
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        requireContext().setTheme(R.style.AppTheme)
        // Inflate the layout for this fragment
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}