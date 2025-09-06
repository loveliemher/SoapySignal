package com.example.soapysignal.home

interface HomeView {
    fun showGreetingMessage(message: String)
    fun showLiveStatus(status: String, color: Int)
    fun showLastUpdated(time: String)
    fun showSpinSessionDetails(session: String, startTime: String, usedBy: String)
    fun navigateToHome()
    fun navigateToHistory()
}
