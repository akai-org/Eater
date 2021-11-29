package pl.org.akai.eater.recipedetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import coil.compose.rememberImagePainter
import pl.org.akai.eater.R
import pl.org.akai.eater.ui.theme.EaterTheme

@Composable
fun RecipeDetailsScreen(state: RecipeDetailsContract.State, onNavigate: (RecipeDetailsNavigation) -> Unit) {

    EaterTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
        ) {
            RecipeDetails(
                state = state,
                onNavigate = onNavigate,
                modifier = Modifier.padding(it)
            )
        }
    }
}

@Composable
private fun RecipeDetails(
    state: RecipeDetailsContract.State,
    onNavigate: (RecipeDetailsNavigation) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .padding(horizontal = 32.dp)
            .fillMaxWidth()
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        Recipe(state)
        NavigationButtons(
            onNavigateBack = { onNavigate(RecipeDetailsNavigation.Back) },
            onNavigateEdit = { onNavigate(RecipeDetailsNavigation.Edit) })
    }
}

enum class RecipeDetailsNavigation {
    Back, Edit
}

@Composable
private fun NavigationButtons(
    onNavigateBack: () -> Unit,
    onNavigateEdit: () -> Unit,
) {
    Row(
        Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = onNavigateBack, colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.error
            ),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(text = "Cofnij")
        }
        Button(
            onClick = onNavigateEdit, modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(text = "Edytuj")
        }
    }
}

@Composable
private fun Recipe(state: RecipeDetailsContract.State) {
    Column {
        RecipeTitle(state.title)
        RecipeImage(state.imageUrl)
        RecipeDescription(state.description)
        RecipeIngredients(state.ingredients)
    }
}

@Composable
private fun RecipeIngredients(ingredients: List<Ingredient>) {
    Text(
        text = "Składniki (na 1 porcję)",
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(vertical = 8.dp)
    )
    ingredients.forEach {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = it.name)
            Text(text = "${it.quantity} ${it.unit}")
        }
    }
}

@Composable
private fun RecipeDescription(description: String) {
    Text(
        text = description,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
private fun RecipeImage(imageUrl: String) {
    Image(
        painter = rememberImagePainter(data = imageUrl,
            builder = {
                placeholder(R.drawable.ic_launcher_background)
                crossfade(true)
            }),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .height(300.dp)
    )
}

@Composable
private fun RecipeTitle(title:String) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.h4,
        modifier = Modifier.padding(vertical = 16.dp)
    )
}

@Preview
@Composable
fun PreviewRecipeDetailsScreen() {
    RecipeDetailsScreen(
        RecipeDetailsContract.State(
            title = "Domowa Pizza",
            imageUrl = "https://www.mojegotowanie.pl/media/cache/default_view/uploads/media/recipe/0002/19/pizza-z-salami.jpeg",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but al",
            ingredients = listOf(
                Ingredient("Marchew", 1f, "kg"),
                Ingredient("Marchew", 1f, "kg"),
                Ingredient("Marchew", 1f, "kg"),
                Ingredient("Marchew", 1f, "kg"),
                Ingredient("Marchew", 1f, "kg"),
            )
        )
    ) {}
}