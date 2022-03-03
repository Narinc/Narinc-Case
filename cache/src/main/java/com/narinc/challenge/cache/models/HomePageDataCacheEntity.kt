package com.narinc.challenge.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.narinc.challenge.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.HOME_DATA_TABLE_NAME)
data class HomePageDataCacheEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val type: Int,
    val title: String?,
    val subtitle: String?,
    val smallImage: String?,
    val largeImage: String?,
    val date: String?,
    val content: String?
)
