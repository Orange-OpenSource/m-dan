/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.orange.ease.dan.ui.criteria.details

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.orange.ease.dan.R
import com.orange.ease.dan.data.CriteriaRepository
import com.orange.ease.dan.databinding.DetailsCriteriaActivityBinding
import com.orange.ease.dan.navigation.DialogActivity
import com.orange.ease.dan.navigation.FragmentManagerActivity
import com.orange.ease.dan.ui.criteria.details.examples.ExampleCriteriaFragment
import com.orange.ease.dan.viewmodel.CriteriaDetailsViewModel


class DetailsCriteriaActivity : DialogActivity(), FragmentManagerActivity {

    private lateinit var binding: DetailsCriteriaActivityBinding
    private lateinit var viewModel: CriteriaDetailsViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailsCriteriaActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupToolbar()

        if (savedInstanceState == null) {
            initFragment()
        }

        viewModel = ViewModelProvider(this).get(CriteriaDetailsViewModel::class.java)
        viewModel.criteria = CriteriaRepository.getCurrentCriteria()

    }

    private fun setupToolbar() {
        setSupportActionBar(binding.myToolbar)
        binding.myToolbar.inflateMenu(R.menu.options_menu)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        binding.myToolbar.setNavigationOnClickListener { _ -> onBackPressed() }
    }

    private fun initFragment() {
        val details = DetailsCriteriaFragment.newInstance()

        val fragmentContainerViewId: Int = R.id.details_container

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(fragmentContainerViewId, details)
        }
    }

    override fun updateFragmentWithExample() {
        updateSpecificFragment(ExampleCriteriaFragment())
    }

    override fun updateSpecificFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.details_container, fragment)
        transaction.addToBackStack("back")
        transaction.commit()
    }

    override fun addSpecificFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.details_container, fragment)
        transaction.addToBackStack("back")
        transaction.commit()
    }

    override fun back() {
        onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        this.menu = menu
        setMenuActionVisibility(false)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_option -> {
            val startActivitySettings: () -> Unit = {
                startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
            }
            initAlertDialogStartActivity(startActivitySettings)
            true

        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun setMenuActionVisibility(isVisible: Boolean) {
        val item: MenuItem? = menu?.findItem(R.id.action_option)
        item?.isVisible = isVisible
    }

    /* private fun initAlertDialogStartActivity() {
         val builder = AlertDialog.Builder(this)
         builder.setMessage(getString(R.string.alert_before_leaving))
         builder.setCancelable(true)
         builder.setPositiveButton(
             getString(R.string.yes)
         ) { _, _ -> startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)) }
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
     }*/

}


