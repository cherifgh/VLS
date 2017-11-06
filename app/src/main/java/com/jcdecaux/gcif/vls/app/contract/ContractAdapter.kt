package com.jcdecaux.gcif.vls.app.contract

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.jcdecaux.gcif.vls.R
import com.jcdecaux.gcif.vls.data.local.model.Contract
import kotlinx.android.synthetic.main.contract_item.view.*

/**
 * @author cherif
 * @since 04/11/17.
 */
class ContractAdapter(
        private val context: Context,
        private var contracts: List<Contract>
) : RecyclerView.Adapter<ContractAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contracts[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = View.inflate(context, R.layout.contract_item, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contracts.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Contract) = with(itemView) {
            nameTextView.text = item.name
            commercialNameTextView.text = item.commercialName
        }
    }

    fun populateList(contracts: List<Contract>) {
        this.contracts = contracts

        notifyDataSetChanged()
    }
}