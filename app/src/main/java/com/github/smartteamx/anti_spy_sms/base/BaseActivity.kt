package com.github.smartteamx.anti_spy_sms.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.github.smartteamx.anti_spy_sms.util.navigation.Navigable
import com.github.smartteamx.anti_spy_sms.util.navigation.navigable

abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding> : AppCompatActivity() {

    abstract val viewModel: VM
    abstract val layoutRes: Int
    abstract val navigationId: Int

    private val navigable: Navigable by navigable()

    val binding by lazy {
        DataBindingUtil.setContentView(this, layoutRes) as DB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        configEvents()
        bindObservables()
        addNavigationSupport()
    }

    private fun addNavigationSupport() {
        val navController = Navigation.findNavController(this, navigationId)
        navigable.makeViewModelNavigable(
            viewModel,
            this,
            this,
            navController
        )
    }

    abstract fun configEvents()
    abstract fun bindObservables()
    abstract fun initBinding()

    fun getCurrentFragment(): Fragment? {
        val navHostFragment = supportFragmentManager.findFragmentById(navigationId)
        val currentFragments = navHostFragment?.childFragmentManager?.fragments
        return currentFragments?.let {
            if (it.isNotEmpty()) it[0]
            else null
        }
    }

}