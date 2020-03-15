package com.bobs.mapque.keyhash

import android.app.Activity
import android.content.pm.PackageManager
import android.util.Base64
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bobs.baselibrary.base.BaseViewModel
import com.bobs.baselibrary.util.loge
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.security.MessageDigest

class KeyHashViewModel : BaseViewModel() {
    private val _keyHashData: MutableLiveData<KeyHashData> = MutableLiveData<KeyHashData>()
    val keyHashData: LiveData<KeyHashData>
        get() = _keyHashData

    fun setKeyHash(activity: Activity) {
        addDisposable(
            Observable.just(_keyHashData)
                .subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val info = activity.packageManager.getPackageInfo(
                        activity.packageName,
                        PackageManager.GET_SIGNATURES
                    )
                    for (sign in info.signatures) {
                        val md = MessageDigest.getInstance("SHA")
                        md.update(sign.toByteArray())
                        val key = Base64.encodeToString(md.digest(), Base64.DEFAULT)
                        loge(key)
                        it.value = KeyHashData(key)
                        loge(it.value?.hashkey.toString())
                    }
                }, {
                    loge(it.message.toString())
                })
        )
    }
}