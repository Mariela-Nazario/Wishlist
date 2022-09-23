package com.mnazari2.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class itemAdapter(private val ITEMS: List<Item>)  : RecyclerView.Adapter<itemAdapter.ViewHolder>(){
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.
        val itemTextView: TextView
        val priceTextView: TextView
        val urlTextView: TextView
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
             itemTextView = itemView.findViewById(R.id.itemName)
             priceTextView = itemView.findViewById(R.id.itemPrice)
             urlTextView = itemView.findViewById(R.id.Store_url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.list_items, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val i = ITEMS.get(position)
        // Set item views based on views and data model
        holder.itemTextView.text = i.Name
        holder.priceTextView.text = i.Price
        holder.urlTextView.text= i.URL
    }

    override fun getItemCount(): Int {
        return ITEMS.size
    }
}