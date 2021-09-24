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
import com.orange.ease.dan.databinding.RecyclerViewFragmentBinding
import com.orange.ease.dan.model.Criteria
import com.orange.ease.dan.model.CriteriaRepository
import com.orange.ease.dan.ui.criteria.details.DetailsCriteriaActivity

class CriteriaFragment: Fragment(), ListSelectionRecyclerViewAdapter.ListSelectionRecyclerViewClickListener {

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
            this.context?.let { ListSelectionRecyclerViewAdapter(viewModel.listCriteria, this, it) }

        val concatAdapter = ConcatAdapter(headerAdapter, recyclerViewAdapter)
        binding.listsRecyclerview.adapter = concatAdapter
    }

    override fun listItemClicked(criteria: Criteria) {
        CriteriaRepository.setCurrentCriteria(criteria)
        val intent = Intent(activity, DetailsCriteriaActivity::class.java)
        startActivity(intent)
    }
}


