package com.example.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.R
import com.example.newsletter.model.menu.MenuFonctionalities
import com.example.newsletter.utils.CellClickListener

class MenuFonctionalitiesRecyclerViewAdapter(
    private val dataset: List<MenuFonctionalities>,
    private val cellClickListener: CellClickListener
) :
    RecyclerView.Adapter<MenuFonctionalitiesRecyclerViewAdapter.ViewHolder>() {

        class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
            lateinit var aproposdenousFonctionalitieitem: MenuFonctionalities
            fun bind(item: MenuFonctionalities) {
                aproposdenousFonctionalitieitem = item

                val fonct_name = root.findViewById<TextView>(R.id.fonctionalitie_name)
                val fonct_description= root.findViewById<TextView>(R.id.fonctionalitie_description)

                fonct_name.text=item.fonctionalitie_name.capitalize()
                fonct_description.text=item.fonctionalitie_description.capitalize()
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            val rootView =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.fonctionnalitie_item, parent, false)
            return ViewHolder(rootView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(
                dataset[position]

            )
        }

        override fun getItemCount(): Int = dataset.size
}