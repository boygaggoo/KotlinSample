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

package com.vlad1m1r.kotlintest.data.interactors

import com.vlad1m1r.kotlintest.data.ApiInterface
import com.vlad1m1r.kotlintest.data.models.ItemPhoto
import com.vlad1m1r.kotlintest.data.models.PhotoData
import io.reactivex.Observable


class GetPhotos(val apiInterface: ApiInterface) {
    fun getPhotos(offset:Int, limit:Int):Observable<ArrayList<ItemPhoto>> {
        return this.apiInterface
                .getPhotos(offset, limit)
                .map({list:ArrayList<PhotoData> ->  formatData(list)})
    }

    fun formatData(photos:List<PhotoData>) : ArrayList<ItemPhoto> {
        val itemPhotos:ArrayList<ItemPhoto>  = ArrayList(photos.size)
        photos.mapTo(itemPhotos) { ItemPhoto(it.title.orEmpty(), it.url.orEmpty()) }
        return itemPhotos
    }
}