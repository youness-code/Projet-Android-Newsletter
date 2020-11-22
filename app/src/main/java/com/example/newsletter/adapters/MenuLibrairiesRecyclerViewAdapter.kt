package com.example.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.R
import com.example.newsletter.model.menu.MenuLibraries
import com.example.newsletter.utils.CellClickListener

class MenuLibrairiesRecyclerViewAdapter(
    private val dataset: List<MenuLibraries>,
    private val cellClickListener: CellClickListener
) :
    RecyclerView.Adapter<MenuLibrairiesRecyclerViewAdapter.ViewHolder>() {

        class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
            lateinit var aproposdenousLibrairiesitem: MenuLibraries
            fun bind(item: MenuLibraries) {
                aproposdenousLibrairiesitem = item

                /**
                 * Recuperation des textview à partir du layout
                 */
                val lib_name = root.findViewById<TextView>(R.id.librairie_name)
                val lib_description= root.findViewById<TextView>(R.id.librairie_description)
                /**
                 * Initialisation des champs txt
                 */
                lib_name.text=item.librairie_name.capitalize()
                lib_description.text=item.librairie_description.capitalize()
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            val rootView =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.external_librairie_item, parent, false)
            return ViewHolder(rootView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(
                dataset[position]

            )
        }

        override fun getItemCount(): Int = dataset.size
}