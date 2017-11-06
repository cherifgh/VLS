package com.jcdecaux.gcif.vls.data.remote.model

/**
 * {
"name" : "Paris",
"commercial_name" : "Vélib'",
"country_code" : "FR",
"cities" : [
"Paris",
"Neuilly",
...
]
}
 * @author cherif
 * @since 03/11/17.
 */
data class Contract(
        val name: String,
        val commercial_name: String,
        val country_code: String,
        val cities: List<String>
)