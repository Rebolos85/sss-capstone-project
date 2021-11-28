package com.example.sss_capstone_project.utils

import androidx.navigation.NavController
import androidx.navigation.NavDirections


fun NavController.safeNavigate(direction: NavDirections) {
    currentDestination?.getAction(direction.actionId)?.run { navigate(direction) }
}