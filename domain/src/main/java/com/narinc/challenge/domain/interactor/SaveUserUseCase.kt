package com.narinc.challenge.domain.interactor

import com.narinc.challenge.domain.repository.User
import com.narinc.challenge.domain.repository.UserRepository
import javax.inject.Inject

typealias SaveUserBaseUseCase = BaseUseCase<String, Unit>

class SaveUserUseCase @Inject constructor(
    private val repository: UserRepository
) : SaveUserBaseUseCase {
    override suspend fun invoke(params: String) {
        repository.saveUser(User(params))
    }
}
