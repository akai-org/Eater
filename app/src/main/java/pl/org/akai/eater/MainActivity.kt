package pl.org.akai.eater

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pl.org.akai.eater.authScreen.AuthScreen
import pl.org.akai.eater.viewmodel.AuthViewModel
import pl.org.akai.eater.navigation.EaterScreen
import pl.org.akai.eater.ui.EaterTheme
import pl.org.akai.eater.util.NullArgumentException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EaterApp()
        }
    }
}

@Composable
fun EaterApp() {
    EaterTheme {
        val allScreens = EaterScreen.values().toList()
        val navController = rememberNavController()
        val backstackEntry = navController.currentBackStackEntryAsState()
        val currentScreen = EaterScreen.fromRoute(backstackEntry.value?.destination?.route)

        Scaffold { innerPadding ->
            EaterNavHost(
                navController = navController,
                Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun EaterNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = EaterScreen.Login.name,
        modifier = modifier
    ) {
        composable(EaterScreen.Login.name) {
            AuthScreen(
                viewModel = viewModel(),
                onUserLoggedIn = { navigateToRecipesList(navController) }
                )
        }
        composable(EaterScreen.RecipesList.name) {
            ListScreen(
                onItemClicked = { recipeId ->
                    navigateToRecipeDetails(navController, recipeId)
                },
                onAddItemClicked = { navigateToAddRecipe(navController) }
            )
        }
        composable(
            route = "${EaterScreen.RecipesList.name}/{recipeId}",
            arguments = listOf(
                navArgument("recipeId") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val recipeId = entry.arguments?.getString("recipeId")
            recipeId?.let { DetailsScreen(it)} ?: throw NullArgumentException("recipeId")
            DetailsScreen(recipeId)
        }
        composable(route = EaterScreen.AddRecipe.name) {
            AddRecipeScreen()
        }
    }
}

private fun navigateToRecipesList(navController: NavHostController) =
    navController.navigate("${EaterScreen.RecipesList.name}")

private fun navigateToRecipeDetails(navController: NavHostController, recipeId: String) =
    navController.navigate("${EaterScreen.RecipesList.name}/$recipeId")

private fun navigateToAddRecipe(navController: NavHostController) =
    navController.navigate(EaterScreen.AddRecipe.name)