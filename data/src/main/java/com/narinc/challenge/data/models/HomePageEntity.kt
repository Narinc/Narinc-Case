package com.narinc.challenge.data.models

data class HomePageEntity(
    val type: Type,
    val items: List<HomePageItemEntity>? = null
) {

    enum class Type(val value: Int) {
        MEDITATION(0),
        STORY(1),
        CARD(2)
    }
}
