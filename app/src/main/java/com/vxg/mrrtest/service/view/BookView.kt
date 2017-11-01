package com.vxg.mrrtest.service.view

import com.vxg.mrrtest.service.entity.Book

/**
 * Created by vxg on 2017-10-17-0017.
 */

interface BookView : IView {
    fun onSuccess(book: Book)
    fun onError(result: String)
}
