package com.example.led_app.domain

import ServerResponse

class LedData(
    val ledName: String = "A",
    val ipAddress: String = "127.0.0.1",
    val ledModes: List<OptionRequestData> = listOf(OptionRequestData("rain", "/rain")),
    val changeModes: List<OptionRequestData> = listOf(OptionRequestData("snake", "/snake"))
) {
    companion object {
        fun buildBaseOnServerResponse(serverResponse: ServerResponse, name: String, ipAddress: String): LedData {
            return LedData(name, ipAddress, serverResponse.ledModes, serverResponse.changeModes)
        }
    }

}


