package com.orange.ease.dan.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.orange.ease.dan.databinding.ActivityAxsorangeBinding
import com.orange.ease.dan.navigation.DialogActivity

class AxsOrangeActivity : DialogActivity() {

    private lateinit var binding: ActivityAxsorangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAxsorangeBinding.inflate(layoutInflater)
        val view = binding.root
        setSupportActionBar(binding.myToolbar)
        setContentView(view)
    }

    fun clickNetwork(view: View) {
        val packageName = "com.orange.wifiorange"
        startPackageActivity(packageName)
    }

    fun clickFootball(view: View) {
        val packageName = "com.orange.ofc"
        startPackageActivity(packageName)
    }

    fun clickLivebox(view: View) {
        val packageName = "com.orange.mylivebox.fr"
        startPackageActivity(packageName)
    }

    fun clickOEM(view: View) {
        val packageName = "com.orange.orangeetmoi"
        startPackageActivity(packageName)
    }

    private fun startPackageActivity(packageName: String) {
        val startActivitySettings: () -> Unit = {
            startNewActivity(this, packageName)
        }
        initAlertDialogStartActivity(startActivitySettings)
    }

    private fun startNewActivity(context: Context, packageName: String) {
        var intent = context.packageManager.getLaunchIntentForPackage(packageName)
        if (intent == null) {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("market://details?id=$packageName")
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }
}


