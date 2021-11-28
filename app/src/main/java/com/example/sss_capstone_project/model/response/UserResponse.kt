package com.example.sss_capstone_project.model.response


import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import com.example.sss_capstone_project.model.Name
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserResponse(
    val name: Name,
    val date: String,
    val priorityNumber: String,
    val municipality: String?,
    val residence: String?,
    val barangay: String?
) : Parcelable