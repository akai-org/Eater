package pl.org.akai.eater.adapters

import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.ui.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.org.akai.eater.R
import pl.org.akai.eater.data.ItemRecipeEntry

class RecipesRvAdapter (
    val recipes: ArrayList<ItemRecipeEntry>
        ) : RecyclerView.Adapter<RecipesRvAdapter.RecipesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe_entry, parent, false)
        return RecipesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.titleTextView.text = recipe.title
        holder.descriptionTextView.text = recipe.description?.take(50)
        Glide.with(holder.imageView.context)
            .load(recipe.imageUrl)
            .placeholder(R.drawable.ic_placeholder_view_vector)
            .override(200, 200)
            .centerCrop()
            .into(holder.imageView)
    }

    override fun getItemCount() = recipes.size

    class RecipesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView = itemView.findViewById<TextView>(R.id.recipeTitleTextView)
        val descriptionTextView = itemView.findViewById<TextView>(R.id.recipeDescriptionTextView)
        val imageView = itemView.findViewById<ImageView>(R.id.recipeImageView)
    }
}