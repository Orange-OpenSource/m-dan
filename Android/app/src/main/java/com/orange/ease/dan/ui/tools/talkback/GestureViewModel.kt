package com.orange.ease.dan.ui.tools.talkback

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.orange.ease.dan.model.DevelopmentGuide
import com.orange.ease.dan.model.Gesture
import com.orange.ease.dan.model.Option

class GestureViewModel : ViewModel() {

    private val listGesture = MutableLiveData<List<Gesture>>()
    private val currentPage = MutableLiveData<Int>()
    private val isFirstPage = MutableLiveData<Boolean>()
    private val isLastPage = MutableLiveData<Boolean>()

    public fun getListGesture(): LiveData<List<Gesture>> {
        return listGesture
    }

    public fun setListGesture(gestures: List<Gesture>) {
        listGesture.value = gestures
    }
    
    public fun setCurrentPage(pageNumber: Int) {
        currentPage.postValue(pageNumber)
        isFirstPage.postValue(pageNumber == 0)
        isLastPage.postValue(pageNumber+1 == getListGesture().value?.size ?: 1)
    }

    public fun isFirstPage(): LiveData<Boolean> = isFirstPage

    public fun isLastPage(): LiveData<Boolean> = isLastPage
}


