package com.rezaalamsyah.core.data.source.db.room.dao

import androidx.room.*
import com.rezaalamsyah.core.data.source.db.entity.AnimeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimeDao {
    @Query("SELECT * FROM animenia")
    fun getAnimeList(): Flow<List<AnimeEntity>>

    @Query("SELECT * FROM animenia where isFavorite = 1")
    fun getFavoriteAnime(): Flow<List<AnimeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnimeList(anime: List<AnimeEntity>)

    @Update
    fun updateFavoriteAnime(anime: AnimeEntity)
}