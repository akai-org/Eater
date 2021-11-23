package pl.org.akai.eater.recipesListFragment

data class RecipeEntryData(
    val id: String,
    val title: String,
    val description: String?,
    val imageUrl: String?
)

val recipesList = listOf<RecipeEntryData>(
    RecipeEntryData(
        "1",
        "Spaghetti",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        "https://naszprzepis.pl/wp-content/uploads/2019/09/spaghetti_bolognase_land.jpg"
    ),
    RecipeEntryData(
        "2",
        "Spaghetti",
        "Lorem ipsum dolor sit  ",
        "https://images.aws.nestle.recipes/resized/a85b66e33f537f17d981da4d82958b4c_spaghetti_bolognese_944_531.jpg"
    ),
    RecipeEntryData(
        "3",
        "Spaghetti",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        "https://naszprzepis.pl/wp-content/uploads/2019/09/spaghetti_bolognase_land.jpg"
    ),
    RecipeEntryData(
        "4",
        "Spaghetti",
        "",
        ""
    ),
    RecipeEntryData(
        "5",
        "Spaghetti",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        "https://naszprzepis.pl/wp-content/uploads/2019/09/spaghetti_bolognase_land.jpg"
    ),RecipeEntryData(
        "1",
        "Spaghetti",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        "https://naszprzepis.pl/wp-content/uploads/2019/09/spaghetti_bolognase_land.jpg"
    ),
    RecipeEntryData(
        "2",
        "Spaghetti",
        "Lorem ipsum dolor sit  ",
        "https://images.aws.nestle.recipes/resized/a85b66e33f537f17d981da4d82958b4c_spaghetti_bolognese_944_531.jpg"
    ),
    RecipeEntryData(
        "3",
        "Spaghetti",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        "https://naszprzepis.pl/wp-content/uploads/2019/09/spaghetti_bolognase_land.jpg"
    ),
    RecipeEntryData(
        "4",
        "Spaghetti",
        "",
        ""
    ),
    RecipeEntryData(
        "5",
        "Spaghetti",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        "https://naszprzepis.pl/wp-content/uploads/2019/09/spaghetti_bolognase_land.jpg"
    ),
)
