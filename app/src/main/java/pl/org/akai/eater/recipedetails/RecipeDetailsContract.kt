package pl.org.akai.eater.recipedetails

import pl.org.akai.eater.base.UiEffect
import pl.org.akai.eater.base.UiEvent
import pl.org.akai.eater.base.UiState

interface RecipeDetailsContract {
    sealed class Effect : UiEffect {
        object NavigateBack : Effect()
        object NavigateToEdit : Effect()
        data class FetchingError(val error: Throwable) : Effect()
    }

    sealed class Event : UiEvent {
        object OnReturnClick : Event()
        object OnEditClick : Event()
    }

    data class State(
        val title: String,
        val imageUrl: String,
        val description: String,
        val ingredients: List<Ingredient>
    ) : UiState {
        companion object {
            val empty = State("", "", "", emptyList())
        }
    }
}