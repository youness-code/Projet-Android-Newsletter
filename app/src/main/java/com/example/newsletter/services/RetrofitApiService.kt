package com.example.newsletter.services

import com.example.newsletter.model.editor.EditorObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApiService {
    @GET("sources")
    suspend fun list(
        @Query("apiKey") apiKey: String,
        @Query("language") country: String = "fr"
    ): Response<EditorObject>
}
