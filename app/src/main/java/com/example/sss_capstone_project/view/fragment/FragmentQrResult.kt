package com.example.sss_capstone_project.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.sss_capstone_project.R
import com.example.sss_capstone_project.databinding.FragmentResultQrCodeBinding
import com.example.sss_capstone_project.utils.safeNavigate
import com.example.sss_capstone_project.viewmodel.ScanViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentQrResult : Fragment() {
    private var _binding: FragmentResultQrCodeBinding? = null
    private val binding get() = _binding!!
    private val _scanViewModel: ScanViewModel by viewModels()
    private val fragmentQrResultArgs: FragmentQrResultArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        // Inflate the layout for this fragment
        _binding = FragmentResultQrCodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentQrResultArgs.userQrCodeResult.apply {
            binding.apply {
                val fullName = "${name.first}  ${name.middle}  ${name.last} "
                priorityText.text = priorityNumber
                fullnameText.text = fullName
                dateText.text = date
                addressText.text = municipality
                barangayText.text = barangay
                residenceText.text = residence

            }
        }
//        Log.d("TEST", "information ${fragmentQrResultArgs.qrcodeformat} and ${fragmentQrResultArgs.qrcodeinfo}")
//        binding.apply {
//            qrCodeFormatResult.text = fragmentQrResultArgs.qrcodeformat
//            codeInfo.text = fragmentQrResultArgs.qrcodeinfo
//        }

        binding.okayButton.setOnClickListener {
            Log.d("TEST", "CLICK MAN OKAY BUTTON")
            findNavController().safeNavigate(FragmentQrResultDirections.actionFragmentQrResultToScanQrFragment())
            _scanViewModel._readQrState.value = ""

        }


    }


}