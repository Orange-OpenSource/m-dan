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

package com.orange.ease.dan.ui

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.orange.ease.dan.R
import com.orange.ease.dan.databinding.ActivityMenuBinding
import com.orange.ease.dan.navigation.DialogActivity
import com.orange.ease.dan.ui.criteria.CriteriaFragment
import com.orange.ease.dan.ui.developmentguide.DevelopmentGuideFragment
import com.orange.ease.dan.ui.tools.OptionsFragment
import com.orange.ease.dan.ui.tools.TestFragment

class MenuActivity : DialogActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setSupportActionBar(binding.myToolbar)
        binding.myToolbar.inflateMenu(R.menu.sub_menu)
        setContentView(view)

        if (savedInstanceState == null) {
            initCriteriaFragment()
        }

        configureBottomView()
    }
    private fun configureBottomView() {
        binding.activityMainBottomNavigation.setOnNavigationItemSelectedListener { item ->
            updateMainFragment(item.itemId)
        }
    }

    private fun initCriteriaFragment(){
        displayFragment(CriteriaFragment.newInstance())
    }

    private fun initDevelopmentFragment(){
        displayFragment(DevelopmentGuideFragment.newInstance())
    }

    private fun initOptionFragment(){
        displayFragment(OptionsFragment.newInstance())
    }

    private fun initTestFragment(){
        displayFragment(TestFragment.newInstance())
    }

    private fun displayFragment(fragment: Fragment) {
        val fragmentContainerViewId: Int = R.id.main_container

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(fragmentContainerViewId, fragment)
        }
    }

    private fun updateMainFragment(integer: Int): Boolean {
        when (integer) {
            R.id.action_criteria -> {
                initCriteriaFragment()
                binding.myToolbar.title = getString(R.string.criteria_section_title)
            }
            R.id.action_development -> {
                initDevelopmentFragment()
                binding.myToolbar.title = getString(R.string.development_section_title)
            }
            R.id.action_options -> {
                initOptionFragment()
                binding.myToolbar.title = getString(R.string.options_section_title
                )
            }
            R.id.action_Test -> {
                initTestFragment()
                binding.myToolbar.title = getString(R.string.test_section_title)}
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.sub_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_axs_orange -> {
            val intent = Intent(this, AxsOrangeActivity::class.java)
            startActivity(intent)
            true
        }
        R.id.action_about -> {
            val intent = Intent(this, LegalActivity::class.java)
            startActivity(intent)
            true
        }
        R.id.action_cgu -> {
            val intent = Intent(this, TermsActivity::class.java)
            startActivity(intent)
            true
        }
        R.id.action_contact -> {
            val i = Intent(Intent.ACTION_SEND)
            i.type = "message/rfc822"
            i.putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.mail_address)))
            i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.mail_subject))
            i.putExtra(Intent.EXTRA_TEXT, getString(R.string.mail_body))
            try {
                startActivity(Intent.createChooser(i, "Send mail..."))
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(
                    this@MenuActivity,
                    R.string.mail_toast,
                    Toast.LENGTH_SHORT
                ).show()
            }
            true
        }
        R.id.action_other_apps -> {
            val intent = Intent(this, OtherAppsActivity::class.java)
            startActivity(intent)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}


