package com.example.newsletter.repository

import com.example.newsletter.model.Category

object CategoriesData {
    val dataList = listOf(
        Category(
            category="business",
            source="",
            country="fr",
            name = "Category",
            label = "entreprise",
            image = "https://i.picsum.photos/id/1075/500/300.jpg?hmac=5DhRFK2dTT-URjGdj3Fgb8fBZOGnqy-lIR1gIm_JJ3U"
        ),
        Category(
            category="entertainment",
            source="",
            country="fr",
            name = "Category",
            label = "divertissement",
            image = "https://picsum.photos/500/300?random=1"
        ),
        Category(
            category="technology",
            source="",
            country="us",
            name = "Category",
            label = "technology",
            image = "https://picsum.photos/500/300?random=2"
        ),
        Category(
            category="health",
            source="",
            country="fr",
            name = "Category",
            label = "santé",
            image = "https://picsum.photos/500/300?random=3"
        ),
        Category(
            category="science",
            source="",
            country="fr",
            name = "Category",
            label = "sciences",
            image = "https://picsum.photos/500/300?random=4"
        ),
        Category(
            category="sports",
            label="sports",
            source="",
            country="fr",
            name = "Category",
            image = "https://picsum.photos/500/300?random=5"
        )
    )
}