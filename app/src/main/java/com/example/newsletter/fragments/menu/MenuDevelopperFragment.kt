package com.example.newsletter.fragments.aproposdenous

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.R
import com.example.newsletter.adapters.MenuDevelopperRecyclerViewAdapter
import com.example.newsletter.repository.Contents
import com.example.newsletter.utils.CellClickListener

class MenuDevelopperFragment(private val cellClickListener: CellClickListener) : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.title = "A propos de Nous"
        return inflater.inflate(R.layout.fragment_menu_developper, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Developpers

        val recyclerViewdevinfo: RecyclerView = view.findViewById(R.id.developper_infos)
        val aproposdenousitem = Contents.MenuDevelopperList()

        val adapterRecyclerdevinfo = MenuDevelopperRecyclerViewAdapter(aproposdenousitem, cellClickListener)
        recyclerViewdevinfo.layoutManager = GridLayoutManager(view.context, 1)
        recyclerViewdevinfo.adapter = adapterRecyclerdevinfo

    }

}