package com.example.newsletter.services

import com.example.newsletter.model.Article

data class ArticleResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
