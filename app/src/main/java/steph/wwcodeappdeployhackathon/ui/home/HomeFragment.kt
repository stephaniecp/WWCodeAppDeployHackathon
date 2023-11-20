package steph.wwcodeappdeployhackathon.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.common.api.Status
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.android.libraries.places.api.net.FetchPlaceResponse
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import steph.wwcodeappdeployhackathon.R
import steph.wwcodeappdeployhackathon.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    var SCPLOGTAG = "SCP HomeF."

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        // Initialize the AutocompleteSupportFragment.
        val autocompleteFragment =
            childFragmentManager.findFragmentById(R.id.autocomplete_fragment)
                    as AutocompleteSupportFragment

        // Specify the types of place data to return.
        autocompleteFragment.setPlaceFields(listOf(Place.Field.ID, Place.Field.NAME))

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                // TODO: Get info about the selected place.
                Log.i(SCPLOGTAG, "Place: ${place.name}, ${place.id}")

                val placesClient = Places.createClient(requireActivity().applicationContext)
                placesClient.fetchPlace(FetchPlaceRequest.newInstance(place.id,listOf(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG)))
                    .addOnSuccessListener {
                        response : FetchPlaceResponse ->
                            val responsePlace = response.place
                            Log.i(SCPLOGTAG, "Response Place: ${responsePlace.name}, ${responsePlace.id}, ${responsePlace.latLng}")

                            val supportMapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
                            supportMapFragment!!.getMapAsync {
                                googleMap ->

                                    val markerOptions = MarkerOptions()
                                    markerOptions.position(responsePlace.latLng)
                                    markerOptions.title(responsePlace.name)

                                    googleMap.addMarker(markerOptions)
                                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(responsePlace.latLng, 5f))

                            }
                    }
            }

            override fun onError(status: Status) {
                // TODO: Handle the error.
                Log.i(SCPLOGTAG, "An error occurred: $status")
            }
        })



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}