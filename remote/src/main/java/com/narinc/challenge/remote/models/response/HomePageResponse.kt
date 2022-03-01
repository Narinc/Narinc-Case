package com.narinc.challenge.remote.models.response

import com.narinc.challenge.remote.models.Meditation
import com.narinc.challenge.remote.models.Story

data class HomePageResponse(
    val isBannerEnable: Boolean?,
    val meditations: List<Meditation>?,
    val stories: List<Story>?
)
