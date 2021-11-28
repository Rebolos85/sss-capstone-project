package com.example.sss_capstone_project.data.remote.repository


import androidx.lifecycle.MutableLiveData
import com.example.sss_capstone_project.model.User
import com.example.sss_capstone_project.model.response.UserResponse
import com.example.sss_capstone_project.other.SingleLiveEvent
import com.example.sss_capstone_project.utils.QrCodeState
import com.example.sss_capstone_project.utils.QrCodeStates
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

abstract class CounterRepository {

    val userResponseState = SingleLiveEvent<UserResponse?>()
    abstract fun getCurrentCounterALastPriorityNumber(): Flow<String?>
    abstract fun getCurrentCounterBLastPriorityNumber(): Flow<String?>
    abstract fun getCurrentCounterCLastPriorityNumber(): Flow<String?>
    abstract fun getCurrentCounterDLastPriorityNumber(): Flow<String?>
    abstract fun getCurrentTellerQueueLastPriorityNumber(): Flow<String?>

    abstract fun getCurrentNowServingOfCounterA(): Flow<String?>
    abstract fun getCurrentNowServingOfCounterB(): Flow<String?>

    abstract fun getCurrentNowServingOfCounterC(): Flow<String?>
    abstract fun getCurrentNowServingOfCounterD(): Flow<String?>
    abstract fun getCurrentNowServingOfCounterE(): Flow<String?>

    abstract suspend fun checkCounter1ForPriorityNumber(priorityNumber: String)
    abstract suspend fun checkCounter2orPriorityNumber(priorityNumber: String)
    abstract suspend fun checkCounter3orPriorityNumber(priorityNumber: String)
    abstract suspend fun checkCounter4orPriorityNumber(priorityNumber: String)

}
