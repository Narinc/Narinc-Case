package com.narinc.challenge.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.narinc.challenge.adapters.HomePageAdapter
import com.narinc.challenge.databinding.FragmentHomeBinding
import com.narinc.challenge.presenter.viewmodel.BaseViewModel
import com.narinc.challenge.presenter.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, BaseViewModel>() {

    override val viewModel: HomeViewModel by viewModels()

    override fun getViewBinding(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    @Inject
    lateinit var adapter: HomePageAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvHomepage.adapter = adapter
    }
}
