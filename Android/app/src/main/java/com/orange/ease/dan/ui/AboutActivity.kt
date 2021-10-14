package com.orange.ease.dan.ui

import android.os.Bundle
import com.orange.ease.dan.databinding.ActivityAboutBinding
import com.orange.ease.dan.navigation.DialogActivity

class AboutActivity : DialogActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        val view = binding.root
        setSupportActionBar(binding.myToolbar)
        setContentView(view)
    }
}


