package com.example.sss_capstone_project.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.sss_capstone_project.data.remote.repository.CounterRepository
import com.example.sss_capstone_project.model.QrCodeInformation
import com.example.sss_capstone_project.model.response.UserResponse
import com.example.sss_capstone_project.other.SingleLiveEvent
import com.example.sss_capstone_project.utils.QrCodeState
import com.example.sss_capstone_project.utils.QrCodeStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScanViewModel @Inject constructor(private val userRepository: CounterRepository) :
    ViewModel() {

    val _readQrState = SingleLiveEvent<String>()
//    val readState: Flow<String> get() = _readQrState

    val getCurrentPriorityNumber =
        userRepository.getCurrentCounterALastPriorityNumber().asLiveData()
    val currentPriorityNumberOfCounterB =
        userRepository.getCurrentCounterBLastPriorityNumber().asLiveData()
    val currentPriorityNumberOfCounterC =
        userRepository.getCurrentCounterCLastPriorityNumber().asLiveData()
    val currentPriorityNumberOfCounterD =
        userRepository.getCurrentCounterDLastPriorityNumber().asLiveData()
    val currentPriorityNumberOfTeller =
        userRepository.getCurrentTellerQueueLastPriorityNumber().asLiveData()
    val dataUserResponse = userRepository.userResponseState
    val currentServingOfCounterA = userRepository.getCurrentNowServingOfCounterA().asLiveData()
    val currentServingOfCounterB = userRepository.getCurrentNowServingOfCounterB().asLiveData()
    val currentServingOfCounterC = userRepository.getCurrentNowServingOfCounterC().asLiveData()
    val currentServingOfCounterD = userRepository.getCurrentNowServingOfCounterD().asLiveData()
    val currentServingOfCounterE = userRepository.getCurrentNowServingOfCounterE().asLiveData()
    private val _qrCodeState = MutableStateFlow<QrCodeState>(QrCodeState.IDLE)
    val qrCodeState: Flow<QrCodeState> get() = _qrCodeState

    private val _stateFlow = MutableStateFlow<QrCodeStates>(QrCodeStates.IDLE)
    val invalidQrCode = SingleLiveEvent<String?>()

    val stateQrCode: Flow<QrCodeStates> get() = _stateFlow


    fun validatePriorityNumber(priorityNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.checkCounter1ForPriorityNumber(priorityNumber = priorityNumber)
            userRepository.checkCounter2orPriorityNumber(priorityNumber = priorityNumber)
            userRepository.checkCounter3orPriorityNumber(priorityNumber = priorityNumber)
            userRepository.checkCounter4orPriorityNumber(priorityNumber = priorityNumber)
        }

    }


    fun validateQrCode(userResponse: UserResponse?) {
        viewModelScope.launch {
            if (userResponse != null) {
                _qrCodeState.emit(QrCodeState.SucessState(userResponse))
            } else {
                invalidQrCode.postValue("Your qr code is invalid")
            }
        }
    }
}