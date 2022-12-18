package com.vteam.travel_navigation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vteam.travel_navigation.R
import com.vteam.travel_navigation.fragments.TravelNavigationFragment
import com.vteam.travel_navigation.utils.LogUtil

class TravelNavigationActivity : AppCompatActivity() {
    companion object {
        private val TAG = TravelNavigationActivity::class.simpleName
    }

    // region Android Lifecycles

    override fun onCreate(savedInstanceState: Bundle?) {
        LogUtil.traceIn(TAG, "onCreate")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_navigation)

        savedInstanceState?.also {
        } ?: run {
            initializeTravelNavigationFragment()
        }

        LogUtil.traceOut(TAG, "onCreate")
    }

    // endregion Android Lifecycles

    // region Private Methods

    private fun initializeTravelNavigationFragment() {
        LogUtil.traceIn(TAG, "initializeTravelNavigationFragment")

        val travelNavigationFragment = TravelNavigationFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fl_travel_navigation, travelNavigationFragment).commit()

        LogUtil.traceOut(TAG, "initializeTravelNavigationFragment")
    }

    // endregion Private Methods
}
