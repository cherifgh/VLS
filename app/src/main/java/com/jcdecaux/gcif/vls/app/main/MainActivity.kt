package com.jcdecaux.gcif.vls.app.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jcdecaux.gcif.vls.R
import com.jcdecaux.gcif.vls.app
import com.jcdecaux.gcif.vls.app.contract.ContractActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.View {
    override var isActive: Boolean = false

    private lateinit var mPresenter: MainContract.Presenter

    override fun setPresenter(presenter: MainContract.Presenter) {
        mPresenter = presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        app().component.inject(this)

        initWidgets()

        mPresenter = MainPresenter(this)

        isActive = true
    }

    private fun initWidgets() {
        button.setOnClickListener {
            mPresenter.openContractsScreen()
        }
    }

    override fun showContractsActivity() {
        val intent = Intent(this, ContractActivity::class.java)
        startActivity(intent)
    }
}
