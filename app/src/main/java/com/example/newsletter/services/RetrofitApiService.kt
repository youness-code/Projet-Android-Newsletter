package com.example.newsletter.services

import com.example.newsletter.model.editor.EditorObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApiService {
    //GET --> On lance une requête de type GET
    // everything est l'action du web service qu'on veut apeler
    // Elle sera concaténée avec l'url prédéfini dans retrofit
    @GET("/everything")
    suspend fun list(
        @Query("apiKey") apiKey: String,
        @Query("language") country: String = "fr"
    ): Response<EditorObject>
}