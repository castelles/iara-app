package castelles.com.github.iaraapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import castelles.com.github.iaraapp.R
import castelles.com.github.iaraapp.databinding.FragmentPlaceListBinding
import castelles.com.github.iaraapp.model.Place
import castelles.com.github.iaraapp.ui.adapter.PlaceListAdapter

class PlaceListFragment: Fragment() {

    private lateinit var binding: FragmentPlaceListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = with(FragmentPlaceListBinding.inflate(inflater)) {
        lifecycleOwner = viewLifecycleOwner
        binding = this
        root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadRecycler()
        binding.incldActionBar.imvBack.setOnClickListener { findNavController().popBackStack() }
    }

    private fun loadRecycler() {
        val list = listOf<Place>(
            Place(
                "1234",
                "Cachoeira pedra furada",
                ResourcesCompat.getDrawable(requireContext().resources, R.drawable.img_pedra_furada, null)!!

            ),
            Place(
                "1235",
                "Gruta da Judeia",
                ResourcesCompat.getDrawable(requireContext().resources, R.drawable.imv_gruta, null)!!
            ),
            Place(
                "1236",
                "Cachoeira de Iracema",
                ResourcesCompat.getDrawable(requireContext().resources, R.drawable.imv_iracema, null)!!
            ),
        )
        val adapt = PlaceListAdapter {
            findNavController().navigate(R.id.action_places_to_place)
        }.also { it.submitList(list) }
        binding.rcvPlaces.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = adapt
        }
    }

}