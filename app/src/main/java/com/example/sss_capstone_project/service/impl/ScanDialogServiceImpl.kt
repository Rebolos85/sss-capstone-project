package com.example.sss_capstone_project.service.impl

import android.content.Context
import android.graphics.Color
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.sss_capstone_project.R
import com.example.sss_capstone_project.service.ScanDialogService
import javax.inject.Inject

class ScanDialogServiceImpl @Inject constructor() : ScanDialogService {
    override fun showSuccessState(
        successState: Context,
        success: Int,
        successClickState: SweetAlertDialog.OnSweetClickListener,
        message: String,
        userData: String?,
        title: String,
    ): SweetAlertDialog {
        val dialog = userData?.let {
            showDialogs(
                context = successState,
                state = success,
                onClickListener = successClickState,
                message = message,
                userData = it,
                title = title
            )
        }
        return dialog?.takeIf {
            true
        }!!
    }

    override fun showErrorState(
        errorStateContext: Context,
        error: Int,
        message: String,
        errorStateClick: SweetAlertDialog.OnSweetClickListener,
        userData: String?,
        title: String,
    ): SweetAlertDialog {
        val test =
            userData?.let {
                showDialogs(
                    context = errorStateContext,
                    state = error,
                    onClickListener = errorStateClick,
                    message = message,
                    userData = it,
                    title = title
                )
            }
        return test?.takeIf {
            true
        }!!
    }

    override fun showLoadingState(
        loadingContext: Context,
        loadingState: Int,
        message: String,
        errorStateClick: SweetAlertDialog.OnSweetClickListener,
        title: String,
    ): SweetAlertDialog {

        return showDialogs(
            context = loadingContext,
            state = loadingState,
            onClickListener = errorStateClick,
            message = message,
            userData = "",
            title = title
        )
    }


    override fun showDialogs(
        context: Context,
        state: Int,
        onClickListener: SweetAlertDialog.OnSweetClickListener,
        message: String,
        userData: String,
        title: String,
    ): SweetAlertDialog {
        val sweetAlertDialog = SweetAlertDialog(context, state).apply {

            when (state) {
                SweetAlertDialog.SUCCESS_TYPE -> {
                    setCustomImage(R.drawable.ic_check_icon)
                    setTitle(title)

                    titleText = message
                    contentText = userData
                    confirmText = "Ok"
                    cancelText = "Cancel"
                    dismiss()

                }

                SweetAlertDialog.PROGRESS_TYPE -> {
                    setTitle(title)
                    progressHelper.barColor = Color.parseColor("#A5DC86")
                    confirmText = "Ok"
                    cancelText = "Cancel"

                }
                SweetAlertDialog.ERROR_TYPE -> {
                    titleText = message
                    setTitle(title)
                    contentText = "No user found in this QR Code"
                    confirmText = "Ok"
                    cancelText = "Cancel"

                }
            }

        }

        sweetAlertDialog.show()


        return sweetAlertDialog
    }
}