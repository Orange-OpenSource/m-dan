package com.orange.ease.dan.ui.criteria.details.examples.pager

import android.accessibilityservice.AccessibilityService
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.provider.Settings.SettingNotFoundException
import android.text.TextUtils.SimpleStringSplitter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.orange.ease.dan.R
import com.orange.ease.dan.adapter.ViewPagerExampleAdapter
import com.orange.ease.dan.databinding.Excontrolcontent1FragBinding

class ViewPagerFragment: Fragment() {

    private lateinit var binding: Excontrolcontent1FragBinding
    private lateinit var mContext : Context

    val INDICE_START = 0
    val INDICE_END = 2
    val INDICE_END_HUMAN = INDICE_END + 1

    val IS_ACCESSIBLE = "isAccessible"
    val IS_SCROLLEX = "isScrollEx"
    var mIsAccessible = false
    var mIsScrollEx = false

    var mButtons = arrayOfNulls<ImageButton>(INDICE_END_HUMAN)

    private var adapter: ViewPagerExampleAdapter? = null

    var mOnSelectPageClickListener =
        View.OnClickListener { v -> binding.viewPager.setCurrentItem(v.id, true) }

    companion object {
        fun newInstance() = ViewPagerFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Excontrolcontent1FragBinding.inflate(inflater, container, false)
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

    private fun updateViews() {
        val args = arguments
        if (args != null) {
            mIsAccessible = args.getBoolean(IS_ACCESSIBLE, false)
            mIsScrollEx = args.getBoolean(IS_SCROLLEX)
        } else {
            mIsAccessible = true
            mIsScrollEx = false
        }
        adapter = ViewPagerExampleAdapter(context = mContext, mIsAccessible = mIsAccessible)
        binding.viewPager.setAdapter(adapter)
        if (mIsAccessible) {
            if (!isAccessibilitySettingsOn()) {
                binding.imgButtonPrevious.setVisibility(View.VISIBLE)
                binding.imgButtonNext.setVisibility(View.VISIBLE)
            } else {
                binding.imgButtonPrevious.setVisibility(View.GONE)
                binding.imgButtonNext.setVisibility(View.GONE)
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                binding.linearLayout.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS)
            }
            binding.linearLayout.setContentDescription(getString(R.string.promotion) + " " + 1 + "sur" + (INDICE_END + 1))
        } else {
            binding.imgButtonPrevious.setVisibility(View.GONE)
            binding.imgButtonNext.setVisibility(View.GONE)
            binding.viewPager.startAutoScroll(2000)
        }
        if (mIsScrollEx) {
            binding.imgButtonPrevious.setVisibility(View.GONE)
            binding.imgButtonNext.setVisibility(View.GONE)
            binding.viewPager.stopAutoScroll()
            binding.linearLayout.setVisibility(View.GONE)
        }
        for (i in INDICE_START..INDICE_END) {
            val button = ImageButton(context)
            button.id = i
            if (mIsAccessible) {
                button.contentDescription =
                    getString(R.string.promotion) + " " + (i + 1) + " sur " + (INDICE_END + 1)
            }
            button.setImageResource(R.drawable.ic_radio_button_checked_white_24dp)
            button.setBackgroundResource(R.color.core_black)
            if (i == INDICE_START) {
                button.setColorFilter(R.color.core_orange_dark)
            } else {
                button.setColorFilter(R.color.core_white)
            }
            button.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            button.setOnClickListener(mOnSelectPageClickListener)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                button.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
            }
            button.isFocusable = true
            mButtons[i] = button
            binding.linearLayout.addView(button, i)
        }
        binding.viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (mIsAccessible) {
                    binding.linearLayout.setContentDescription(
                        getString(R.string.promotion) + " " + (position + 1) + " " + getString(
                            R.string.on
                        ) + " " + (INDICE_END + 1)
                    )
                }
                for (i in INDICE_START..INDICE_END) {
                    val button = binding.linearLayout.getChildAt(i) as ImageButton
                    if (i == position) {
                        button.setColorFilter(R.color.core_orange_dark)
                    } else {
                        button.setColorFilter(R.color.core_white)
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
        binding.viewPager.setCurrentItem(INDICE_START, true)
        binding.viewPager.setScrollDurationFactor(10.0)
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


