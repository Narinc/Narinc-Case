package com.narinc.challenge.domain.interactor

import com.narinc.challenge.domain.repository.User
import com.narinc.challenge.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetUserBaseUseCase = BaseUseCase<Unit, Flow<User?>>

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
) : GetUserBaseUseCase {

    override suspend fun invoke(params: Unit) = repository.getUser()
}
