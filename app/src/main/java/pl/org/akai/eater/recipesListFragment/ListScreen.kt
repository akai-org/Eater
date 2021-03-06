package pl.org.akai.eater

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.org.akai.eater.recipesListFragment.RecipeEntryData
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter
import pl.org.akai.eater.recipesListFragment.recipesList
import pl.org.akai.eater.ui.EaterTheme
import pl.org.akai.eater.ui.EaterTypography

@Composable
fun ListScreen(onItemClicked: (String) -> Unit, onAddItemClicked: () -> Unit) {
    Column() {
        Text(
            text = stringResource(R.string.recipes),
            style = EaterTypography.h1,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, bottom = 24.dp)
        )
        RecipesList(recipesList, onItemClicked, modifier = Modifier.weight(1f))
        Button(
            onClick = { onAddItemClicked() },
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
fun RecipesList(recipes: List<RecipeEntryData>, onItemClicked: (String) -> Unit, modifier: Modifier) {
    val listState = rememberLazyListState()
    SearchBar(listState = listState)
    LazyColumn(modifier = modifier, state = listState) {
        items(recipes) { recipe ->
            RecipeEntry(recipe, onItemClicked)
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SearchBar(listState: LazyListState) {
    val scrolledDown by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0
        }
    }
    AnimatedVisibility(
        visible = !scrolledDown,
        enter = slideInVertically() + expandVertically(),
        exit = slideOutVertically() + shrinkVertically()
    ) {
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
}


@Composable
fun RecipeEntry(recipeEntry: RecipeEntryData, onItemClicked: (String) -> Unit) {
    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .border(BorderStroke(1.dp, Color.Gray), RoundedCornerShape(8.dp))
            .clickable { onItemClicked(recipeEntry.id) }
    ) {
        Image(
            painter = rememberImagePainter(recipeEntry.imageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(96.dp)
                .align(Alignment.CenterVertically)
                .padding(16.dp)
                .background(Color.Gray)
        )
        Column() {
            Text(
                text = recipeEntry.title,
                maxLines = 1,
                style = EaterTypography.h2,
                modifier = Modifier
                    .padding(top = 8.dp)
            )

            Text(
                text = recipeEntry.description.toString(),
                maxLines =1,
                style = EaterTypography.body1,
                modifier = Modifier
                    .padding(top = 8.dp)
            )
        }
    }
}

@Preview("List Screen")
@Composable
fun PreviewListScreen() {
    EaterTheme {
        Scaffold { innerPadding ->
            ListScreen( onItemClicked = {}, onAddItemClicked = {})
        }
    }
}

@Preview("Recipe Entry")
@Composable
fun PrevievRecipe() {
    val recipe = RecipeEntryData(
        id = "1",
        title = "Spaghetti",
        description = "lorem ipsu mskafmp wopqenoiasdfnm ;asmkfokanmsf pqmwefpoqwk",
        imageUrl = null
    )
    EaterTheme {
        Surface {
            RecipeEntry(recipeEntry = recipe, onItemClicked = { })
        }
    }
}

