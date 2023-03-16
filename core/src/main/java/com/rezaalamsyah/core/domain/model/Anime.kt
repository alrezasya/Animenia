package com.rezaalamsyah.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val animeId: Int,
    val image: String? = null,
    val title: String? = null,
    val type: String? = null,
    val source: String? = null,
    val episodes: Int? = null,
    val status: String? = null,
    val airing: Boolean? = null,
    val duration: String? = null,
    val rating: String? = null,
    val score: Double? = null,
    val scoredBy: Int? = null,
    val synopsis: String? = null,
    val isFavorite: Boolean = false,
    ) : Parcelable

@Parcelize
data class AnimeImage(
    val jpg: ImageDetail? = null,
    val webp: ImageDetail? = null,
) : Parcelable

@Parcelize
data class ImageDetail(
    val imageUrl: String? = null,
    val smallImageUrl: String? = null,
    val largeImageUrl: String? = null,
) : Parcelable