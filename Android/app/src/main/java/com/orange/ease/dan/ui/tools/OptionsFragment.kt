package com.orange.ease.dan.ui.tools

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.orange.ease.dan.adapter.ListRecyclerViewAdapter
import com.orange.ease.dan.adapter.header.OptionHeaderAdapter
import com.orange.ease.dan.data.OptionRepository
import com.orange.ease.dan.databinding.RecyclerViewFragmentBinding
import com.orange.ease.dan.model.*
import com.orange.ease.dan.navigation.DialogActivity
import com.orange.ease.dan.ui.tools.talkback.TalkbackOptionActivity
import com.orange.ease.dan.viewmodel.OptionsViewModel

class OptionsFragment: Fragment(), ListRecyclerViewAdapter.ListRecyclerViewClickListener, OptionHeaderAdapter.HeaderOptionButtonClickListener {

    private lateinit var binding: RecyclerViewFragmentBinding
    private lateinit var viewModel: OptionsViewModel

    companion object {
        fun newInstance() = OptionsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RecyclerViewFragmentBinding.inflate(inflater, container, false)

        binding.listsRecyclerview.layoutManager = LinearLayoutManager(requireContext())

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(OptionsViewModel::class.java)

        viewModel.listOptions = OptionRepository.getListOfOption()

        val headerAdapter = OptionHeaderAdapter(this)
        val recyclerViewAdapter =
            this.context?.let { ListRecyclerViewAdapter(viewModel.listOptions, this, it) }

        val concatAdapter = ConcatAdapter(headerAdapter, recyclerViewAdapter)
        binding.listsRecyclerview.adapter = concatAdapter
    }

    override fun listItemClicked(row: AccessibilityEntity) {
        OptionRepository.setCurrentOption(row)
        val intent  = when (row) {
            is OptionTalkback ->  Intent(activity, TalkbackOptionActivity::class.java)
            is OptionClassic -> Intent(activity, ClassicOptionActivity::class.java)
            else -> null
        }
        startActivity(intent)
    }

    override fun accessibilityButton() {
        val startActivitySettings: () -> Unit = {
            startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
        }

        (activity as DialogActivity).initAlertDialogStartActivity(startActivitySettings)
    }
}


