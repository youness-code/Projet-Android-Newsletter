package com.example.newsletter.model

import java.util.*

data class ArticleItem(
    val author: String,
    val title: String,
    val url: String,
    val description: String,
    val urlToImage: String,
    val publishedAt: Date,
    val content: String
)