package com.jcdecaux.gcif.vls

/**
 * @author cherif
 * @since 04/11/17.
 */
interface BaseView<T> {
    fun setPresenter(presenter: T)
}