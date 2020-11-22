package com.example.newsletter.repository

import com.example.newsletter.model.Category
import com.example.newsletter.model.editor.EditorItem
import com.example.newsletter.services.RetrofitApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object EditorData {
    private val service: RetrofitApiService
    private const val baseUrl: String = "https://newsapi.org/"
    suspend fun dataList(apiKey: String): List<Category>{
        val response = service.list(
            apiKey = apiKey,
            category = category.category,
            sources = category.source
        )
        val sources: List<EditorItem>? = response.body()?.sources
        var r : Int = 15
        if (sources != null) {
            return  sources.map{
                Category(
                    name = "Sources",
                    label = it.name,
                    image = "https://picsum.photos/500/300?random=${r++}",
                    category="",
                    source=it.id,
                    country=""
                )
            }
        }
        return emptyList()
    }
    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
        service = retrofit.create(RetrofitApiService::class.java)
    }
}