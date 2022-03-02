package com.narinc.challenge.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaDetail(
    val title: String?,
    val subtitle: String?,
    val image: String?,
    val date: String?,
    val content: String?
) : Parcelable
