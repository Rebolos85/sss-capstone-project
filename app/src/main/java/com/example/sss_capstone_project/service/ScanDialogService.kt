package com.example.sss_capstone_project.service

import android.content.Context
import cn.pedant.SweetAlert.SweetAlertDialog

interface ScanDialogService {

    fun showSuccessState(
        successState: Context,
        success: Int,

        successClickState: SweetAlertDialog.OnSweetClickListener,
        message: String,
        userData: String?,
        title: String,
    ): SweetAlertDialog

    fun showErrorState(
        errorStateContext: Context,
        error: Int,
        message: String,
        errorStateClick: SweetAlertDialog.OnSweetClickListener,
        userData: String?,
        title: String,
    ): SweetAlertDialog


    fun showLoadingState(
        loadingContext: Context,
        loadingState: Int,
        message: String,
        errorStateClick: SweetAlertDialog.OnSweetClickListener,
        title: String,
    ): SweetAlertDialog


    fun showDialogs(
        context: Context,
        state: Int,
        onClickListener: SweetAlertDialog.OnSweetClickListener,
        message: String,
        userData: String,
        title: String,

        ): SweetAlertDialog

}