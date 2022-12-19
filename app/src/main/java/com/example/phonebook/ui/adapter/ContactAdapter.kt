package com.example.phonebook.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.phonebook.R
import com.example.phonebook.data.model.Contact
import com.example.phonebook.ui.HomeFragment
import com.example.phonebook.ui.HomeFragmentDirections

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ItemViewHolder>() {
    private var dataset = listOf<Contact>()

    fun submitList(newList: List<Contact>) {
        dataset = newList
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.item_name)
        var number: TextView = itemView.findViewById(R.id.item_number)
        var card: CardView = itemView.findViewById(R.id.contact_card)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.name.text = item.name
        holder.number.text = item.number
        holder.card.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(HomeFragmentDirections.actionHomeFragmentToEditFragment(item.id))
        }
    }

    override fun getItemCount(): Int {
    return dataset.size
    }

}