package com.example.androidbasicswithcompose.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val topicName: Int,
    val topicNumber: Int,
    @DrawableRes val topicImage: Int
)
