package com.example.sss_capstone_project.view.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sss_capstone_project.R
import com.example.sss_capstone_project.databinding.FragmentChooserScreenBinding
import com.example.sss_capstone_project.utils.safeNavigate

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentChooseScreen : Fragment() {

    private var _binding: FragmentChooserScreenBinding? = null
//    private val _mainViewModel: MainViewModel by viewModels()

    // para sure nga dili null ang binding
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        requireContext().setTheme(R.style.AppTheme)
        // Inflate the layout for this fragment
        _binding = FragmentChooserScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            dashboardPage.setOnClickListener {
                showDashboardFragment()
            }
            scanPage.setOnClickListener {
                showScanFragment()
            }
        }


    }


    private fun showDashboardFragment() {
        findNavController().safeNavigate(FragmentChooseScreenDirections.actionFragmentFirstScreenToDashboardFragment())
    }

    private fun showScanFragment() {
        findNavController().safeNavigate(FragmentChooseScreenDirections.actionFragmentFirstScreenToScanQrFragment())
    }

    private fun showAboutUsFragment() {
        findNavController().safeNavigate(FragmentChooseScreenDirections.actionFragmentFirstScreenToFragmentAboutUs())
    }


}