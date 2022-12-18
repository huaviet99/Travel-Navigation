package com.vteam.travel_navigation.states

import com.vteam.travel_navigation.utils.LogUtil

class InitializingState : AbstractState() {
    companion object {
        private val TAG = InitializingState::class.simpleName
    }

    // region Abstract Override Method

    override fun getStateName(): String {
        return TAG ?: "InitializingState"
    }

    // endregion Abstract Override Method

    // region Application Event Override Methods

    override fun onMapLoaded() {
        LogUtil.traceIn(TAG, "onMapLoaded")

        val fragmentEventListeners = StateManager.getFragmentEventListeners()

        fragmentEventListeners?.forEach { fragmentListener ->
            fragmentListener.onMapLoaded()
        }

        StateManager.setFunctionState(IdleState())

        LogUtil.traceOut(TAG, "onMapLoaded")
    }

    // endregion Application Event Override Methods
}
