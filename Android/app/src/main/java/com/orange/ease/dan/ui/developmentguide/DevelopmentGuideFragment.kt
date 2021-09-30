package com.orange.ease.dan.ui.developmentguide

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.orange.ease.dan.adapter.header.DevelopmentHeaderAdapter
import com.orange.ease.dan.adapter.ListRecyclerViewAdapter
import com.orange.ease.dan.databinding.RecyclerViewFragmentBinding
import com.orange.ease.dan.model.DevelopmentGuide
import com.orange.ease.dan.data.DevelopmentGuideRepository
import com.orange.ease.dan.model.AccessibilityEntity
import com.orange.ease.dan.viewmodel.DevelopmentGuideViewModel

class DevelopmentGuideFragment: Fragment(), ListRecyclerViewAdapter.ListRecyclerViewClickListener {

    private lateinit var binding: RecyclerViewFragmentBinding
    private lateinit var viewModel: DevelopmentGuideViewModel

    companion object {
        fun newInstance() = DevelopmentGuideFragment()
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

        viewModel = ViewModelProvider(this).get(DevelopmentGuideViewModel::class.java)

        viewModel.listGuide = DevelopmentGuideRepository.getListOfGuide()

        val headerAdapter = DevelopmentHeaderAdapter()
        val recyclerViewAdapter =
            this.context?.let { ListRecyclerViewAdapter(viewModel.listGuide, this, it) }

        val concatAdapter = ConcatAdapter(headerAdapter, recyclerViewAdapter)
        binding.listsRecyclerview.adapter = concatAdapter
    }

    override fun listItemClicked(row: AccessibilityEntity) {
        DevelopmentGuideRepository.setCurrentGuide(row as DevelopmentGuide)
        val intent = Intent(activity, DetailsDevGuideActivity::class.java)
        startActivity(intent)
    }
}


