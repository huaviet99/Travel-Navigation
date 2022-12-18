package com.vteam.travel_navigation.fragments

import android.os.Bundle
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.mapbox.maps.MapboxMap
import com.vteam.travel_navigation.R
import com.vteam.travel_navigation.states.IApplicationEvent
import com.vteam.travel_navigation.states.StateManager
import com.vteam.travel_navigation.utils.LogUtil

abstract class AbstractFragment : Fragment(), IApplicationEvent {
    companion object {
        private val TAG = AbstractFragment::class.simpleName
    }

    // region Abstract Methods

    abstract fun getFragmentName(): String

    // endregion Abstract Methods

    // region Android Lifecycles

    override fun onCreate(savedInstanceState: Bundle?) {
        LogUtil.traceIn(TAG, "onCreate")

        super.onCreate(savedInstanceState)

        LogUtil.traceOut(TAG, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogUtil.traceIn(TAG, "onCreateView")

        val view = super.onCreateView(inflater, container, savedInstanceState)

        LogUtil.traceOut(TAG, "onCreateView")
        return view
    }

    override fun onStart() {
        LogUtil.traceIn(TAG, "onStart")

        super.onStart()
        StateManager.addFragmentEventListener(this)

        LogUtil.traceOut(TAG, "onStart")
    }

    override fun onStop() {
        LogUtil.traceIn(TAG, "onStop")

        super.onStop()
        StateManager.removeFragmentEventListener(this)

        LogUtil.traceOut(TAG, "onStop")
    }

    override fun onDestroy() {
        LogUtil.traceIn(TAG, "onDestroy")

        super.onDestroy()
        StateManager.clearFragmentEventListeners()

        LogUtil.traceOut(TAG, "onDestroy")
    }

    // endregion Android Lifecycle

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

    // endregion Application Override Event Methods

    // region Common Methods

    protected fun requestScreenChange(
        fragmentManager: FragmentManager,
        destinationTag: String,
        arguments: SparseArray<Object>
    ) {
        LogUtil.traceIn(
            TAG,
            "requestScreenChange source=${getFragmentName()} destination=$destinationTag"
        )
        activity?.let { notNullActivity ->
            notNullActivity.runOnUiThread {
                StateManager.requestScreenChange(
                    fragmentManager,
                    getFragmentName(),
                    destinationTag,
                    arguments
                )
            }
        }
        LogUtil.traceOut(TAG, "requestScreenChange")
    }

    fun removeSelfViewFromFeaturesLayer() {
        LogUtil.traceIn(TAG, "removeSelfViewFromFeaturesLayer")
        view?.let { notNullView ->
            var viewParent = notNullView.parent
            while (null != viewParent) {
                if (viewParent is ViewGroup) {
                    val id = (viewParent as? ViewGroup)?.id
                    if (R.id.fl_third_layer_features == id) {
                        (viewParent as? ViewGroup)?.removeView(view)
                        break
                    }
                }
                viewParent = viewParent.parent
            }
        }
        LogUtil.traceOut(TAG, "removeSelfViewFromFeaturesLayer")
    }

    // endregion Common Method
}
