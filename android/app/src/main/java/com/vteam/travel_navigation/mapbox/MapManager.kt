package com.vteam.travel_navigation.mapbox

import com.mapbox.maps.MapboxMap
import com.mapbox.maps.Style
import com.mapbox.maps.plugin.delegates.listeners.OnMapIdleListener
import com.mapbox.maps.plugin.delegates.listeners.OnMapLoadedListener
import com.vteam.travel_navigation.states.StateManager
import com.vteam.travel_navigation.utils.LogUtil

object MapManager {
    private val TAG = MapManager::class.simpleName

    // region Member Variables

    private var mMapboxMap: MapboxMap? = null

    // endregion Member Variables

    // region Public Methods

    fun initMapboxMap(mapboxMap: MapboxMap) {
        LogUtil.traceIn(TAG, "initMapboxMap")
        mMapboxMap = mapboxMap

        mMapboxMap?.let { notNullMapboxMap ->
            notNullMapboxMap.loadStyleUri(Style.LIGHT)
            notNullMapboxMap.addOnMapLoadedListener(onMapLoadedListener)
            notNullMapboxMap.addOnMapIdleListener(onMapIdleListener)
            StateManager.onInitMapboxMapFinished()
        }

        LogUtil.traceOut(TAG, "initMapboxMap")
    }

    // endregion Public Methods

    // region Mapbox SDK Listeners

    private val onMapLoadedListener = OnMapLoadedListener {
        StateManager.onMapLoaded()
    }

    private val onMapIdleListener = OnMapIdleListener {
        StateManager.onMapIdle()
    }

    // endregion Mapbox SDK Listeners
}
