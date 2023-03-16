package com.rezaalamsyah.core.utils

import com.rezaalamsyah.core.data.source.db.entity.AnimeEntity
import com.rezaalamsyah.core.data.source.remote.response.AnimeResponse
import com.rezaalamsyah.core.domain.model.Anime

object DataMapper {
    fun responsesToEntities(data: List<AnimeResponse>): List<AnimeEntity> =
        data.map {
            AnimeEntity(
                animeId = it.id,
                image = it.image?.toAnimeImage()?.webp?.imageUrl,
                title = it.title,
                type = it.type,
                source = it.source,
                episodes = it.episodes,
                status = it.status,
                airing = it.airing,
                duration = it.duration,
                rating = it.rating,
                score = it.score,
                scoredBy = it.scoredBy,
                synopsis = it.synopsis,
                isFavorite = false
            )
        }

    fun entitiesToDomain(data: List<AnimeEntity>): List<Anime> =
        data.map {
            Anime(
                animeId = it.animeId,
                image = it.image,
                title = it.title,
                type = it.type,
                source = it.source,
                episodes = it.episodes,
                status = it.status,
                airing = it.airing,
                duration = it.duration,
                rating = it.rating,
                score = it.score,
                scoredBy = it.scoredBy,
                synopsis = it.synopsis,
                isFavorite = it.isFavorite
            )
        }

    fun domainToEntity(data: Anime) = AnimeEntity(
        animeId = data.animeId,
        image = data.image,
        title = data.title,
        type = data.type,
        source = data.source,
        episodes = data.episodes,
        status = data.status,
        airing = data.airing,
        duration = data.duration,
        rating = data.rating,
        score = data.score,
        scoredBy = data.scoredBy,
        synopsis = data.synopsis,
        isFavorite = data.isFavorite
    )
}