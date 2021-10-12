package com.orange.ease.dan.ui.criteria.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.orange.ease.dan.R
import com.orange.ease.dan.data.CriteriaRepository
import com.orange.ease.dan.databinding.DetailsCriteriaActivityBinding
import com.orange.ease.dan.ui.criteria.details.examples.ExampleCriteriaFragment
import com.orange.ease.dan.navigation.FragmentManagerActivity
import com.orange.ease.dan.viewmodel.CriteriaDetailsViewModel

class DetailsCriteriaActivity : AppCompatActivity(), FragmentManagerActivity {

    private lateinit var binding: DetailsCriteriaActivityBinding
    private lateinit var viewModel: CriteriaDetailsViewModel

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
        val actionBar=supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        binding.myToolbar.setNavigationOnClickListener { _ -> onBackPressed() }
    }

    private fun initFragment(){
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

}


