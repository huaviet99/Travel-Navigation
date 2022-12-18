package com.vteam.travel_navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vteam.travel_navigation.R
import com.vteam.travel_navigation.utils.LogUtil

class TravelNavigationFragment : Fragment() {
    companion object {
        private val TAG = TravelNavigationFragment::class.simpleName
    }

    // region Android Lifecycles

    override fun onCreate(savedInstanceState: Bundle?) {
        LogUtil.traceIn(TAG, "onCreate")

        super.onCreate(savedInstanceState)
        initializeTravelNavigationApp()

        LogUtil.traceOut(TAG, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogUtil.traceIn(TAG, "onCreateView")

        val view = inflater.inflate(R.layout.fragment_travel_navigation, container, false)

        LogUtil.traceOut(TAG, "onCreateView")
        return view
    }

    // endregion Android Lifecycles

    // region Private Methods

    private fun initializeTravelNavigationApp() {
        LogUtil.traceIn(TAG, "initializeTravelNavigationApp")
        commitFragmentLayers()
        LogUtil.traceOut(TAG, "initializeTravelNavigationApp")
    }

    private fun commitFragmentLayers() {
        LogUtil.traceIn(TAG, "commitFragmentLayers")

        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_first_layer_map, MapFragment(), MapFragment.TAG)
        fragmentTransaction.replace(
            R.id.fl_second_layer_guidance,
            GuidanceFragment(),
            GuidanceFragment.TAG
        )
        fragmentTransaction.commit()

        LogUtil.traceOut(TAG, "commitFragmentLayers")
    }

    // endregion Private Methods
}
