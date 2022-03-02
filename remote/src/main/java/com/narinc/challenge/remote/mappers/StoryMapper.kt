package com.narinc.challenge.remote.mappers

import com.narinc.challenge.data.models.HomePageItemEntity
import com.narinc.challenge.data.models.ImageEntity
import com.narinc.challenge.remote.models.Story
import javax.inject.Inject

class StoryMapper @Inject constructor() : EntityMapper<Story, HomePageItemEntity> {

    override fun mapFromModel(model: Story) = HomePageItemEntity(
        title = model.name,
        subtitle = model.category,
        image = ImageEntity(model.image?.small, model.image?.large),
        date = model.date,
        content = model.text
    )
}
