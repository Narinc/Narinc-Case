package com.narinc.challenge.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.narinc.challenge.R
import com.narinc.challenge.databinding.FragmentSignInBinding
import com.narinc.challenge.extension.observe
import com.narinc.challenge.presenter.utils.Event
import com.narinc.challenge.presenter.viewmodel.BaseViewModel
import com.narinc.challenge.presenter.viewmodel.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : BaseFragment<FragmentSignInBinding, BaseViewModel>() {

    override val viewModel: SignInViewModel by viewModels()

    override fun getViewBinding(): FragmentSignInBinding =
        FragmentSignInBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignIn.setOnClickListener {
            viewModel.attemptSignIn(
                binding.etSignInUsername.text.toString(),
                binding.etSignInPassword.text.toString()
            )
        }

        observe(viewModel.userNameError, ::showUsernameError)
        observe(viewModel.passwordError, ::showPasswordError)
    }

    private fun showUsernameError(event: Event<Boolean>) {
        event.getContentIfNotHandled()?.let {
            binding.tilSignInUsername.error =
                if (it) getString(R.string.sign_in_username_error) else null
        }
    }

    private fun showPasswordError(event: Event<Boolean>) {
        event.getContentIfNotHandled()?.let {
            binding.tilSignInPassword.error =
                if (it) getString(R.string.sign_in_password_error) else null
        }
    }
}
