package com.example.newsletter.services

import com.example.newsletter.model.ArticleItem

data class ArticleResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleItem>
)
