package com.narinc.challenge.domain.interactor

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.regex.Pattern
import javax.inject.Inject

typealias SignInUsernameValidationBaseUseCase = BaseUseCase<Pair<String?, String?>, Flow<SignInValidationUseCase.RESULT>>

class SignInValidationUseCase @Inject constructor() : SignInUsernameValidationBaseUseCase {

    enum class RESULT {
        INVALID_USERNAME,
        INVALID_PASSWORD,
        VALID
    }

    companion object {
        private const val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z]).{8,20}$"
    }

    override suspend fun invoke(params: Pair<String?, String?>) = flow {
        val username = params.first
        val password = params.second
        when {
            isUsernameValid(username).not() -> emit(RESULT.INVALID_USERNAME)
            isPasswordValid(password).not() -> emit(RESULT.INVALID_PASSWORD)
            else -> emit(RESULT.VALID)
        }
    }

    private fun isUsernameValid(username: String?) = username?.length ?: 0 > 2

    private fun isPasswordValid(password: String?): Boolean {
        return password?.let {
            val pattern = Pattern.compile(PASSWORD_PATTERN)
            val matcher = pattern.matcher(password)
            matcher.matches()
        } ?: false
    }
}
