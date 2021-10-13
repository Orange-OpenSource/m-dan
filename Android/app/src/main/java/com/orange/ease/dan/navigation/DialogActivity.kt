package com.orange.ease.dan.navigation

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.orange.ease.dan.R

public abstract class DialogActivity: AppCompatActivity() {

    fun initAlertDialogStartActivity(yesListener: () -> Unit) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(getString(R.string.alert_before_leaving))
        builder.setCancelable(true)
        builder.setPositiveButton(
            getString(R.string.yes)
        ) { _, _ -> yesListener.invoke() }
        builder.setNegativeButton(
            getString(R.string.no)
        ) { dialog, _ -> dialog.cancel() }
        val alert = builder.create()
        alert.show()
        val buttonYes = alert.getButton(AlertDialog.BUTTON_POSITIVE)
        buttonYes.setCompoundDrawablesWithIntrinsicBounds(
            ContextCompat.getDrawable(
                this,
                R.drawable.icon_check_good
            ), null, null, null
        )
        buttonYes.contentDescription = getString(R.string.yes)
        buttonYes.text = ""
        val buttonNo = alert.getButton(AlertDialog.BUTTON_NEGATIVE)
        buttonNo.setCompoundDrawablesWithIntrinsicBounds(
            ContextCompat.getDrawable(
                this,
                R.drawable.icon_check_bad
            ), null, null, null
        )
        buttonNo.contentDescription = getString(R.string.no)
        buttonNo.text = ""
    }

}