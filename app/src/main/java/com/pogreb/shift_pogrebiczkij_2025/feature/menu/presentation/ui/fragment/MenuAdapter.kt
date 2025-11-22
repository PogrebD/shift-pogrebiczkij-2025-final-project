package com.pogreb.shift_pogrebiczkij_2025.feature.menu.presentation.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pogreb.shift_pogrebiczkij_2025.databinding.ItemMenuBinding
import com.pogreb.shift_pogrebiczkij_2025.feature.menu.presentation.entity.MenuItem

class MenuAdapter(
    private val items: List<MenuItem>
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuItem) {
            binding.title.setText(item.titleResId)
            binding.icon.setImageResource(item.iconResId)

            binding.root.setOnClickListener {
                item.action()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}