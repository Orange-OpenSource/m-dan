package com.orange.ease.dan.ui.tools

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.orange.ease.dan.databinding.OptionsTemplateBinding
import com.orange.ease.dan.model.OptionClassic
import com.orange.ease.dan.data.OptionRepository
import com.orange.ease.dan.viewmodel.ClassicOptionViewModel

class ClassicOptionActivity : AppCompatActivity() {

    private lateinit var binding: OptionsTemplateBinding

    private lateinit var viewModel: ClassicOptionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OptionsTemplateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(ClassicOptionViewModel::class.java)
        viewModel.option = OptionRepository.getCurrentOption() as OptionClassic

        initView()
        setupToolbar()
    }

    private fun initView() {
        val option = viewModel.option?.let { it } ?: return
        binding.optionDescription.text = getString((option as OptionClassic).description)

    }

    private fun setupToolbar() {
        setSupportActionBar(binding.myToolbar)
        val actionBar=supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        binding.myToolbar.setNavigationOnClickListener { _ -> onBackPressed() }
    }

    override fun onResume() {
        super.onResume()
        supportActionBar?.title = viewModel.option?.let { getString(it.resTitle) }
    }
}


