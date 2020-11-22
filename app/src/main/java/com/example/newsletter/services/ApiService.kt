package com.example.newsletter.services

interface ApiService {
    fun getArticles(): List<Article>
}