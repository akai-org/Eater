package pl.org.akai.eater.navigation

enum class EaterScreen {

    RecipesList;

    companion object {
        fun fromRoute(route: String?): EaterScreen =
            when (route?.substringBefore("/")) {
                RecipesList.name -> RecipesList
                null -> RecipesList
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}