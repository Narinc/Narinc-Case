package com.narinc.challenge.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.narinc.challenge.domain.interactor.GetUserUseCase
import com.narinc.challenge.domain.repository.User
import com.narinc.challenge.presenter.models.enums.UserStatus
import com.narinc.challenge.presenter.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _navigate = MutableLiveData<Event<UserStatus>>()
    val navigate: LiveData<Event<UserStatus>> = _navigate

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getUserUseCase(Unit).collect {
                navigate(it)
            }
        }
    }

    private fun navigate(user: User?) {
        viewModelScope.launch(Dispatchers.Main) {
            _navigate.value = Event(
                if (user != null) {
                    UserStatus.CUSTOMER
                } else UserStatus.GUEST
            )
        }
    }
}
