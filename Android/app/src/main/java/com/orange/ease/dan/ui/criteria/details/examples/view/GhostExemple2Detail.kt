package com.orange.ease.dan.ui.criteria.details.examples.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.orange.ease.dan.databinding.Exghost11FragBinding
import com.orange.ease.dan.navigation.FragmentManagerActivity

class GhostExemple2Detail: Fragment() {

    private lateinit var binding: Exghost11FragBinding
    private lateinit var mContext : Context
    private var mContent: String = ""

    companion object {
        fun newInstance() = GhostExemple2Detail()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Exghost11FragBinding.inflate(inflater, container, false)
        var bundle : Bundle ? = arguments
        mContent = bundle?.getString("content") ?: ""
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.textViewContent.announceForAccessibility(mContent)
        binding.textViewContent.text = mContent
        binding.btnok.setOnClickListener{
            (context as FragmentManagerActivity?)?.let {
                it.back()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

}

