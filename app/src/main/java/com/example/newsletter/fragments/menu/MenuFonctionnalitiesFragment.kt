package com.example.newsletter.fragments.aproposdenous

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.R
import com.example.newsletter.adapters.MenuFonctionalitiesRecyclerViewAdapter
import com.example.newsletter.repository.Contents
import com.example.newsletter.utils.CellClickListener

class MenuFonctionnalitiesFragment(private val cellClickListener: CellClickListener) : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.title = "Fontionalitées"
        return inflater.inflate(R.layout.fragment_menu_fonctionnalities, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.fonctionalities_infos)
        val aproposdenousfontionnalitiesitem = Contents.MenuFonctionalitiesList()

        val adapterRecycler = MenuFonctionalitiesRecyclerViewAdapter(aproposdenousfontionnalitiesitem, cellClickListener)
        recyclerView.layoutManager = GridLayoutManager(view.context, 1)
        recyclerView.adapter = adapterRecycler

    }

}