package com.orange.ease.dan.ui.tools.talkback

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.provider.Settings.SettingNotFoundException
import android.text.TextUtils.SimpleStringSplitter
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.orange.ease.dan.R
import com.orange.ease.dan.databinding.FragmentTalkbackBinding

class TalkbackOptionActivity : AppCompatActivity() {

    private lateinit var binding: FragmentTalkbackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentTalkbackBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun enableTalkback(view: View) {
        if (!isAccessibilitySettingsOn(applicationContext)) {
            initAlertDialogStartActivity()
        }
    }

    fun seeGesture(view: View) {
        startTuto()
    }


    override fun onResume() {
        super.onResume()
        supportActionBar?.title = getString(R.string.options_talkback_title)
    }

    private fun isAccessibilitySettingsOn(mContext: Context): Boolean {
        var accessibilityEnabled = 0
        val service: String = packageName + "/" + AccessibilityService::class.java.canonicalName
        try {
            accessibilityEnabled = Settings.Secure.getInt(
                mContext.applicationContext.contentResolver,
                Settings.Secure.ACCESSIBILITY_ENABLED
            )
        } catch (e: SettingNotFoundException) {
        }
        val mStringColonSplitter = SimpleStringSplitter(':')
        if (accessibilityEnabled == 1) {
            val settingValue = Settings.Secure.getString(
                mContext.applicationContext.contentResolver,
                Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
            )
            if (settingValue != null) {
                mStringColonSplitter.setString(settingValue)
                while (mStringColonSplitter.hasNext()) {
                    val accessibilityService = mStringColonSplitter.next()
                    if (accessibilityService.equals(service, ignoreCase = true)) {
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun initAlertDialogStartActivity() {
        val builder1 = AlertDialog.Builder(this)
        builder1.setMessage(getString(R.string.alert_before_leaving))
        builder1.setCancelable(true)
        builder1.setPositiveButton(
            "Oui"
        ) { dialog, id -> startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)) }
        builder1.setNegativeButton(
            "Non"
        ) { dialog, id -> dialog.cancel() }
        val alert11 = builder1.create()
        alert11.show()
        val button0 = alert11.getButton(AlertDialog.BUTTON_POSITIVE)
        button0.setCompoundDrawablesWithIntrinsicBounds(
            ContextCompat.getDrawable(
                this,
                R.drawable.icon_check_good
            ), null, null, null
        )
        button0.contentDescription = "Oui"
        button0.text = ""
        val button1 = alert11.getButton(AlertDialog.BUTTON_NEGATIVE)
        button1.setCompoundDrawablesWithIntrinsicBounds(
            ContextCompat.getDrawable(
                this,
                R.drawable.icon_check_bad
            ), null, null, null
        )
        button1.contentDescription = "Non"
        button1.text = ""
    }

    private fun startTuto() {
        val openTutoActivity = Intent(this, GestureActivity::class.java)
        startActivity(openTutoActivity)
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out)
    }
}


