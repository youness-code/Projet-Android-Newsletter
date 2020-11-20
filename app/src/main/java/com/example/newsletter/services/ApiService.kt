package com.example.newsletter.services

import com.example.newsletter.model.Article

interface ApiService {
    fun getArticles(): List<Article>
}