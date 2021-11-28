package com.example.sss_capstone_project.utils

import com.example.sss_capstone_project.model.response.UserResponse

sealed class QrCodeStates {
    object IDLE : QrCodeStates()
     class Success(val userResponse: UserResponse) : QrCodeStates()
}