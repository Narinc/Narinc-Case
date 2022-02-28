package com.narinc.challenge.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.narinc.challenge.cache.models.UserCacheEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user: UserCacheEntity)

    @Query("SELECT * FROM users LIMIT 1")
    fun getActiveUser(): UserCacheEntity
}
