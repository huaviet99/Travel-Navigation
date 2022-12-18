package com.vteam.travel_navigation.states

import com.mapbox.maps.MapboxMap
import com.vteam.travel_navigation.mapbox.MapManager
import com.vteam.travel_navigation.utils.LogUtil

class NotInitializeState : AbstractState() {
    companion object {
        private val TAG = NotInitializeState::class.simpleName
    }

    // region Abstract Override Method

    override fun getStateName(): String {
        return TAG ?: "NotInitializeState"
    }

    // endregion Abstract Override Method

    // region Application Event Override Methods

    override fun requestInitMapboxMap(mapboxMap: MapboxMap) {
        LogUtil.traceIn(TAG, "requestInitializeApplication")

        StateManager.setFunctionState(InitializingState())
        MapManager.initMapboxMap(mapboxMap)

        LogUtil.traceOut(TAG, "requestInitializeApplication")
    }

    // endregion Application Event Override Methods
}
