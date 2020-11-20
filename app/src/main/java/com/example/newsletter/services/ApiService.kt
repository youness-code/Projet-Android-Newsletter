package com.example.newsletter.services

import com.example.newsletter.model.ArticleItem

interface ApiService {
    fun getArticles(): List<ArticleItem>
}