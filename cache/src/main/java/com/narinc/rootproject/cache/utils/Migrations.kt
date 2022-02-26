package com.narinc.rootproject.cache.utils

import androidx.room.migration.Migration

object Migrations {
    const val DB_VERSION = 1

    fun getMigrations(): Array<Migration> {
        return arrayOf()
    }
}
