package com.orange.ease.dan.ui.tools.talkback

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.orange.ease.dan.databinding.ActivityTalkbackBinding
import com.orange.ease.dan.model.Gesture
import com.orange.ease.dan.model.GestureRepository


class GestureActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTalkbackBinding
    private lateinit var viewModel: GestureViewModel

    private lateinit var gestureAdapter: GestureAdapter

    private val gesturesObserver = Observer<List<Gesture>> { gestures ->
        gestureAdapter.setGestures(gestures)
        gestureAdapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTalkbackBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViewPager()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(GestureViewModel::class.java)
        viewModel.setListGesture(GestureRepository.getListOfGesture())
        configureLiveDataObservers()
    }

    private fun initViewPager() {
        gestureAdapter = GestureAdapter(this)
        binding.container.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                viewModel.setCurrentPage(position)
            }
        })
        binding.container.adapter = gestureAdapter
    }

    private fun configureLiveDataObservers() {
        viewModel.getListGesture().observe(this, gesturesObserver)

        viewModel.isFirstPage().observe(this, Observer { isFirst ->
            binding.buttonPrevious.isEnabled = !isFirst
        })

        viewModel.isLastPage().observe(this, Observer { isLast ->
            binding.buttonNext.isEnabled = !isLast
        })
    }

    fun previous(view: View) {
        binding.container.currentItem = binding.container.currentItem - 1;
    }

    fun next(view: View) {
        binding.container.currentItem = binding.container.currentItem + 1;
    }
}