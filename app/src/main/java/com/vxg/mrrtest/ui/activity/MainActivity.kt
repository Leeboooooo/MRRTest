package com.vxg.mrrtest.ui.activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.vxg.mrrtest.R
import com.vxg.mrrtest.service.entity.Book
import com.vxg.mrrtest.service.presenter.BookPresenter
import com.vxg.mrrtest.service.view.BookView

class MainActivity : AppCompatActivity() {
    private var tv_books_info : TextView ?= null
    private var ed_content : EditText ?= null
    private var searchContent = ""
    private val mContext : Context = this
    private var mBookPresenter: BookPresenter = BookPresenter(this);
    private val mBookView = object : BookView {

        override fun onError(result: String) {
            Toast.makeText(mContext,result,Toast.LENGTH_SHORT).show()
        }

        override fun onSuccess(book: Book) {
            tv_books_info!!.text = book.debug()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        tv_books_info = findViewById(R.id.tv_books_info) as TextView?
        ed_content = findViewById(R.id.editText) as EditText?
        findViewById(R.id.btn_quest).setOnClickListener {
            searchContent = ed_content!!.text.toString()
            mBookPresenter.getSearchBooks(searchContent,null,0,1)
        }
        mBookPresenter.onCreate()
        mBookPresenter.attachView(mBookView)
    }

}
