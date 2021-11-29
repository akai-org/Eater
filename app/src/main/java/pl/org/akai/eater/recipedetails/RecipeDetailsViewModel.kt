package pl.org.akai.eater.recipedetails

import pl.org.akai.eater.base.BaseViewModel
import pl.org.akai.eater.recipedetails.RecipeDetailsContract.*

class RecipeDetailsViewModel : BaseViewModel<Event, State, Effect>() {
    override fun createInitialState(): State {
        return State.empty
    }

    override fun handleEvent(event: Event) {
        when (event) {
            Event.OnEditClick -> setEffect { Effect.NavigateToEdit }
            Event.OnReturnClick -> setEffect { Effect.NavigateBack }
        }
    }

    init {
        fetchDate()
    }

    private fun fetchDate() {
        setState {
            State(
                title = "Domowa Pizza",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/a/a3/Eq_it-na_pizza-margherita_sep2005_sml.jpg",
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but al",
                ingredients = listOf(
                    Ingredient("Marchew", 1f, "kg"),
                    Ingredient("Marchew", 1f, "kg"),
                    Ingredient("Marchew", 1f, "kg"),
                    Ingredient("Marchew", 1f, "kg"),
                    Ingredient("Marchew", 1f, "kg"),
                )
            )
        }
    }
}

