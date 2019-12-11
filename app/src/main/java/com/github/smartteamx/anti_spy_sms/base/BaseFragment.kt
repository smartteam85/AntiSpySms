package com.github.smartteamx.anti_spy_sms.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.smartteamx.anti_spy_sms.util.navigation.Navigable
import com.github.smartteamx.anti_spy_sms.util.navigation.navigable

abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> : Fragment() {

    abstract val viewModel: VM
    open val sharedViewModel: BaseViewModel? = null
    abstract val layoutRes: Int
    open var binding: DB? = null

    private val navigable: Navigable by navigable()

    private fun init(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        init(inflater, container)
        initBinding()
        bindObservables()
        return binding?.root ?: View(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configEvents()
        addNavigationSupport()
    }

    private fun addNavigationSupport() {
        val navController = findNavController()
        navigable.makeViewModelNavigable(
            viewModel,
            activity,
            this,
            navController
        )
        navigable.makeViewModelNavigable(
            sharedViewModel,
            activity,
            this,
            navController
        )
    }

    abstract fun configEvents()
    abstract fun bindObservables()
    abstract fun initBinding()

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}