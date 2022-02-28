package com.narinc.challenge.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.narinc.challenge.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.USER_TABLE_NAME)
data class UserCacheEntity(
    @PrimaryKey
    val username: String
)
