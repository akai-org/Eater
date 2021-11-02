package pl.org.akai.eater.recipedetails

data class RecipeDetailsState(
    val title: String,
    val imageUrl: String,
    val description: String,
    val ingredients: List<Ingredient>
)