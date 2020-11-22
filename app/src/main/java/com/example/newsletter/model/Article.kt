package com.example.newsletter.model

import java.util.*

data class Article(
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: Date,
    val content: String
)
