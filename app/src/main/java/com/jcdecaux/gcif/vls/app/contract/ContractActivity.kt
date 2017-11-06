package com.jcdecaux.gcif.vls.app.contract

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.jcdecaux.gcif.vls.R
import com.jcdecaux.gcif.vls.app
import com.jcdecaux.gcif.vls.data.local.model.Contract
import com.jcdecaux.gcif.vls.data.remote.ContractService
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_contract.*
import javax.inject.Inject

class ContractActivity : AppCompatActivity(), ContractContract.View {
    override var isActive: Boolean = false

    private lateinit var mPresenter: ContractContract.Presenter
    private lateinit var mAdapter: ContractAdapter

    override fun setPresenter(presenter: ContractContract.Presenter) {
        mPresenter = presenter
    }

    @Inject
    lateinit var contractService: ContractService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contract)

        app().component.inject(this)

        initWidgets()

        mPresenter = ContractPresenter(contractService, this, AndroidSchedulers.mainThread())

        isActive = true
    }

    override fun onResume() {
        super.onResume()

        mPresenter.subscribe()
    }

    override fun onPause() {
        super.onPause()

        mPresenter.unsubscribe()
    }

    private fun initWidgets() {
        mAdapter = ContractAdapter(this, listOf())

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mAdapter

        button.setOnClickListener {
            mPresenter.loadContracts()
        }
    }

    override fun setLoading(isLoading: Boolean) {

    }

    override fun showContracts(contracts: List<Contract>) {
        mAdapter.populateList(contracts)
    }

    override fun showLoadContractsError(exception: Throwable) {

    }
}