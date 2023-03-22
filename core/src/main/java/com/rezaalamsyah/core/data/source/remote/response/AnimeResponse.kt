package com.rezaalamsyah.core.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.rezaalamsyah.core.domain.model.AnimeImage
import com.rezaalamsyah.core.domain.model.ImageDetail

@Suppress("unused")
data class ListAnimeResponse(
    @field:SerializedName( "data")
    val listData: List<AnimeResponse>? = null
)

@Suppress("unused")
data class AnimeResponse(
    @field:SerializedName("mal_id")
    val id: Int,

    @field:SerializedName("images")
    val image: AnimeImageData? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("source")
    val source: String? = null,

    @field:SerializedName("episodes")
    val episodes: Int? = null,

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("airing")
    val airing: Boolean? = null,

    @field:SerializedName("duration")
    val duration: String? = null,

    @field:SerializedName("rating")
    val rating: String? = null,

    @field:SerializedName("score")
    val score: Double? = null,

    @field:SerializedName("scored_by")
    val scoredBy: Int? = null,

    @field:SerializedName("synopsis")
    val synopsis: String? = null,

)

@Suppress("unused")
data class AnimeImageData(
    @field:SerializedName("jpg")
    val jpg: ImageDetailData? = null,

    @field:SerializedName("webp")
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
data class ImageDetailData(
    @field:SerializedName("image_url")
    val imageUrl: String? = null,

    @field:SerializedName("small_image_url")
    val smallImageUrl: String? = null,

    @field:SerializedName("large_image_url")
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