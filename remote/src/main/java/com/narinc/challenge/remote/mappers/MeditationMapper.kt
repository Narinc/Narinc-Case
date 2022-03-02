package com.narinc.challenge.remote.mappers

import com.narinc.challenge.data.models.HomePageItemEntity
import com.narinc.challenge.data.models.ImageEntity
import com.narinc.challenge.remote.models.Meditation
import javax.inject.Inject

class MeditationMapper @Inject constructor() : EntityMapper<Meditation, HomePageItemEntity> {

    override fun mapFromModel(model: Meditation) = HomePageItemEntity(
        title = model.title,
        subtitle = model.subtitle,
        image = ImageEntity(model.image?.small, model.image?.large),
        date = model.releaseDate,
        content = model.content
    )
}
