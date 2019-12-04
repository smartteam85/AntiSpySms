package com.github.smartteamx.anti_spy_sms.util

/**
 * An interface to help implementing onBackPressed inside fragments
 */
interface FragmentOnBackPressed {
    /**
     * If return true only onBack of child will be called
     * But if return false onBack of both parent and child will be called
     * @return false if your processing has priority else true
     */
    fun onBackPressed(): Boolean
}