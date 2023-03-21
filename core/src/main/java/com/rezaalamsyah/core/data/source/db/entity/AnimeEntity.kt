package com.rezaalamsyah.core.data.source.db.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Suppress("unused")

@Entity(tableName = "animenia")
data class AnimeEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "animeId")
    var animeId: Int,

    @ColumnInfo(name = "image")
    val image: String? = null,

    @ColumnInfo(name = "title")
    val title: String? = null,

    @ColumnInfo(name = "type")
    val type: String? = null,

    @ColumnInfo(name = "source")
    val source: String? = null,

    @ColumnInfo(name = "episodes")
    val episodes: Int? = null,

    @ColumnInfo(name = "status")
    val status: String? = null,

    @ColumnInfo(name = "airing")
    val airing: Boolean? = null,

    @ColumnInfo(name = "duration")
    val duration: String? = null,

    @ColumnInfo(name = "rating")
    val rating: String? = null,

    @ColumnInfo(name = "score")
    val score: Double? = null,

    @ColumnInfo(name = "scoredBy")
    val scoredBy: Int? = null,

    @ColumnInfo(name = "synopsis")
    val synopsis: String? = null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)