package com.jcdecaux.gcif.vls.app.main

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * @author cherif
 * @since 04/11/17.
 */
class MainPresenterTest {

    @Mock
    private lateinit var mView: MainContract.View

    private lateinit var mPresenter: MainContract.Presenter

    @Before
    fun setupPresenter() {
        MockitoAnnotations.initMocks(this)

        mPresenter = MainPresenter(mView)

        `when`(mView.isActive).thenReturn(true)
    }

    @Test
    fun createPresenter() {
        mPresenter = MainPresenter(mView)

        verify(mView).setPresenter(mPresenter)
    }

    @Test
    fun clickOnContracts_ShowContracts() {
        mPresenter.openContractsScreen()

        verify(mView).showContractsActivity()
    }
}