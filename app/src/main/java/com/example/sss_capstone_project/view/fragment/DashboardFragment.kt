package com.example.sss_capstone_project.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sss_capstone_project.R
import com.example.sss_capstone_project.databinding.FragmentDashboardBinding
import com.example.sss_capstone_project.viewmodel.ScanViewModel
import com.google.android.gms.dynamic.IFragmentWrapper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    //    private val _mainViewModel: MainViewModel by viewModels()
    private val scanViewModel: ScanViewModel by viewModels()

    // para sure nga dili null ang binding
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        // Inflate the layout for this fragment
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            scanViewModel.getCurrentPriorityNumber.observe(viewLifecycleOwner) { recentIssuedPriorityNumber ->
                recentIssuedPriorityNumber?.let {
                    priorityNumber.text = it
                }
            }
            scanViewModel.currentPriorityNumberOfCounterB.observe(viewLifecycleOwner) { recentIssuedCounterBPriorityNumber ->
                recentIssuedCounterBPriorityNumber?.let {
                    counterBPriorityNumber.text = it
                }
            }

            scanViewModel.currentPriorityNumberOfCounterC.observe(viewLifecycleOwner) { recentIssuedCounterCPriorityNumber ->
                recentIssuedCounterCPriorityNumber?.let {
                    counterCPriorityNumber.text = it
                }
            }
            scanViewModel.currentPriorityNumberOfCounterD.observe(viewLifecycleOwner) { recentIssuedCounterCPriorityNumber ->
                recentIssuedCounterCPriorityNumber?.let {
                    counterDPriorityNumber.text = it
                }
            }
            scanViewModel.currentPriorityNumberOfTeller.observe(viewLifecycleOwner) { recentIssuedCounterCPriorityNumber ->
                recentIssuedCounterCPriorityNumber?.let {
                    counterEPriorityNumber.text = it
                }
            }
            scanViewModel.currentServingOfCounterA.observe(viewLifecycleOwner) {
                if (it.isNullOrEmpty()) {
                    currentRecentCounterA.text = "A-000"
                }else {
                    currentRecentCounterA.text = "A-00$it"
                }

            }
            scanViewModel.currentServingOfCounterB.observe(viewLifecycleOwner) {
                if (it.isNullOrEmpty()) {
                    currentRecentCounterB.text = "B-000"
                }else {
                    currentRecentCounterB.text = "B-00$it"
                }

            }
            scanViewModel.currentServingOfCounterC.observe(viewLifecycleOwner) {
                if (it.isNullOrEmpty()) {
                    Log.d("TEST", "Walay value ")
                    currentRecentCounterC.text = "C-000"
                } else {
                    Log.d("TEST", "Naa  value ")
                    currentRecentCounterC.text = "C-00$it"
                }
//                val test = currentRecentCounterC.text
//                Log.d("TEST", " current value  of C $test")
            }
            scanViewModel.currentServingOfCounterD.observe(viewLifecycleOwner) {
                if (it.isNullOrEmpty()) {
                    Log.d("TEST", "Walay value ")
                    currentRecentCounterD.text = "D-000"
                } else {
                    Log.d("TEST", "Naa  value ")
                    currentRecentCounterD.text = "D-00$it"
                }
            }
                scanViewModel.currentServingOfCounterE.observe(viewLifecycleOwner) {
                    if (it.isNullOrEmpty()) {
                        Log.d("TEST", "Walay value ")
                        currentRecentCounterE.text = "E-000"
                    } else {
                        Log.d("TEST", "Naa  value ")
                        currentRecentCounterE.text = "E-00$it"
                    }

                }
            }
        }
    }
