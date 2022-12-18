package com.vteam.travel_navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mapbox.maps.MapView
import com.mapbox.maps.plugin.scalebar.scalebar
import com.vteam.travel_navigation.R
import com.vteam.travel_navigation.states.StateManager
import com.vteam.travel_navigation.utils.LogUtil

class MapFragment : AbstractFragment() {
    companion object {
        val TAG = MapFragment::class.simpleName
    }

    // region Abstract Override Methods

    override fun getFragmentName(): String {
        return TAG ?: "MapFragment"
    }

    // endregion Abstract Override Methods

    // region Android Lifecycles

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogUtil.traceIn(TAG, "onCreateView")

        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        initializeMap(view)

        LogUtil.traceOut(TAG, "onCreateView")
        return view
    }

    // endregion Android Lifecycles

    // region Application Event Override Methods

    override fun onMapLoaded() {
        LogUtil.traceIn(TAG, "onMapLoaded")

        LogUtil.traceOut(TAG, "onMapLoaded")
    }

    // endregion Application Event Override Methods

    // region Private Methods

    private fun initializeMap(fragmentView: View) {
        LogUtil.traceIn(TAG, "initializeMap")

        val mapView = fragmentView.findViewById<MapView>(R.id.mapView)
        StateManager.requestInitMapboxMap(mapView.getMapboxMap())
        mapView.scalebar.enabled = false
        LogUtil.traceOut(TAG, "initializeMap")
    }

    // endregion Private Methods
}
