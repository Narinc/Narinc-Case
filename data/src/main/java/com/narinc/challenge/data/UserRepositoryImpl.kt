package com.narinc.challenge.data

import com.narinc.challenge.data.mapper.UserMapper
import com.narinc.challenge.data.source.UserDataSourceFactory
import com.narinc.challenge.domain.repository.User
import com.narinc.challenge.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSourceFactory: UserDataSourceFactory,
    private val userMapper: UserMapper
) : UserRepository {

    override suspend fun saveUser(user: User) {
        val userEntity = userMapper.mapToEntity(user)
        dataSourceFactory.getDataStore().saveUser(userEntity)
    }

    override suspend fun getUser(): Flow<User?> = flow {
        val userEntity = dataSourceFactory.getDataStore().getUser()
        userEntity?.let {
            emit(userMapper.mapFromEntity(it))
        } ?: emit(null)
    }
}
