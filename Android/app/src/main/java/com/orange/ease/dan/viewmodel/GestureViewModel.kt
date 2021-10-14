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

package com.orange.ease.dan.viewmodel

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


