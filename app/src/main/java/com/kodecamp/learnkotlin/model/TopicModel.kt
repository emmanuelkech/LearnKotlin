package com.kodecamp.learnkotlin.model

import java.io.Serializable

data class TopicModel(
    val imageResId: Int,
    val title: Int,
    val description: Int,
    val difficulty: Int,
    var text: String = "") : Serializable