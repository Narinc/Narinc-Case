package com.narinc.challenge.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.narinc.challenge.cache.models.HomePageDataCacheEntity

@Dao
interface HomePageDao {

    @Query("SELECT * FROM home_data")
    fun getHomePage(): List<HomePageDataCacheEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveHomePage(vararg data: HomePageDataCacheEntity)
}
