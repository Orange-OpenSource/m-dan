package com.orange.ease.dan.ui.developmentguide.details

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.orange.ease.dan.databinding.DetailsDevGuideActivityBinding
import com.orange.ease.dan.model.DevelopmentGuideRepository

class DetailsDevGuideActivity : AppCompatActivity() {

    private lateinit var binding: DetailsDevGuideActivityBinding

    private lateinit var viewModel: DevGuideDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailsDevGuideActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(DevGuideDetailsViewModel::class.java)
        viewModel.guide = DevelopmentGuideRepository.getCurrentGuide()

        initView()
    }

    private fun initView() {
        binding.textViewTitleLinksGuideDev.visibility = View.GONE
        binding.textViewContentLinksGuideDev.visibility = View.GONE

        val guide = viewModel.guide?.let { it } ?: return

        //binding.textViewTitleDescriptionGuideDev.text = getString(guide.titleRes)
        binding.textViewDescriptionContentGuideDev.text = getString(guide.descriptionRes)

        val strongLink = guide.linkRes?.let {getString(it)} ?: return

        binding.textViewContentLinksGuideDev.text = strongLink
        binding.textViewTitleLinksGuideDev.visibility = View.VISIBLE
        binding.textViewContentLinksGuideDev.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        supportActionBar?.title = viewModel.guide?.let { getString(it.titleRes) }
    }
}


