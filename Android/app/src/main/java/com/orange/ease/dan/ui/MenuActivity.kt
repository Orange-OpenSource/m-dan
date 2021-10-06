package com.orange.ease.dan.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.orange.ease.dan.R
import com.orange.ease.dan.databinding.ActivityMenuBinding
import androidx.fragment.app.commit
import com.orange.ease.dan.ui.criteria.CriteriaFragment
import com.orange.ease.dan.ui.developmentguide.DevelopmentGuideFragment
import com.orange.ease.dan.ui.tools.OptionsFragment

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setSupportActionBar(binding.myToolbar)
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
            addToBackStack(null)
        }
    }

    private fun updateMainFragment(integer: Int): Boolean {
        when (integer) {
            R.id.action_android -> initCriteriaFragment()
            R.id.action_logo -> initDevelopmentFragment()
            R.id.action_landscape -> initOptionFragment()
        }
        return true
    }
}


