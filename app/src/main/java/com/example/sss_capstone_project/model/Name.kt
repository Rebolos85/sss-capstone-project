package com.example.sss_capstone_project.model

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Name(
    val first: String,
    val last: String,
    val middle: String,
) : Parcelable