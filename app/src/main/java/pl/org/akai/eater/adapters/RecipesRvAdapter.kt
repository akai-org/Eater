package pl.org.akai.eater.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.org.akai.eater.R
import pl.org.akai.eater.data.ItemRecipeEntry
import pl.org.akai.eater.databinding.ItemRecipeEntryBinding

class RecipesRvAdapter (
    val recipes: ArrayList<ItemRecipeEntry>
        ) : ListAdapter<ItemRecipeEntry, RecipesRvAdapter.RecipesViewHolder>(RecipesListtDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val binding = ItemRecipeEntryBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipesViewHolder(binding)
    }
    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        val recipe = recipes[position]
        val binding = holder.binding
        binding.recipeTitleTextView.text = recipe.title
        binding.recipeDescriptionTextView.text = recipe.description
        Glide.with(binding.recipeImageView.context)
            .load(recipe.imageUrl)
            .placeholder(R.drawable.ic_placeholder_view_vector)
            .centerCrop()
            .into(binding.recipeImageView)
    }

    override fun getItemCount() = recipes.size

    class RecipesViewHolder(val binding: ItemRecipeEntryBinding) : RecyclerView.ViewHolder(binding.root)
}