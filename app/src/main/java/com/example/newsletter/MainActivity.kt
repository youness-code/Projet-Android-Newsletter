package com.example.newsletter

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.newsletter.model.Article
import com.example.newsletter.model.Category
import com.example.newsletter.utils.CellClickListener
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.newsletter.fragments.AcceuilFragment
import com.example.newsletter.fragments.ArticlesFragment
import com.example.newsletter.fragments.aproposdenous.MenuDevelopperFragment
import com.example.newsletter.fragments.aproposdenous.MenuFonctionnalitiesFragment
import com.example.newsletter.fragments.aproposdenous.MenuLlibrairiesFragment
import com.example.newsletter.fragments.favoris.ArticleFavorisFragment


class MainActivity : AppCompatActivity(), CellClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref.edit().clear().commit()
        setContentView(R.layout.activity_main)
        changeFragment(AcceuilFragment(this))
    }

    private var PRIVATE_MODE = 0
    private val PREF_NAME = "articles-favoris"
    private val sharedPref: SharedPreferences by lazy { getSharedPreferences(PREF_NAME, PRIVATE_MODE) }

    fun onFavArticle( article: Article){
        val FAV_KEY = "article_fav"
        val gson: Gson = Gson()

        val articlesString = sharedPref.getString(FAV_KEY, "[]")
        val type = object : TypeToken<MutableList<Article?>?>() {}.type
        val articles = gson.fromJson<MutableList<Article>>(articlesString, type)
        articles.add(article)
        val articleToString: String = gson.toJson(articles)
        sharedPref.edit().putString(FAV_KEY, articleToString).commit()
    }

    fun onRemoveFavArticle( article: Article){
        val FAV_KEY = "article_fav"
        val gson: Gson = Gson()

        val articlesString = sharedPref.getString(FAV_KEY, "[]")
        val type = object : TypeToken<MutableList<Article?>?>() {}.type
        val articles = gson.fromJson<MutableList<Article>>(articlesString, type)

        val articlesFilterd = articles.filter {
            it.url != article.url
        }
        val articleToString: String = gson.toJson(articlesFilterd)
        sharedPref.edit().putString(FAV_KEY, articleToString).commit()
    }

    fun getListArticlesFav(): List<Article>{
        val FAV_KEY = "article_fav"
        val gson: Gson = Gson()

        val articlesString = sharedPref.getString(FAV_KEY, "[]")
        println(" $articlesString")
        val type = object : TypeToken<MutableList<Article?>?>() {}.type
        val articles = gson.fromJson<MutableList<Article>>(articlesString, type)
        return articles
    }

    override fun onCellClickListener(category: Category) {
        println("Catégory cliquée : $category")
        changeFragment(ArticlesFragment(category, this))
    }

    // Gestion des menus

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.page_1) {
            changeFragment(AcceuilFragment(this))
            return true
        }
        if (id == R.id.page_2) {
            changeFragment(ArticleFavorisFragment(this))
            return true
        }
        if (id == R.id.page_3) {
            changeFragment(MenuDevelopperFragment(this))
            return true
        }
        if (id == R.id.page_4) {
            changeFragment(MenuFonctionnalitiesFragment(this))
            return true
        }
        if (id == R.id.page_5) {
            changeFragment(MenuLlibrairiesFragment(this))
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}

// Ajouter le fragmet [ComputationFragment] dans l'activité

fun MainActivity.changeFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().apply {
        //3) on remplace le contenu du container
        replace(R.id.fragment_container, fragment)
        //4) on ajoute la transaction dans la backstack
        addToBackStack(null)
    }.commit()
    // 5) on commit la transaction
}