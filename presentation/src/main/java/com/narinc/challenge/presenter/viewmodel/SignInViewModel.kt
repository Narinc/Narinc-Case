package com.narinc.challenge.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.narinc.challenge.domain.interactor.SaveUserUseCase
import com.narinc.challenge.domain.interactor.SignInValidationUseCase
import com.narinc.challenge.presenter.utils.CoroutineContextProvider
import com.narinc.challenge.presenter.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    contextProvider: CoroutineContextProvider,
    private val validation: SignInValidationUseCase,
    private val saveUser: SaveUserUseCase
) : BaseViewModel(contextProvider) {

    private val _userNameError = MutableLiveData<Event<Boolean>>()
    val userNameError: LiveData<Event<Boolean>> = _userNameError

    private val _passwordError = MutableLiveData<Event<Boolean>>()
    val passwordError: LiveData<Event<Boolean>> = _passwordError

    private val _navigateHome = MutableLiveData<Event<String>>()
    val navigateHome: LiveData<Event<String>> = _navigateHome

    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        // val message = ExceptionHandler.parse(exception)
        // _characterList.postValue(CharacterUIModel.Error(exception.message ?: "Error"))
    }

    fun attemptSignIn(username: String, password: String) {
        launchCoroutineMain {
            validation(Pair(username, password)).collect {
                when (it) {
                    SignInValidationUseCase.RESULT.INVALID_USERNAME -> {
                        setError(usernameError = true)
                    }
                    SignInValidationUseCase.RESULT.INVALID_PASSWORD -> {
                        setError(passwordError = true)
                    }
                    SignInValidationUseCase.RESULT.VALID -> {
                        setError()
                        onValidAttempt(username)
                        _navigateHome.value = Event(username)
                    }
                }
            }
        }
    }

    private fun setError(
        usernameError: Boolean = false,
        passwordError: Boolean = false
    ) {
        _userNameError.value = Event(usernameError)
        _passwordError.value = Event(passwordError)
    }

    private fun onValidAttempt(username: String) {
        launchCoroutineIO {
            saveUser(username)
        }
    }
}
