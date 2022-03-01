package com.narinc.challenge.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.narinc.challenge.R
import com.narinc.challenge.databinding.ActivityMainBinding
import com.narinc.challenge.extension.observe
import com.narinc.challenge.presenter.models.enums.UserStatus
import com.narinc.challenge.presenter.utils.Event
import com.narinc.challenge.presenter.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController =
            (supportFragmentManager.findFragmentById(R.id.host) as NavHostFragment).navController
        observe(viewModel.navigate, ::setStartDestinationHome)
    }

    private fun setStartDestinationHome(event: Event<UserStatus>) {
        event.getContentIfNotHandled()?.let { status ->
            val startDest = if (status == UserStatus.CUSTOMER) {
                R.id.homeFragment
            } else R.id.signInFragment
            val navGraph = navController.navInflater.inflate(R.navigation.main_navigation)
            navGraph.setStartDestination(startDest)
            navController.setGraph(navGraph, Bundle())
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}
