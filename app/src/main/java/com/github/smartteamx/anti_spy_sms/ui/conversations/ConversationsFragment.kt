package com.github.smartteamx.anti_spy_sms.ui.conversations

import com.github.smartteamx.anti_spy_sms.R
import com.github.smartteamx.anti_spy_sms.base.BaseFragment
import com.github.smartteamx.anti_spy_sms.databinding.FragmentConversationsBinding
import com.github.smartteamx.anti_spy_sms.util.pagination.EndlessRecyclerViewScrollListener
import kotlinx.android.synthetic.main.fragment_conversations.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ConversationsFragment : BaseFragment<ConversationsViewModel, FragmentConversationsBinding>() {
    override val viewModel: ConversationsViewModel by viewModel()
    override val layoutRes: Int = R.layout.fragment_conversations

    private val conversationsAdapter:ConversationsAdapter by inject()

    override fun configEvents() {

    }

    override fun bindObservables() {

    }

    override fun initBinding() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
            executePendingBindings()
        }
    }

}