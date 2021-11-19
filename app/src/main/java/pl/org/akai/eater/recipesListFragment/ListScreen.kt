package pl.org.akai.eater

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import pl.org.akai.eater.recipesListFragment.RecipeEntryData

@Composable
fun ListScreen(onItemClicked: (String) -> Unit, onAddItemClicked: () -> Unit) {
    Column() {
        Text(
            text = stringResource(R.string.recipes),
            //Todo change MaterialTheme when our Theme is created
            style = MaterialTheme.typography.h1,
            fontSize = 40.sp,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, bottom = 24.dp)
        )
        SearchBar()
        RecipesList(recipesList, onItemClicked, modifier = Modifier.weight(1f))
        Button(
            onClick = { onAddItemClicked },
            modifier = Modifier
                .padding(bottom = 16.dp)
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.add_recipe))
        }
    }
}

@Composable
fun SearchBar() {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .border(BorderStroke(1.dp, Color.Gray), RoundedCornerShape(8.dp))
    ) {
        TextField(
            value = "Search recipe...",
            onValueChange = { /* TODO implement search bar*/ },
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth()
        )
    }
}

@Composable
fun RecipesList(recipes: List<RecipeEntryData>, onItemClicked: (String) -> Unit, modifier: Modifier) {
    LazyColumn(modifier) {
        items(recipes) { recipe ->
            RecipeEntry(recipe, onItemClicked)
        }
    }
}

@Composable
fun RecipeEntry(recipeEntry: RecipeEntryData, onItemClicked: (String) -> Unit) {
    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .border(BorderStroke(1.dp, Color.Gray), RoundedCornerShape(8.dp))
            .clickable { onItemClicked }
    ) {
        Image(
            painter = rememberImagePainter(recipeEntry.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .size(128.dp)
                .align(Alignment.CenterVertically)
                .padding(18.dp)
                .background(Color.Gray)
        )
        Column() {
            Text(
                text = recipeEntry.title,
                maxLines =1,
                /* TODO change MaterialTheme */
                style = MaterialTheme.typography.h2,
                fontSize = 33.sp,
                modifier = Modifier
                    .padding(16.dp)
            )

            Text(
                text = recipeEntry.description.toString(),
                maxLines =1,
                /* TODO change MaterialTheme */
                style = MaterialTheme.typography.body1,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}

@Preview("List Screen")
@Composable
fun PreviewListScreen() {
    MaterialTheme {
        Scaffold { innerPadding ->
            ListScreen( onItemClicked = {}, onAddItemClicked = {})
        }
    }
}

@Preview("Recipe Entry")
@Composable
fun PrevievRecipe() {
    val recipe = RecipeEntryData(
        title = "Spaghetti",
        description = "lorem ipsu mskafmp wopqenoiasdfnm ;asmkfokanmsf pqmwefpoqwk",
        imageUrl = null
    )
    MaterialTheme {
        Surface {
            RecipeEntry(recipeEntry = recipe, onItemClicked = { })
        }
    }
}

val recipesList = listOf<RecipeEntryData>(
    RecipeEntryData(
        "Spaghetti",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        "https://naszprzepis.pl/wp-content/uploads/2019/09/spaghetti_bolognase_land.jpg"
        ),
    RecipeEntryData(
        "Spaghetti",
        "Lorem ipsum dolor sit  ",
        "https://images.aws.nestle.recipes/resized/a85b66e33f537f17d981da4d82958b4c_spaghetti_bolognese_944_531.jpg"
    ),
    RecipeEntryData(
        "Spaghetti",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        "https://naszprzepis.pl/wp-content/uploads/2019/09/spaghetti_bolognase_land.jpg"
    ),
    RecipeEntryData(
        "Spaghetti",
        "",
        ""
    ),
    RecipeEntryData(
        "Spaghetti",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        "https://naszprzepis.pl/wp-content/uploads/2019/09/spaghetti_bolognase_land.jpg"
    ),
)