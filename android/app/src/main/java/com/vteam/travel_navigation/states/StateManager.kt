package com.vteam.travel_navigation.states

import android.util.SparseArray
import androidx.fragment.app.FragmentManager
import com.mapbox.maps.MapboxMap
import com.vteam.travel_navigation.fragments.AbstractFragment
import com.vteam.travel_navigation.utils.LogUtil

object StateManager : IApplicationEvent {
    private val TAG = StateManager::class.simpleName

    // region Member Variables

    private val mStateManagerLockObject: Object = Object()
    private var mFunctionState: AbstractState? = NotInitializeState()
    private var mFragmentEventListeners: MutableList<AbstractFragment>? = mutableListOf()

    // endregion Member Variables

    // region Application Event Override Methods

    override fun requestInitMapboxMap(mapboxMap: MapboxMap) {
        LogUtil.traceIn(TAG, "requestInitMapView")

        mFunctionState?.requestInitMapboxMap(mapboxMap)

        LogUtil.traceOut(TAG, "requestInitMapView")
    }

    override fun onInitMapboxMapFinished() {
        LogUtil.traceIn(TAG, "onInitMapboxMapFinished")

        mFunctionState?.onInitMapboxMapFinished()

        LogUtil.traceOut(TAG, "onInitMapboxMapFinished")
    }

    override fun onMapLoaded() {
        LogUtil.traceIn(TAG, "onMapLoaded")

        mFunctionState?.onMapLoaded()

        LogUtil.traceOut(TAG, "onMapLoaded")
    }

    override fun onMapIdle() {
        LogUtil.traceIn(TAG, "onMapIdle")

        mFunctionState?.onMapIdle()

        LogUtil.traceOut(TAG, "onMapIdle")
    }

    override fun requestScreenChange(
        fragmentManager: FragmentManager,
        sourceTag: String,
        destinationTag: String,
        arguments: SparseArray<Object>
    ) {
        LogUtil.traceIn(
            TAG,
            "requestScreenChange source=$sourceTag destination=$destinationTag"
        )

        synchronized(mStateManagerLockObject) {
            mFunctionState?.requestScreenChange(
                fragmentManager,
                sourceTag,
                destinationTag,
                arguments
            )
        }

        LogUtil.traceOut(TAG, "requestScreenChange")
    }

    // endregion Application Event Override Methods

    // region Public Methods

    fun setFunctionState(functionState: AbstractState) {
        LogUtil.traceIn(
            TAG,
            "setFunctionState from ${mFunctionState?.getStateName()} to ${functionState.getStateName()}"
        )

        mFunctionState = functionState

        LogUtil.traceOut(TAG, "setFunctionState")
    }

    fun getFunctionState(): AbstractState? {
        LogUtil.traceIn(TAG, "getFunctionState ${mFunctionState?.getStateName()}")
        return mFunctionState
        LogUtil.traceOut(TAG, "getFunctionState")
    }

    fun addFragmentEventListener(abstractFragment: AbstractFragment) {
        LogUtil.traceIn(TAG, "addFragmentEventListener")

        mFragmentEventListeners?.let { notNullFragmentEventListeners ->
            if (!notNullFragmentEventListeners.contains(abstractFragment)) {
                notNullFragmentEventListeners.add(abstractFragment)
            }
        }

        LogUtil.traceOut(TAG, "addFragmentEventListener")
    }

    fun removeFragmentEventListener(abstractFragment: AbstractFragment) {
        LogUtil.traceIn(TAG, "removeFragmentEventListener")
        mFragmentEventListeners?.remove(abstractFragment)
        LogUtil.traceOut(TAG, "removeFragmentEventListener")
    }

    fun clearFragmentEventListeners() {
        LogUtil.traceIn(TAG, "clearFragmentEventListeners")
        mFragmentEventListeners?.clear()
        LogUtil.traceOut(TAG, "clearFragmentEventListeners")
    }

    fun getFragmentEventListeners(): MutableList<AbstractFragment>? {
        LogUtil.traceIn(TAG, "getFragmentEventListeners")
        return mFragmentEventListeners
        LogUtil.traceOut(TAG, "getFragmentEventListeners")
    }

    // endregion Public Methods
}
