package com.narinc.challenge.remote.mappers

import com.narinc.challenge.data.models.HomePageItemEntity
import com.narinc.challenge.data.models.ImageEntity
import com.narinc.challenge.remote.models.Story
import javax.inject.Inject

class StoryToHomePageItemEntityMapper @Inject constructor() : EntityMapper<Story, HomePageItemEntity> {

    override fun mapFromModel(model: Story): HomePageItemEntity {
        return HomePageItemEntity(
            title = model.name,
            subtitle = model.category,
            date = model.date,
            content = model.text,
            image = ImageEntity(model.image?.small, model.image?.large)
        )
    }
}
