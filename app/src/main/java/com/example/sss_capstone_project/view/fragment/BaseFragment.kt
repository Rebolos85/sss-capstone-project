package com.example.sss_capstone_project.view.fragment

import android.graphics.Color
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.sss_capstone_project.R
import com.github.razir.progressbutton.hideProgress
import com.github.razir.progressbutton.showDrawable
import com.github.razir.progressbutton.showProgress
import dagger.hilt.android.AndroidEntryPoint


abstract class BaseFragment : Fragment() {

    fun Button.showLoading() {
        showProgress {
            buttonTextRes = R.string.loading_state
            progressColor = Color.WHITE
        }
        setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.color_accent))
        setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
    }

    fun Button.hideLoading(state: String) {
        hideProgress(state)
    }

    fun Button.successState() {

        ContextCompat.getDrawable(requireContext(), R.drawable.ic_check_icon).apply {
            this?.let {
                setBounds(0, 0, 40, 40)
                showDrawable(it) {
                    buttonTextRes = R.string.label_state_success

                }
                setTextColor(ContextCompat.getColor(requireContext(), R.color.color_green_success))
                setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.color_accent))
            }
        }

    }
}