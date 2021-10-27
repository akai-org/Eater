package pl.org.akai.eater.adapters

import androidx.recyclerview.widget.DiffUtil
import pl.org.akai.eater.data.ItemRecipeEntry

class RecipesListtDiffCallback : DiffUtil.ItemCallback<ItemRecipeEntry>() {
    override fun areItemsTheSame(oldItem: ItemRecipeEntry, newItem: ItemRecipeEntry): Boolean {
        return oldItem.title == newItem.title && oldItem.description == newItem.description && oldItem.imageUrl == newItem.imageUrl
    }

    override fun areContentsTheSame(oldItem: ItemRecipeEntry, newItem: ItemRecipeEntry): Boolean {
        return  areItemsTheSame(oldItem, newItem)
    }

}
