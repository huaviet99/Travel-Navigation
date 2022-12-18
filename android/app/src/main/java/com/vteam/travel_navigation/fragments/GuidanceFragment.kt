package com.vteam.travel_navigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vteam.travel_navigation.R
import com.vteam.travel_navigation.utils.LogUtil

class GuidanceFragment : AbstractFragment() {
    companion object {
        val TAG = GuidanceFragment::class.simpleName
    }

    // region Abstract Override Method

    override fun getFragmentName(): String {
        return TAG ?: "GuidanceFragment"
    }

    // endregion Abstract Override Method

    // region Android Lifecycles

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogUtil.traceIn(MapFragment.TAG, "onCreateView")

        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_guidance, container, false)

        LogUtil.traceOut(MapFragment.TAG, "onCreateView")
        return view
    }

    // endregion Android Lifecycles
}
