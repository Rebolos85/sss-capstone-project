package com.example.sss_capstone_project.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.sss_capstone_project.databinding.FragmentScanQrCodeBinding
import com.example.sss_capstone_project.model.response.UserResponse
import com.example.sss_capstone_project.other.Constants
import com.example.sss_capstone_project.service.ScanDialogService
import com.example.sss_capstone_project.utils.QrCodeState
import com.example.sss_capstone_project.utils.multiplePermission
import com.example.sss_capstone_project.utils.safeNavigate
import com.example.sss_capstone_project.utils.toast
import com.example.sss_capstone_project.viewmodel.ScanViewModel
import com.google.zxing.BarcodeFormat
import com.google.zxing.DecodeHintType
import com.journeyapps.barcodescanner.DefaultDecoderFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@AndroidEntryPoint
class ScanQrFragment : BaseFragment() {

    private var _binding: FragmentScanQrCodeBinding? = null
//    private val _mainViewModel: MainViewModel by viewModels()

    private val _scanViewModel: ScanViewModel by viewModels()
    lateinit var sweetAlertDialog: SweetAlertDialog
    lateinit var dialog: SweetAlertDialog

    @Inject
    lateinit var scanDialogService: ScanDialogService

    // para sure nga dili null ang binding
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentScanQrCodeBinding.inflate(inflater, container, false)
        Log.d("TEST", "Called ang scan qr fragmnet")
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestCameraPermission()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TEST", "SCAN QR CODE")
        binding.scanner.apply {
            decoderFactory = DefaultDecoderFactory(
                listOf(BarcodeFormat.QR_CODE), mapOf(
                    DecodeHintType.CHARACTER_SET to Charsets.UTF_8.name()
                ), Charsets.UTF_8.name(), 2
            )


            decodeSingle {

                _scanViewModel._readQrState.value = it.text
            }

            _scanViewModel._readQrState.observe(viewLifecycleOwner) {
                Log.d("TEST", "value sa qr coee bayy $it")
                _scanViewModel.validatePriorityNumber(it)
            }

        }


        _scanViewModel.dataUserResponse.observe(viewLifecycleOwner) {
            Log.d("Test", " User response value $it")
            _scanViewModel.validateQrCode(userResponse = it)

        }



        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            _scanViewModel.qrCodeState.collect {
                when (it) {

                    is QrCodeState.SucessState -> {
                        navigateToFragmentResult(it.userResponse)
                    }
                }


            }
        }

//        requireActivity().onBackPressedDispatcher.addCallback(callback)

    }


    override fun onResume() {
        super.onResume()
        binding.scanner.resume()
    }

    override fun onPause() {
        super.onPause()
        binding.scanner.pause()
    }


    private fun navigateToFragmentResult(userResponse: UserResponse) {
        findNavController().safeNavigate(
            ScanQrFragmentDirections.actionScanQrFragmentToFragmentQrResult(
                userQrCodeResult = userResponse
            )
        )
    }


    private fun requestCameraPermission() {
        val permReqLauncher = multiplePermission { eachPermission ->
            val granted = eachPermission.entries.all {
                it.value
            }
            if (!granted) {
                requireContext().toast("You need to accept the permission in order you can continue")
            }

        }
        launchCameraPermission(permReqLauncher)
    }

    private fun launchCameraPermission(permReqLauncher: ActivityResultLauncher<Array<String>>) {
        permReqLauncher.launch(Constants.appRequestPermission)

    }
}
