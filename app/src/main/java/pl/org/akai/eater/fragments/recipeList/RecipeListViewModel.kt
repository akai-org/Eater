package pl.org.akai.eater.fragments.recipeList

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import pl.org.akai.eater.data.ItemRecipeEntry
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor() : ViewModel() {

    val recipesList = MutableStateFlow(listOf<ItemRecipeEntry>())

    fun getRecipes(): List<ItemRecipeEntry> {
        return recipesList.value
    }
}