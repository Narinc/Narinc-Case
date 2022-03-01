package com.narinc.challenge.ui

import androidx.fragment.app.viewModels
import com.narinc.challenge.databinding.FragmentHomeBinding
import com.narinc.challenge.presenter.viewmodel.BaseViewModel
import com.narinc.challenge.presenter.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, BaseViewModel>() {
    override val viewModel: HomeViewModel by viewModels()

    override fun getViewBinding(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)
}
