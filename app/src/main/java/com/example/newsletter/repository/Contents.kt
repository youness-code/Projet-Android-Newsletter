package com.example.newsletter.repository

import com.example.newsletter.model.Article
import com.example.newsletter.model.Category
import com.example.newsletter.model.menu.MenuDevelopper
import com.example.newsletter.model.menu.MenuFonctionalities
import com.example.newsletter.model.menu.MenuLibraries
import com.example.newsletter.services.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Contents {
    private val service: ApiService
    private const val baseUrl: String = "http://newsapi.org/"
    private const val apiKey: String = "7b7d36b8c1434af18f651f7ccd2eca2e"
    private const val country: String = "us"
    var isFetched = false

    val categoryArticles = mutableMapOf<String, List<Article>>()

    suspend fun articleList(category: Category): List<Article> {
        val response = service.list(
            category = category.category,
            apiKey = apiKey,
            country = category.country,
            sources = category.source
        )
        val articles: List<Article>? = response.body()?.articles
            ?.filter {
                !it.urlToImage.isNullOrBlank()
            }
        return  articles ?:emptyList()
    }

    fun categoryList(): List<Category> = CategoriesData.dataList

    /**
     * Fonction pour gerer la vue a propos de nous
     */

    // Developper infos list

    fun MenuDevelopperList(): List<MenuDevelopper> = MenuDevelopperData.dataList

    // Fonctionnalities infos list

    fun MenuFonctionalitiesList(): List<MenuFonctionalities> = MenuFonctionalitiesData.dataList


    // Librairies infos list

    fun MenuLibrariesList(): List<MenuLibraries> = MenuLibrairiesData.dataList


    // Gestion des favories

    fun listArticleFavori(): List<Article>{
        return emptyList()
    }


    fun countryList(): List<Category> = CountriesData.dataList
    suspend fun editorList(): List<Category> = EditorData.dataList(apiKey)
    init {

        // Loggin
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    service = retrofit.create(ApiService::class.java)
    }
}