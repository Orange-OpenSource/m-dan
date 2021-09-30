package com.orange.ease.dan.ui.criteria

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.orange.ease.dan.adapter.header.CriteriaHeaderAdapter
import com.orange.ease.dan.adapter.ListRecyclerViewAdapter
import com.orange.ease.dan.databinding.RecyclerViewFragmentBinding
import com.orange.ease.dan.model.Criteria
import com.orange.ease.dan.data.CriteriaRepository
import com.orange.ease.dan.model.AccessibilityEntity
import com.orange.ease.dan.ui.criteria.details.DetailsCriteriaActivity
import com.orange.ease.dan.viewmodel.CriteriaViewModel

class CriteriaFragment: Fragment(), ListRecyclerViewAdapter.ListRecyclerViewClickListener {

    private lateinit var binding: RecyclerViewFragmentBinding
    private lateinit var viewModel: CriteriaViewModel

    companion object {
        fun newInstance() = CriteriaFragment()
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

        viewModel = ViewModelProvider(this).get(CriteriaViewModel::class.java)

        viewModel.listCriteria = CriteriaRepository.getListOfCriteria()


        val headerAdapter = CriteriaHeaderAdapter()
        val recyclerViewAdapter =
            this.context?.let { ListRecyclerViewAdapter(viewModel.listCriteria, this, it) }

        val concatAdapter = ConcatAdapter(headerAdapter, recyclerViewAdapter)
        binding.listsRecyclerview.adapter = concatAdapter
    }

    override fun listItemClicked(row: AccessibilityEntity) {
        CriteriaRepository.setCurrentCriteria(row as Criteria)
        val intent = Intent(activity, DetailsCriteriaActivity::class.java)
        startActivity(intent)
    }
}


