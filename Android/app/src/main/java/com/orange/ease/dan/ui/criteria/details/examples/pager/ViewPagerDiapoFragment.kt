package com.orange.ease.dan.ui.criteria.details.examples.pager

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.provider.Settings
import android.provider.Settings.SettingNotFoundException
import android.text.TextUtils.SimpleStringSplitter
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.orange.ease.dan.R
import com.orange.ease.dan.adapter.ViewPagerExampleAdapter
import com.orange.ease.dan.databinding.Excontrolcontent2FragBinding

class ViewPagerDiapoFragment : Fragment() {

    private lateinit var binding: Excontrolcontent2FragBinding
    private lateinit var mContext: Context

    val INDICE_START = 0
    val INDICE_END = 2
    val INDICE_END_HUMAN = INDICE_END + 1

    var mIsAccessible = false
    var mIsScrollEx = false

    private lateinit var adapter: ViewPagerExampleAdapter

    companion object {
        fun newInstance() = ViewPagerDiapoFragment()
        val IS_ACCESSIBLE = "isAccessible"
        val IS_SCROLLEX = "isScrollEx"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Excontrolcontent2FragBinding.inflate(inflater, container, false)
        updateViews()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    fun doInUiThreadAfterTwoSeconds() {
        Handler().postDelayed({
            binding.imgButtonPrevious.visibility = View.GONE
            binding.imgButtonNext.visibility = View.GONE
            binding.imgButtonPlay.visibility = View.GONE
        }, 2000)

    }

    private fun updateViews() {
        val args = arguments
        mIsAccessible = args == null || args.getBoolean(IS_ACCESSIBLE, false)

        adapter = ViewPagerExampleAdapter(mIsAccessible, mContext)
        binding.viewPager.adapter = adapter


        if (!mIsAccessible) {
            binding.imgButtonPrevious.contentDescription = ""
            binding.imgButtonNext.contentDescription = ""
            binding.imgButtonPlay.contentDescription = ""
            doInUiThreadAfterTwoSeconds()
        }

        binding.imgButtonPrevious.setOnClickListener(View.OnClickListener {
            if (binding.viewPager.currentItem == INDICE_START) {
                binding.viewPager.setCurrentItem(INDICE_END, true)
            } else {
                binding.viewPager.currentItem = binding.viewPager.currentItem - 1
            }
            binding.viewPager.announceForAccessibility(
                adapter!!.getContentDescriptionImage(
                    binding.viewPager.currentItem
                )
            )
        })
        binding.imgButtonNext.setOnClickListener(View.OnClickListener {
            if (binding.viewPager.currentItem == INDICE_END) {
                binding.viewPager.setCurrentItem(INDICE_START, true)
            } else {
                binding.viewPager.currentItem = binding.viewPager.currentItem + 1
            }
            binding.viewPager.announceForAccessibility(
                adapter!!.getContentDescriptionImage(
                    binding.viewPager.currentItem
                )
            )
        })
        binding.imgButtonPlay.setOnClickListener(View.OnClickListener {
            binding.imgButtonPrevious.visibility = View.GONE
            binding.imgButtonNext.visibility = View.GONE
            binding.imgButtonPlay.visibility = View.GONE
            binding.viewPager.startAutoScroll(4000)
            binding.viewPager.setCycle(true)
            if (mIsAccessible) {
                view?.announceForAccessibility(getString(R.string.criteria_contentcontrol_ex2_announceForAxs))
            }
        })
        binding.imgButtonPrevious.visibility = View.VISIBLE
        binding.imgButtonNext.visibility = View.VISIBLE

        binding.viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                SystemClock.sleep(2000)
                binding.viewPager.announceForAccessibility(
                    adapter.getContentDescriptionPosition(
                        position
                    )
                )
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        binding.viewPager.setOnTouchListener(OnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                binding.imgButtonPrevious.visibility = View.VISIBLE
                binding.imgButtonNext.visibility = View.VISIBLE
                binding.imgButtonPlay.visibility = View.VISIBLE
                binding.viewPager.stopAutoScroll()
                if (mIsAccessible) {
                    view?.announceForAccessibility(getString(R.string.criteria_contentcontrol_ex2_announceForAxs2))
                }
            }
            false
        })
    }

    private fun isAccessibilitySettingsOn(): Boolean {
        var accessibilityEnabled = 0
        val service = mContext.packageName + "/" + AccessibilityService::class.java.canonicalName
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
}


