package com.narinc.challenge.presenter.viewmodel

import com.narinc.challenge.presenter.utils.CoroutineContextProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    contextProvider: CoroutineContextProvider
) : BaseViewModel(contextProvider) {

    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        // val message = ExceptionHandler.parse(exception)
        // _characterList.postValue(CharacterUIModel.Error(exception.message ?: "Error"))
    }
}
