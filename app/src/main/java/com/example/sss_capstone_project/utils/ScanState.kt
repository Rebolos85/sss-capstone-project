package com.example.sss_capstone_project.utils

import com.example.sss_capstone_project.model.response.UserResponse

sealed class ScanState {
    object Idle : ScanState()
    object Loading : ScanState()
    object SuccessAuth : ScanState()
    object SuccessCredentials : ScanState()
    data class Success(val user: UserResponse?) : ScanState()
    data class Error(val message: String) : ScanState()
}
