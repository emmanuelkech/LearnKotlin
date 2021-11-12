package com.kodecamp.learnkotlin.data

import com.kodecamp.learnkotlin.R
import com.kodecamp.learnkotlin.model.TopicModel

class TopicSource {

    fun loadTopics(): List<TopicModel>{
        return listOf(
            TopicModel(R.drawable.img_1, R.string.topic_title_1, R.string.topic_description_1, R.string.topic_difficulty_1),
            TopicModel(R.drawable.img_2, R.string.topic_title_2, R.string.topic_description_2, R.string.topic_difficulty_2),
            TopicModel(R.drawable.img_3, R.string.topic_title_3, R.string.topic_description_3, R.string.topic_difficulty_3),
            TopicModel(R.drawable.img_4, R.string.topic_title_4, R.string.topic_description_4, R.string.topic_difficulty_4)
        )
    }
}