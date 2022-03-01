package com.narinc.challenge.domain.models

class HomePageData(
    val type: Type,
    val items: List<HomePageItem>? = null
) {

    enum class Type(val value: Int) {
        MEDITATION(0),
        STORY(1),
        CARD(2)
    }
}
