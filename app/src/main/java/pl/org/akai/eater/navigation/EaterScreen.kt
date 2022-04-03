package pl.org.akai.eater.navigation

enum class EaterScreen {

    RecipesList,
    AddRecipe,
    Login;

    companion object {
        fun fromRoute(route: String?): EaterScreen =
            when (route?.substringBefore("/")) {
                RecipesList.name -> RecipesList
                AddRecipe.name -> AddRecipe
                Login.name -> Login
                null -> RecipesList
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}