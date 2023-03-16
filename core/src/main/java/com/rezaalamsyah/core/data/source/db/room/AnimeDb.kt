package com.rezaalamsyah.core.data.source.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rezaalamsyah.core.data.source.db.entity.AnimeEntity
import com.rezaalamsyah.core.data.source.db.room.dao.AnimeDao

@Database(entities = [AnimeEntity::class], version = 1, exportSchema = false)
abstract class AnimeDb : RoomDatabase() {

    abstract fun animeDao(): AnimeDao

}