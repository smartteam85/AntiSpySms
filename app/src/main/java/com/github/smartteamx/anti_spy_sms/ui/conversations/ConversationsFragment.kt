package com.github.smartteamx.anti_spy_sms.ui.conversations

import com.github.smartteamx.anti_spy_sms.R
import com.github.smartteamx.anti_spy_sms.base.BaseFragment
import com.github.smartteamx.anti_spy_sms.databinding.FragmentConversationsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ConversationsFragment : BaseFragment<ConversationsViewModel, FragmentConversationsBinding>() {
    override val viewModel: ConversationsViewModel by viewModel()
    override val layoutRes: Int = R.layout.fragment_conversations

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