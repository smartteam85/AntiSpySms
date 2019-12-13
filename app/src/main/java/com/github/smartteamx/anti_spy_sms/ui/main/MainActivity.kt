package com.github.smartteamx.anti_spy_sms.ui.main

import com.github.smartteamx.anti_spy_sms.R
import com.github.smartteamx.anti_spy_sms.base.BaseActivity
import com.github.smartteamx.anti_spy_sms.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val viewModel: MainViewModel by viewModel()
    override val layoutRes: Int = R.layout.activity_main
    override val navigationId: Int = R.navigation.main_navigation


    override fun configEvents() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bindObservables() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initBinding() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}