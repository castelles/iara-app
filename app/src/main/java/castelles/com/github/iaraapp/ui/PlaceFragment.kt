package castelles.com.github.iaraapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import castelles.com.github.iaraapp.R
import castelles.com.github.iaraapp.databinding.FragmentPlaceBinding
import castelles.com.github.iaraapp.ui.PlaceDetailsDialog.Companion.TAG
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds


class PlaceFragment: Fragment(){

    private lateinit var binding: FragmentPlaceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapsInitializer.initialize(requireContext(), MapsInitializer.Renderer.LATEST) {
            //println(it.name)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = with(FragmentPlaceBinding.inflate(inflater)) {
        lifecycleOwner = viewLifecycleOwner
        binding = this
        root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMap()
        binding.txvKnowMore.setOnClickListener {
            val dialog = PlaceDetailsDialog()
            dialog.show(childFragmentManager, TAG)
        }
    }

    private fun setupMap() {
        val map = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        map.getMapAsync {
            val latLg = LatLng(-1.9950448626851525, -59.54619938274565)
            it.addMarker(
                MarkerOptions()
                    .position(latLg)
                    .title("Cachoeira pedra furada")
            )
            it.uiSettings.setAllGesturesEnabled(false)
            it.redirectMapCamera(latLg)
        }
    }

    private fun GoogleMap.redirectMapCamera(latLg: LatLng) {
        try {
            MainScope().launch {
                delay(2.seconds)
                val cameraPosition = CameraPosition.Builder()
                    .target(latLg).zoom(12f).build()

                animateCamera(
                    CameraUpdateFactory
                        .newCameraPosition(cameraPosition)
                )
            }
        } catch (_: Exception) { }
    }

}