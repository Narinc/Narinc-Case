package com.narinc.challenge.ui

import androidx.fragment.app.viewModels
import com.narinc.challenge.databinding.FragmentSignInBinding
import com.narinc.challenge.presenter.viewmodel.BaseViewModel
import com.narinc.challenge.presenter.viewmodel.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : BaseFragment<FragmentSignInBinding, BaseViewModel>() {

    override val viewModel: SignInViewModel by viewModels()

    override fun getViewBinding(): FragmentSignInBinding =
        FragmentSignInBinding.inflate(layoutInflater)


}