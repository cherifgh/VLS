package com.jcdecaux.gcif.vls.data.local.model


/**
 * @author cherif
 * @since 03/11/17.
 */
data class Contract
internal constructor(
        val name: String,
        val commercialName: String,
        val countryCode: String,
        val cities: List<String>
) {
    companion object {
        fun from(remote: com.jcdecaux.gcif.vls.data.remote.model.Contract): Contract = with(remote) {
            return Contract(name, commercial_name, country_code, cities)
        }

        fun from(remoteList: List<com.jcdecaux.gcif.vls.data.remote.model.Contract>): List<Contract> {
            return remoteList.map { from(it) }
        }
    }
}