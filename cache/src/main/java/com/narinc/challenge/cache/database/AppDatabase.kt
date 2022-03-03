package com.narinc.challenge.cache.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.narinc.challenge.cache.dao.HomePageDao
import com.narinc.challenge.cache.dao.UserDao
import com.narinc.challenge.cache.models.HomePageDataCacheEntity
import com.narinc.challenge.cache.models.UserCacheEntity
import com.narinc.challenge.cache.utils.CacheConstants
import com.narinc.challenge.cache.utils.Migrations
import javax.inject.Inject

@Database(
    entities = [UserCacheEntity::class, HomePageDataCacheEntity::class],
    version = Migrations.DB_VERSION,
    exportSchema = false
)
abstract class AppDatabase @Inject constructor() : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun homePageDao(): HomePageDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            CacheConstants.DB_NAME
        ).build()
    }
}
