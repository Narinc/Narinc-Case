package com.narinc.challenge.data.mapper

import com.narinc.challenge.data.models.UserEntity
import com.narinc.challenge.domain.repository.User
import javax.inject.Inject

class UserMapper @Inject constructor() : Mapper<UserEntity, User> {

    override fun mapFromEntity(type: UserEntity): User {
        return User(
            username = type.username
        )
    }

    override fun mapToEntity(type: User): UserEntity {
        return UserEntity(
            username = type.username
        )
    }
}
