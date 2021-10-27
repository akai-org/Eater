package pl.org.akai.eater.fragments.recipeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import pl.org.akai.eater.R
import pl.org.akai.eater.adapters.RecipesRvAdapter
import pl.org.akai.eater.data.ItemRecipeEntry
import pl.org.akai.eater.databinding.RecipesListFragmentBinding


@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    private val viewModel: RecipeListViewModel by viewModels()
    private val adapter = RecipesRvAdapter(arrayListOf())
    private var _binding: RecipesListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RecipesListFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()
        collectFlow()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun collectFlow() {
        lifecycleScope.launch {
            viewModel.recipesList.collect {
                adapter.recipes.addAll(it)
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun setupRecycleView() {
        binding.recipeListRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.recipeListRecycleView.adapter = adapter
        val recipes = loadRecipesFromJson()
        recipes.forEach {
            adapter.recipes.add(it)
        }
    }

    private fun readFileFromResources() : String {
        val jsonString: String
        jsonString = requireContext().resources
            .openRawResource(R.raw.recipes)
            .bufferedReader()
            .use { it.readText() }
        return jsonString
    }

    private fun loadRecipesFromJson() : List<ItemRecipeEntry> {
        val jsonString = readFileFromResources()
        val gson = Gson()
        val recipesListType = object : TypeToken<List<ItemRecipeEntry>>() {}.type
        val recipes: List<ItemRecipeEntry> = gson.fromJson(jsonString, recipesListType)

        return recipes
    }

}