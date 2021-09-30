package com.orange.ease.dan.viewmodel

import androidx.lifecycle.ViewModel
import com.orange.ease.dan.model.Criteria
import com.orange.ease.dan.model.Example

class CriteriaDetailsViewModel : ViewModel() {

    var criteria: Criteria? = null
    private var currentExample: Example? = null

    fun setCurrentExample(example: Example) {
        currentExample = example
    }

    fun getCurrentExample() : Example? {
        return currentExample
    }

}


