package com.example.sss_capstone_project.model

data class User(
    val barangay: String? = "",
    val phoneNumber: String? = "",
    val date: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val middleName: String = "",
    val municipality: String? = "",
    val priorityNumber: String = "",
    var residence: String? = "",
) {
}