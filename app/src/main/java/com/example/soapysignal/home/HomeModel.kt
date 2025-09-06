package com.example.soapysignal.home

class HomeModel {

    fun getUserName(): String = "John"
    fun getHouseholdName(): String = "Santos Household"

    fun getLiveStatus(): Pair<String, Int> {
        // status text, and color resource ID
        return Pair("Spinning", android.graphics.Color.GREEN)
    }

    fun getLastUpdated(): String = "9/24/2025 10:30 AM"

    fun getSpinSessionDetails(): Triple<String, String, String> {
        return Triple("1", "August 24, 2025 10:30 AM", "John Santos")
    }
}
