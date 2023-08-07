package castelles.com.github.iaraapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import castelles.com.github.iaraapp.R
import castelles.com.github.iaraapp.databinding.FragmentPlaceBinding
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class PlaceFragment: Fragment(){

    private lateinit var binding: FragmentPlaceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = with(FragmentPlaceBinding.inflate(inflater)) {
        MapsInitializer.initialize(requireContext(), MapsInitializer.Renderer.LATEST) {
            //println(it.name)
        }
        lifecycleOwner = viewLifecycleOwner
        binding = this
        root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMap()
    }

    private fun setupMap() {
        val map = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        map.getMapAsync {
            it.addMarker(
                MarkerOptions()
                    .position(LatLng(-1.9950448626851525, -59.54619938274565))
                    .title("Cachoeira pedra furada")
            )
        }
    }

}