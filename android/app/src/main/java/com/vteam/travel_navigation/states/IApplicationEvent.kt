package com.vteam.travel_navigation.states

import android.util.SparseArray
import androidx.fragment.app.FragmentManager
import com.mapbox.maps.MapboxMap

interface IApplicationEvent {
    // region Request Method Interface

    fun requestInitMapboxMap(mapboxMap: MapboxMap)

    fun requestScreenChange(
        fragmentManager: FragmentManager,
        sourceTag: String,
        destinationTag: String,
        arguments: SparseArray<Object>
    )

    // endregion Request Method Interface

    // region Event Callbacks

    fun onInitMapboxMapFinished()

    fun onMapLoaded()

    fun onMapIdle()

    // endregion Event Callbacks
}
