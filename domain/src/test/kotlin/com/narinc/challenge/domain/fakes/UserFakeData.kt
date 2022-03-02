package com.narinc.challenge.domain.fakes

import com.narinc.challenge.domain.fakes.FakeValueFactory.randomString
import com.narinc.challenge.domain.repository.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object UserFakeData {

    fun provideUser(username: String? = randomString()): Flow<User?> = flow {
        username?.let {
            emit(User(username))
        } ?: emit(null)
    }
}
