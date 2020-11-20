package com.example.newsletter.services

data class ArticleResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
