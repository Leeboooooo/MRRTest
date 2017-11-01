package com.vxg.mrrtest.service

import com.vxg.mrrtest.service.entity.Book

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by vxg on 2017-10-17-0017.
 */

interface RetrofitService {
    @GET("book/search")
    fun getSearchBook(@Query("q") name: String,
                      @Query("tag") tag: String?,
                      @Query("start") start: Int,
                      @Query("count") count: Int): Observable<Book>
}
