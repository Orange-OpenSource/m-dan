package com.orange.ease.dan.ui

import android.os.Bundle
import com.orange.ease.dan.R
import com.orange.ease.dan.databinding.ActivityAboutBinding
import com.orange.ease.dan.navigation.DialogActivity

class AboutActivity : DialogActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        val view = binding.root
        setupToolbar()
        setContentView(view)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.myToolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        binding.myToolbar.setNavigationOnClickListener { _ -> onBackPressed() }
    }
}


