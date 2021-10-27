package pl.org.akai.eater.fragments.recipeList

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import pl.org.akai.eater.data.ItemRecipeEntry
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor() : ViewModel() {

    private val _recipesList = MutableStateFlow(listOf<ItemRecipeEntry>())
    val recipesList: StateFlow<List<ItemRecipeEntry>> get() = _recipesList

}