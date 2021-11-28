package com.example.sss_capstone_project.utils

import android.graphics.Bitmap
import com.example.sss_capstone_project.model.response.UserResponse

sealed class QrCodeState {
    object IDLE : QrCodeState()
    object LOADING : QrCodeState()
    data class SucessState(
        val userResponse: UserResponse
    ) : QrCodeState()


}
