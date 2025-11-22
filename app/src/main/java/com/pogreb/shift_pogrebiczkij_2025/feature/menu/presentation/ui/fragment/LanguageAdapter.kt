package com.pogreb.shift_pogrebiczkij_2025.feature.menu.presentation.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pogreb.shift_pogrebiczkij_2025.databinding.ItemLanguageBinding

class LanguageAdapter(
    private val options: List<Int>,
    private val onOptionSelected: (Int) -> Unit
) : RecyclerView.Adapter<LanguageAdapter.ViewHolder>() {

    private var selectedPosition = 0

    class ViewHolder(private val binding: ItemLanguageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(text: Int, isSelected: Boolean, onOptionSelected: (Int) -> Unit) {
            binding.title.setText(text)
            binding.radioButton.isChecked = isSelected

            binding.radioButton.setOnClickListener {
                onOptionSelected(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLanguageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(options[position], position == selectedPosition, onOptionSelected)
    }

    override fun getItemCount() = options.size

    fun setSelectedPosition(position: Int) {
        val previousPosition = selectedPosition
        selectedPosition = position
        notifyItemChanged(previousPosition)
        notifyItemChanged(selectedPosition)
    }
}