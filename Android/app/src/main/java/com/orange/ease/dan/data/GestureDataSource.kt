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

package com.orange.ease.dan.data

import com.orange.ease.dan.R
import com.orange.ease.dan.model.Gesture

object GestureDataSource {

    private val gesture1 = Gesture(
        R.drawable.talkbackgesture1, R.string.tb_talkbackgesture1, R.string.tb_talkbackgesture1_sub
    )
    private val gesture2 = Gesture(
        R.drawable.talkbackgesture2, R.string.tb_talkbackgesture2, R.string.tb_talkbackgesture2_sub
    )
    private val gesture3 = Gesture(
        R.drawable.talkbackgesture3_1,
        R.string.tb_talkbackgesture3,
        R.string.tb_talkbackgesture3_sub
    )
    private val gesture4 = Gesture(
        R.drawable.talkbackgesture3_2,
        R.string.tb_talkbackgesture4,
        R.string.tb_talkbackgesture4_sub
    )
    private val gesture5 = Gesture(
        R.drawable.talkbackgesture4_1,
        R.string.tb_talkbackgesture5,
        R.string.tb_talkbackgesture5_sub
    )
    private val gesture6 = Gesture(
        R.drawable.talkbackgesture4_2,
        R.string.tb_talkbackgesture6,
        R.string.tb_talkbackgesture6_sub
    )
    private val gesture7 = Gesture(
        R.drawable.talkbackgesture5, R.string.tb_talkbackgesture7, R.string.tb_talkbackgesture7_sub
    )
    private val gesture8 = Gesture(
        R.drawable.talkbackgesture6, R.string.tb_talkbackgesture8, R.string.tb_talkbackgesture8_sub
    )
    private val gesture9 = Gesture(
        R.drawable.talkbackgesture7, R.string.tb_talkbackgesture9, R.string.tb_talkbackgesture9_sub
    )
    private val gesture10 = Gesture(
        R.drawable.talkbackgesture8,
        R.string.tb_talkbackgesture10,
        R.string.tb_talkbackgesture10_sub
    )
    private val gesture11 = Gesture(
        R.drawable.icon_infos,
        R.string.tb_talkbackgesture_links,
        R.string.tb_talkbackgesture_credits
    )

    val allGestures = listOf<Gesture>(
        gesture1,
        gesture2,
        gesture3,
        gesture4,
        gesture5,
        gesture6,
        gesture7,
        gesture8,
        gesture9,
        gesture10,
        gesture11
    )

}

