package com.vteam.travel_navigation.states

import android.util.SparseArray
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.vteam.travel_navigation.R
import com.vteam.travel_navigation.fragments.AbstractFragment
import com.vteam.travel_navigation.fragments.GuidanceFragment
import com.vteam.travel_navigation.utils.LogUtil

class ScreenChangingState : AbstractState() {
    companion object {
        private val TAG = ScreenChangingState::class.simpleName
    }

    // region Abstract Override Method

    override fun getStateName(): String {
        return TAG ?: "ScreenChangingState"
    }

    // endregion Abstract Override Method

    // region Application Event Override Methods

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
        val targetLayer = R.id.fl_third_layer_features
        val fragmentTransaction = fragmentManager.beginTransaction()

        var destinationFragment: Fragment? = null
        when (destinationTag) {
            GuidanceFragment.TAG -> {
                destinationFragment = GuidanceFragment()
            }
        }

        // Remove current views of current fragment and replace it with destination fragments
        destinationFragment?.let { notNullDestinationFragment ->
            val sourceFragment = fragmentManager.findFragmentByTag(sourceTag) as? AbstractFragment
            sourceFragment?.let { notNullSourceFragment ->
                notNullSourceFragment.removeSelfViewFromFeaturesLayer()
            }
            fragmentTransaction.replace(targetLayer, notNullDestinationFragment, destinationTag)
            fragmentTransaction.addToBackStack(destinationTag)
            fragmentTransaction.commit()
        }

        LogUtil.traceOut(TAG, "requestScreenChange")
    }

    // endregion Application Event Override Methods
}
