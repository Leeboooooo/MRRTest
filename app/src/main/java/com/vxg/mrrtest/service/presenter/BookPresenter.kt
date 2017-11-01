package com.vxg.mrrtest.service.presenter

import android.content.Context
import android.content.Intent
import android.view.View
import com.vxg.mrrtest.service.entity.Book
import com.vxg.mrrtest.service.manager.DataManager
import com.vxg.mrrtest.service.view.BookView
import com.vxg.mrrtest.service.view.IView
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by vxg on 2017-10-17-0017.
 */

class BookPresenter(private val mContext: Context) : Presenter {
    private var manager : DataManager? = null
    private var mCompositeSubscription : CompositeSubscription? = null
    private var mBookView : BookView? = null
    private var mBook : Book? = null

    override fun onCreate() {
        manager = DataManager(mContext)
        mCompositeSubscription = CompositeSubscription()
    }

    override fun onStart() {

    }

    override fun onStop() {
        if (mCompositeSubscription?.hasSubscriptions()!!){
            mCompositeSubscription!!.unsubscribe()
        }
    }

    override fun pause() {

    }

    override fun attachView(view: IView) {
        mBookView = view as BookView
    }

    override fun attachIncomingIntent(intent: Intent) {

    }

    fun getSearchBooks(name:String, tag: String?, start:Int, count:Int){
        mCompositeSubscription?.add(manager!!.getSearchBooks(name,tag,start, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Book>{
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                    override fun onNext(t: Book?) {
                        mBook= t
                    }

                    override fun onCompleted() {
                        if (mBook != null) {
                            mBookView!!.onSuccess(mBook!!)
                        }
                    }

                }))
    }
}
