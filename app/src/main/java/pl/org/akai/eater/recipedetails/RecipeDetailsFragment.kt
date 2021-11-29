package pl.org.akai.eater.recipedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pl.org.akai.eater.R

class RecipeDetailsFragment : Fragment() {
    private val viewModel: RecipeDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.effect.onEach { Toast.makeText(requireContext(), "${when(it) {
            is RecipeDetailsContract.Effect.FetchingError -> "ERROR"
            RecipeDetailsContract.Effect.NavigateBack -> "BACK"
            RecipeDetailsContract.Effect.NavigateToEdit -> "EDIT"
        }} EFEKT ZOSTAL KLIKNIETY", Toast.LENGTH_SHORT).show() }.launchIn(lifecycleScope)

        return ComposeView(requireContext()).apply {
            id = R.id.recipe_details_fragment
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            setContent {
                RecipeDetailsScreen(
                    viewModel.uiState.collectAsState().value
                ) { event ->
                    when (event) {
                        RecipeDetailsNavigation.Back -> viewModel.handleEvent(RecipeDetailsContract.Event.OnReturnClick)
                        RecipeDetailsNavigation.Edit -> viewModel.handleEvent(RecipeDetailsContract.Event.OnEditClick)
                    }
                }
            }
        }
    }
}