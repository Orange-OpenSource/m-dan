package com.orange.ease.dan.ui.tools.details

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.orange.ease.dan.databinding.DetailsDevGuideActivityBinding
import com.orange.ease.dan.databinding.OptionsTemplateBinding
import com.orange.ease.dan.model.DevelopmentGuideRepository
import com.orange.ease.dan.model.OptionRepository

class DetailsOptionActivity : AppCompatActivity() {

    private lateinit var binding: OptionsTemplateBinding

    private lateinit var viewModel: OptionDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OptionsTemplateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(OptionDetailsViewModel::class.java)
        viewModel.option = OptionRepository.getCurrentOption()

        initView()
    }

    private fun initView() {
        val option = viewModel.option?.let { it } ?: return
        binding.optionDescription.text = getString(option.description)

    }

    override fun onResume() {
        super.onResume()
        supportActionBar?.title = viewModel.option?.let { getString(it.title) }
    }
}


