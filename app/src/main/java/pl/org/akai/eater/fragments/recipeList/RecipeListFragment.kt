package pl.org.akai.eater.fragments.recipeList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.recipes_list_fragment.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import pl.org.akai.eater.R
import pl.org.akai.eater.adapters.RecipesRvAdapter
import pl.org.akai.eater.data.ItemRecipeEntry

@AndroidEntryPoint
class RecipeListFragment : Fragment(R.layout.recipes_list_fragment) {

    private val viewModel: RecipeListViewModel by viewModels()
    val adapter by lazy {
        RecipesRvAdapter(arrayListOf())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()
        collectFlow()
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
        recipeListRecycleView.layoutManager = LinearLayoutManager(requireContext())
        recipeListRecycleView.adapter = adapter
        adapter.recipes.add(ItemRecipeEntry("Spaghetti",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                "https://naszprzepis.pl/wp-content/uploads/2019/09/spaghetti_bolognase_land.jpg"
        ))
        adapter.recipes.add(ItemRecipeEntry("Spaghetti",
            "Lorem ipsum dolor sit  ",
            "https://images.aws.nestle.recipes/resized/a85b66e33f537f17d981da4d82958b4c_spaghetti_bolognese_944_531.jpg"
        ))
        adapter.recipes.add(ItemRecipeEntry("Spaghetti",
            "",
            "https://ocdn.eu/pulscms-transforms/1/iGxk9kpTURBXy8wYTQ2YmY1M2NlYTVlMTM2NWU2MjdiMmRjODExZTUxZi5qcGeTlQMAH80D6M0CMpMJpjA2NTMzYgaTBc0EsM0CdoGhMAE/spaghetti-puttanesca.jpg"
        ))
        adapter.recipes.add(ItemRecipeEntry("Spaghetti",
            "",
            ""
        ))
        adapter.recipes.add(ItemRecipeEntry("Spaghetti",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "https://static.gotujmy.pl/VIDEO_BIG/spaghetti-bolognese-348828.jpg"
        ))
        adapter.recipes.add(ItemRecipeEntry("Spaghetti",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "https://ocdn.eu/pulscms-transforms/1/iGxk9kpTURBXy8wYTQ2YmY1M2NlYTVlMTM2NWU2MjdiMmRjODExZTUxZi5qcGeTlQMAH80D6M0CMpMJpjA2NTMzYgaTBc0EsM0CdoGhMAE/spaghetti-puttanesca.jpg"
        ))
        adapter.recipes.add(ItemRecipeEntry("Spaghetti",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "https://ocdn.eu/pulscms-transforms/1/iGxk9kpTURBXy8wYTQ2YmY1M2NlYTVlMTM2NWU2MjdiMmRjODExZTUxZi5qcGeTlQMAH80D6M0CMpMJpjA2NTMzYgaTBc0EsM0CdoGhMAE/spaghetti-puttanesca.jpg"
        ))
        adapter.recipes.add(ItemRecipeEntry("Spaghetti",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "https://ocdn.eu/pulscms-transforms/1/iGxk9kpTURBXy8wYTQ2YmY1M2NlYTVlMTM2NWU2MjdiMmRjODExZTUxZi5qcGeTlQMAH80D6M0CMpMJpjA2NTMzYgaTBc0EsM0CdoGhMAE/spaghetti-puttanesca.jpg"
        ))
        adapter.recipes.add(ItemRecipeEntry("Spaghetti",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "https://ocdn.eu/pulscms-transforms/1/iGxk9kpTURBXy8wYTQ2YmY1M2NlYTVlMTM2NWU2MjdiMmRjODExZTUxZi5qcGeTlQMAH80D6M0CMpMJpjA2NTMzYgaTBc0EsM0CdoGhMAE/spaghetti-puttanesca.jpg"
        ))
        adapter.recipes.add(ItemRecipeEntry("Spaghetti",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "https://ocdn.eu/pulscms-transforms/1/iGxk9kpTURBXy8wYTQ2YmY1M2NlYTVlMTM2NWU2MjdiMmRjODExZTUxZi5qcGeTlQMAH80D6M0CMpMJpjA2NTMzYgaTBc0EsM0CdoGhMAE/spaghetti-puttanesca.jpg"
        ))
        adapter.recipes.add(ItemRecipeEntry("Spaghetti",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
            "https://ocdn.eu/pulscms-transforms/1/iGxk9kpTURBXy8wYTQ2YmY1M2NlYTVlMTM2NWU2MjdiMmRjODExZTUxZi5qcGeTlQMAH80D6M0CMpMJpjA2NTMzYgaTBc0EsM0CdoGhMAE/spaghetti-puttanesca.jpg"
        ))
    }
}