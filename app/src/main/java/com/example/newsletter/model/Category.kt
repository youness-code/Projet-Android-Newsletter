package com.example.newsletter.model

data class Category(
        val name: String,
        val source: String,
        val category: String,
        val country: String,
        val image: String,
        var label: String = name

)