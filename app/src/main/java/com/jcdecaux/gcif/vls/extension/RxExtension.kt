package com.jcdecaux.gcif.vls.extension

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author cherif
 * @since 04/11/17.
 */
fun Disposable.disposeOn(compositeDisposable: CompositeDisposable): Disposable {
    compositeDisposable.add(this)
    return this
}