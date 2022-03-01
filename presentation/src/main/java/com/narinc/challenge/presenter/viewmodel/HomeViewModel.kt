package com.narinc.challenge.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.narinc.challenge.domain.interactor.GetHomePageDataUseCase
import com.narinc.challenge.domain.models.HomePageData
import com.narinc.challenge.presenter.utils.CoroutineContextProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    contextProvider: CoroutineContextProvider,
    private val getHomePageDataUseCase: GetHomePageDataUseCase
) : BaseViewModel(contextProvider) {

    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        // val message = ExceptionHandler.parse(exception)
        // _characterList.postValue(CharacterUIModel.Error(exception.message ?: "Error"))
    }

    private val _showData = MutableLiveData<List<HomePageData>>()
    val showData: LiveData<List<HomePageData>> = _showData

    init {
        launchCoroutineIO {
            getHomePageDataUseCase(Unit).collect {
                _showData.postValue(it)
            }
        }
    }
}
