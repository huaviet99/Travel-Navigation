package com.vteam.travel_navigation.states

import android.util.SparseArray
import androidx.fragment.app.FragmentManager
import com.mapbox.maps.MapboxMap

abstract class AbstractState : IApplicationEvent {

    // region Abstract Methods

    abstract fun getStateName(): String

    // endregion Abstract Methods

    // region Application Event Override Methods

    override fun requestInitMapboxMap(mapboxMap: MapboxMap) {
        // Nothing to do
    }

    override fun requestScreenChange(
        fragmentManager: FragmentManager,
        sourceTag: String,
        destinationTag: String,
        arguments: SparseArray<Object>
    ) {
        // Nothing to do
    }

    override fun onInitMapboxMapFinished() {
        // Nothing to do
    }

    override fun onMapLoaded() {
        // Nothing to do
    }

    override fun onMapIdle() {
        // Nothing to do
    }

    // endregion Application Event Override Methods
}
