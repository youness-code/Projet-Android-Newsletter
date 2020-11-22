package com.example.newsletter.fragments.aproposdenous

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.R
import com.example.newsletter.adapters.MenuLibrairiesRecyclerViewAdapter
import com.example.newsletter.repository.Contents
import com.example.newsletter.utils.CellClickListener


class MenuLlibrairiesFragment(private val cellClickListener: CellClickListener) : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.title = "Librairies"
        return inflater.inflate(R.layout.fragment_menu_librairies, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerViewlibrairie: RecyclerView = view.findViewById(R.id.librairies_infos)
        val aproposdenousLibrairiesitem = Contents.MenuLibrariesList()

        val adapterRecycler = MenuLibrairiesRecyclerViewAdapter(aproposdenousLibrairiesitem, cellClickListener)
        recyclerViewlibrairie.layoutManager = GridLayoutManager(view.context, 1)
        recyclerViewlibrairie.adapter = adapterRecycler
    }

}