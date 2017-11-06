package com.jcdecaux.gcif.vls.app.contract

import com.jcdecaux.gcif.vls.data.ContractRepository
import com.jcdecaux.gcif.vls.data.local.model.Contract
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
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
class ContractPresenterTest {
    private lateinit var CONTRACTS: List<Contract>

    @Mock
    private lateinit var mRepository: ContractRepository

    @Mock
    private lateinit var mView: ContractContract.View

    private lateinit var mScheduler: Scheduler
    private lateinit var mPresenter: ContractContract.Presenter

    @Before
    fun setupPresenter() {
        MockitoAnnotations.initMocks(this)

        mScheduler = Schedulers.trampoline()
        mPresenter = ContractPresenter(mRepository, mView, mScheduler)

        `when`(mView.isActive).thenReturn(true)

        CONTRACTS = listOf(
                Contract("Name 1", "Commercial name 1", "FR",
                        listOf("City 1", "City 2")),
                Contract("Name 2", "Commercial name 2", "FR",
                        listOf("City 3", "City 4")),
                Contract("Name 3", "Commercial name 3", "FR",
                        listOf("City 5", "City 6")),
                Contract("Name 4", "Commercial name 4", "FR",
                        listOf("City 7", "City 8")),
                Contract("Name 5", "Commercial name 5", "FR",
                        listOf("City 9", "City 10"))
        )
    }

    @Test
    fun createPresenter() {
        mPresenter = ContractPresenter(mRepository, mView, mScheduler)

        verify(mView).setPresenter(mPresenter)
    }

    @Test
    fun loadContracts() {
        `when`(mRepository.getAll()).thenReturn(Flowable.just(CONTRACTS))

        mPresenter.loadContracts()

        verify(mView).setLoading(true)
        verify(mView).setLoading(false)
    }

    @Test
    fun errorLoadingContracts_ShowError() {
        val exception = Exception()

        `when`(mRepository.getAll()).thenReturn(Flowable.error(exception))

        mPresenter.loadContracts()

        verify(mView).showLoadContractsError(exception)
    }
}