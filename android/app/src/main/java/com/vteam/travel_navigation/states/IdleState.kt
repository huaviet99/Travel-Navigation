package com.vteam.travel_navigation.states

import android.util.SparseArray
import androidx.fragment.app.FragmentManager
import com.vteam.travel_navigation.utils.LogUtil

class IdleState : AbstractState() {
    companion object {
        private val TAG = IdleState::class.simpleName
    }

    // region Abstract Override Method

    override fun getStateName(): String {
        return TAG ?: "IdleState"
    }

    // endregion Abstract Override Method

    // region Application Event Override Methods

    override fun requestScreenChange(
        fragmentManager: FragmentManager,
        sourceTag: String,
        destinationTag: String,
        arguments: SparseArray<Object>
    ) {
        LogUtil.traceIn(TAG, "requestScreenChange source=$sourceTag destination=$destinationTag")

        // Change from IdleState to ScreenChangingState to handle screen changing process
        StateManager.setFunctionState(ScreenChangingState())
        StateManager.requestScreenChange(fragmentManager, sourceTag, destinationTag, arguments)
        LogUtil.traceOut(TAG, "requestScreenChange")
    }

    override fun onMapIdle() {
        LogUtil.traceIn(TAG, "onMapIdle")
        LogUtil.traceOut(TAG, "onMapIdle")
    }

    // endregion Application Event Override Methods
}
