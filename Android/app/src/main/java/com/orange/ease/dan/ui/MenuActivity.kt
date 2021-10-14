package com.orange.ease.dan.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.orange.ease.dan.R
import com.orange.ease.dan.databinding.ActivityMenuBinding
import androidx.fragment.app.commit
import com.orange.ease.dan.navigation.DialogActivity
import com.orange.ease.dan.ui.criteria.CriteriaFragment
import com.orange.ease.dan.ui.developmentguide.DevelopmentGuideFragment
import com.orange.ease.dan.ui.tools.OptionsFragment

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

    private fun displayFragment(fragment: Fragment) {
        val fragmentContainerViewId: Int = R.id.main_container

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(fragmentContainerViewId, fragment)
        }
    }

    private fun updateMainFragment(integer: Int): Boolean {
        when (integer) {
            R.id.action_criteria -> initCriteriaFragment()
            R.id.action_development -> initDevelopmentFragment()
            R.id.action_options -> initOptionFragment()
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
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}


