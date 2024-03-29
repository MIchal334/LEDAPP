package com.example.led_app.domain

import ServerResponse


class LedData(
    val ledName: String = "A",
    val ipAddress: String = "127.0.0.1",
    val ledModes: List<LedModeData> = listOf(LedModeData(1, 1, "rain", 1)),
    val changeModes: List<ChangeModeData> = listOf(ChangeModeData(1, 1, "snake", 1))
) {

    companion object {
        fun buildBaseOnServerResponse(serverResponse: ServerResponse, name: String, ipAddress: String): LedData {
            return LedData(name, ipAddress, serverResponse.ledModes, serverResponse.changeModes)
        }
    }

}


