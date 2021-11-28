package com.example.sss_capstone_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.sss_capstone_project.databinding.ActivityMainBinding
import com.example.sss_capstone_project.databinding.FragmentScanQrCodeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private lateinit var navController: NavController
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.activity_main_container) as NavHostFragment
        navController = navHostFragment.findNavController()

        setSupportActionBar(binding.toolbar)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            title = when (destination.id) {
                R.id.fragmentFirstScreen -> {
                    binding.aboutUs.visibility = View.VISIBLE
                    "iQueue"
                }
                R.id.dashboardFragment -> {
                    binding.aboutUs.visibility = View.INVISIBLE
                    "Dashboard"
                }
                R.id.scanQrFragment -> {
                    binding.aboutUs.visibility = View.INVISIBLE
                    "Scan"
                }
                R.id.fragmentAboutUs -> {
                    binding.aboutUs.visibility = View.INVISIBLE
                    "About Us"
                }
                R.id.fragmentQrResult -> {
                    binding.aboutUs.visibility = View.INVISIBLE
                    "Result"
                }
                else -> "Default title"
            }

        }
        showAboutUs()
    }

//
//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }

    private fun showAboutUs() {
        binding.aboutUs.setOnClickListener {
            navController.navigate(R.id.fragmentAboutUs)
        }
    }


}