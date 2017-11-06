package com.jcdecaux.gcif.vls.data.remote.model

import java.util.*

/**
 * {
"number": 123,
"contract_name" : "Paris",
"name": "stations name",
"address": "address of the station",
"position": {
"lat": 48.862993,
"lng": 2.344294
},
"banking": true,
"bonus": false,
"status": "OPEN",
"bike_stands": 20,
"available_bike_stands": 15,
"available_bikes": 5,
"last_update": <timestamp>
}


 * @author cherif
 * @since 03/11/17.
 */
data class Station(
        val number: Int,
        val contract_name: String,
        val name: String,
        val address: String,
        val position: Position,
        val banking: Boolean,
        val bonus: Boolean,
        val status: Status,
        val bike_stands: Int,
        val available_bike_stands: Int,
        val available_bikes: Int,
        val last_update: Date
)