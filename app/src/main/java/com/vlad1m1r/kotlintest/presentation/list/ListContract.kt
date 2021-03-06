/*
 * Copyright 2017 Vladimir Jovanovic
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vlad1m1r.kotlintest.presentation.list

import android.support.annotation.StringRes
import com.vlad1m1r.kotlintest.data.models.ItemPhoto
import com.vlad1m1r.kotlintest.presentation.base.IBasePresenter
import com.vlad1m1r.kotlintest.presentation.base.IViewError

import java.util.ArrayList

interface ListContract {

    interface Presenter : IBasePresenter {
        fun loadData(offset:Int = 0)
        fun loadingDataError(@StringRes error: Int)
    }

    interface View : IViewError {
        fun setPresenter(presenter: Presenter)
        fun loadData()
        fun showList(list: ArrayList<ItemPhoto>)
        fun addList(list: ArrayList<ItemPhoto>)
    }
}