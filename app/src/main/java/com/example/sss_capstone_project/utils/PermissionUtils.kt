package com.example.sss_capstone_project.utils

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment

fun Fragment.multiplePermission(function: (Map<String, Boolean>) -> Unit): ActivityResultLauncher<Array<String>> {
    return this.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
        function(it)
    }
}