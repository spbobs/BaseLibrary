package com.bobs.baselibrary.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel(){
    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(d: CompositeDisposable){
        compositeDisposable.add(d)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}