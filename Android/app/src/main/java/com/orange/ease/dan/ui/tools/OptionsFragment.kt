package com.orange.ease.dan.ui.tools

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.orange.ease.dan.databinding.RecyclerViewFragmentBinding
import com.orange.ease.dan.model.DevelopmentGuide
import com.orange.ease.dan.model.DevelopmentGuideRepository
import com.orange.ease.dan.model.Option
import com.orange.ease.dan.model.OptionRepository
import com.orange.ease.dan.ui.developmentguide.details.DetailsDevGuideActivity

class OptionsFragment: Fragment(), ListOptionsRecyclerViewAdapter.ListOptionRecyclerViewClickListener {

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

        val headerAdapter = OptionHeaderAdapter()
        val recyclerViewAdapter =
            this.context?.let { ListOptionsRecyclerViewAdapter(viewModel.listOptions, this, it) }

        val concatAdapter = ConcatAdapter(headerAdapter, recyclerViewAdapter)
        binding.listsRecyclerview.adapter = concatAdapter
    }

    override fun listItemClicked(option: Option) {
        OptionRepository.setCurrentOption(option)
        val intent = Intent(activity, DetailsDevGuideActivity::class.java)
        startActivity(intent)
    }
}


