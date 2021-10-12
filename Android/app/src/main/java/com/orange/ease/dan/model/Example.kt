package com.orange.ease.dan.model

import androidx.annotation.StringRes
import com.orange.ease.dan.ui.criteria.details.examples.AccessibilityDetailsExample

class Example(@StringRes resTitle: Int, val detailsExample: AccessibilityDetailsExample, val apiVersion: Int? = null): AccessibilityEntity(resTitle) {
}
