package com.vxg.mrrtest.service.manager

import android.content.Context

import com.vxg.mrrtest.service.entity.Book
import com.vxg.mrrtest.service.RetrofitHelper
import com.vxg.mrrtest.service.RetrofitService

import rx.Observable

/**
 * Created by vxg on 2017-10-17-0017.
 */

class DataManager(context: Context) {
    private val mRetrofitService: RetrofitService = RetrofitHelper.getInstance(context).server

    fun getSearchBooks(name: String, tag: String?, start: Int, count: Int): Observable<Book> =
            mRetrofitService.getSearchBook(name, tag, start, count)
}
