package castelles.com.github.iaraapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import castelles.com.github.iaraapp.model.Category
import castelles.com.github.iaraapp.model.Place
import castelles.com.github.iaraapp.ui.adapter.CategoryAdapter
import castelles.com.github.iaraapp.ui.adapter.HomeMainAdapter
import castelles.com.github.iaraapp.viewmodel.UserViewModel
import castelles.com.github.api.model.UserResponse
import castelles.com.github.api.utils.ErrorHandler
import castelles.com.github.api.utils.NetworkFetcher
import castelles.com.github.iaraapp.R
import castelles.com.github.iaraapp.databinding.FragmentHomeBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment: Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: UserViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = with(FragmentHomeBinding.inflate(inflater)) {
        lifecycleOwner = viewLifecycleOwner
        binding = this
        viewModel = this@HomeFragment.viewModel
        root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        loadRecyclers()
    }

    private fun bindViewModel() {
        viewModel.apply {
            userFetcher.onEach { state ->
                when ( val handler = state?.handler) {
                    is NetworkFetcher.Loading -> {}
                    is NetworkFetcher.Success -> doSomethingWithData(handler.result)
                    is NetworkFetcher.Error -> doSomethingWithError(handler.error)
                    else -> {}
                }
            }.launchIn(MainScope())
        }
    }

    private fun doSomethingWithData(result: UserResponse?) {
        // TODO ()
    }

    private fun doSomethingWithError(error: ErrorHandler) {
        // TODO ()
    }

    private fun loadRecyclers() {
        val list = listOf<Place>(
            Place(
                "1234",
                "Cachoeira pedra furada",
                ResourcesCompat.getDrawable(requireContext().resources, R.drawable.img_pedra_furada, null)!!

            ),
            Place(
                "1235",
                "Cachoeira pedra furada 1",
                ResourcesCompat.getDrawable(requireContext().resources, R.drawable.img_pedra_furada, null)!!
            ),
            Place(
                "1236",
                "Cachoeira pedra furada 2",
                ResourcesCompat.getDrawable(requireContext().resources, R.drawable.img_pedra_furada, null)!!

            ),
        )
        val adapt = HomeMainAdapter {
            throw RuntimeException("Test crash: Main Recycler")
        }.also { it.submitList(list) }
        binding.rcvHome.apply {
            layoutManager = LinearLayoutManager(requireContext(), HORIZONTAL, false)
            this.adapter = adapt
        }

        val listCategory = listOf(
            Category(
                "123",
                ResourcesCompat.getDrawable(requireContext().resources, R.drawable.ic_water, null)!!,
                "Cachoeiras",
            ),
            Category(
                "133",
                ResourcesCompat.getDrawable(requireContext().resources, R.drawable.ic_water, null)!!,
                "Teatros",
            ),
            Category(
                "12344",
                ResourcesCompat.getDrawable(requireContext().resources, R.drawable.ic_water, null)!!,
                "Museus",
            ),
            Category(
                "123442",
                ResourcesCompat.getDrawable(requireContext().resources, R.drawable.ic_water, null)!!,
                "Flutuantes",
            ),
            Category(
                "123443422",
                ResourcesCompat.getDrawable(requireContext().resources, R.drawable.ic_water, null)!!,
                "Eventos culturais",
            ),
            Category(
                "1234434342",
                ResourcesCompat.getDrawable(requireContext().resources, R.drawable.ic_water, null)!!,
                "Casas noturnas",
            )
        )
        val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        divider.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.standard_divider)!!)
        val adatCategories = CategoryAdapter {
            throw RuntimeException("Test crash: categories Recycler")

        }.also { it.submitList(listCategory) }
        binding.rcvCategory.apply {
            layoutManager = LinearLayoutManager(requireContext(), VERTICAL, false)
            addItemDecoration(divider)
            this.adapter = adatCategories
        }
    }

}