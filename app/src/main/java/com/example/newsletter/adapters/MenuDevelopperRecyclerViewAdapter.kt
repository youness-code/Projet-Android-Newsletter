package com.example.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsletter.R
import com.example.newsletter.model.menu.MenuDevelopper
import com.example.newsletter.utils.CellClickListener

class MenuDevelopperRecyclerViewAdapter(
    private val dataset: List<MenuDevelopper>,
    private val cellClickListener: CellClickListener
) :
    RecyclerView.Adapter<MenuDevelopperRecyclerViewAdapter.ViewHolder>() {

        class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
            lateinit var aproposdenousDevInfoItem: MenuDevelopper
            fun bind(item: MenuDevelopper) {
                aproposdenousDevInfoItem = item

                val txtfirstName = root.findViewById<TextView>(R.id.developper_firstName)
                val txtlastName = root.findViewById<TextView>(R.id.developper_lastName)
                val dev_img = root.findViewById<ImageView>(R.id.developper_img)
                val githref = root.findViewById<TextView>(R.id.developper_git)


                Glide
                    .with(root)
                    .load(item.developper_img)
                    .circleCrop()
                    .placeholder(R.drawable.placeholder)
                    .into(dev_img);


                txtfirstName.text=item.firstName.capitalize()
                txtlastName.text=item.lastName.capitalize()
                githref.text=item.developper_git.capitalize()
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            val rootView =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.menu_item, parent, false)
            return ViewHolder(rootView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(
                dataset[position]

            )
        }

        override fun getItemCount(): Int = dataset.size
}