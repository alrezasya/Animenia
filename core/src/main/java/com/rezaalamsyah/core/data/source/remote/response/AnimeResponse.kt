package com.rezaalamsyah.core.data.source.remote.response

import com.rezaalamsyah.core.domain.model.AnimeImage
import com.rezaalamsyah.core.domain.model.ImageDetail
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
@Suppress("unused")
@JsonClass(generateAdapter = true)
data class ListAnimeResponse(
    @Json(name = "data")
    val listData: List<AnimeResponse>? = null
)

@Suppress("unused")
@JsonClass(generateAdapter = true)
data class AnimeResponse(
    @Json(name ="mal_id")
    val id: Int,

    @Json(name ="images")
    val image: AnimeImageData? = null,

    @Json(name ="title")
    val title: String? = null,

    @Json(name ="type")
    val type: String? = null,

    @Json(name ="source")
    val source: String? = null,

    @Json(name ="episodes")
    val episodes: Int? = null,

    @Json(name ="status")
    val status: String? = null,

    @Json(name ="airing")
    val airing: Boolean? = null,

    @Json(name ="duration")
    val duration: String? = null,

    @Json(name ="rating")
    val rating: String? = null,

    @Json(name ="score")
    val score: Double? = null,

    @Json(name ="scored_by")
    val scoredBy: Int? = null,

    @Json(name ="synopsis")
    val synopsis: String? = null,

)

@Suppress("unused")
@JsonClass(generateAdapter = true)
data class AnimeImageData(
    @Json(name ="jpg")
    val jpg: ImageDetailData? = null,

    @Json(name ="webp")
    val webp: ImageDetailData? = null,
) {
    fun toAnimeImage(): AnimeImage {
        return AnimeImage(
            jpg = jpg?.toImageDetail(),
            webp = webp?.toImageDetail()
        )
    }
}

@Suppress("unused")
@JsonClass(generateAdapter = true)
data class ImageDetailData(
    @Json(name ="image_url")
    val imageUrl: String? = null,

    @Json(name ="small_image_url")
    val smallImageUrl: String? = null,

    @Json(name ="large_image_url")
    val largeImageUrl: String? = null,
) {
    fun toImageDetail() : ImageDetail {
        return ImageDetail(
            imageUrl = imageUrl,
            smallImageUrl = smallImageUrl,
            largeImageUrl = largeImageUrl
        )
    }
}