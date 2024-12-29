package com.deven.lifestyleapp.models

import kotlinx.serialization.Serializable

@Serializable
data class SliderData(
    val id: Int,
    val image: String,
    val title: String,
    val desc: String
)
