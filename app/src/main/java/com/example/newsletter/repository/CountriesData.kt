package com.example.newsletter.repository

import com.example.newsletter.model.Category

object CountriesData {
    val dataList = listOf(
        Category(
            category="",
            source="",
            country="fr",
            name = "Pays",
            label = "france",
            image = "https://i.picsum.photos/id/1075/500/300.jpg?hmac=5DhRFK2dTT-URjGdj3Fgb8fBZOGnqy-lIR1gIm_JJ3U"
        ),
        Category(
            category="",
            source="",
            country="us",
            name = "Pays",
            label = "USA",
            image = "https://picsum.photos/500/300?random=1"
        ),
        Category(
            category="",
            source="",
            country="en",
            name = "Pays",
            label = "angleterre",
            image = "https://picsum.photos/500/300?random=2"
        ),
        Category(
            category="",
            source="",
            country="ch",
            name = "Pays",
            label = "chine",
            image = "https://picsum.photos/500/300?random=3"
        )
    )
}