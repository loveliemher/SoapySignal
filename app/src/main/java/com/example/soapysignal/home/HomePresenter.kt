package com.example.soapysignal.home

class HomePresenter(
    private val view: HomeView,
    private val model: HomeModel
) {
    fun loadHomeData() {
        val name = model.getUserName()
        val household = model.getHouseholdName()
        view.showGreetingMessage("Hello $name!\n($household)")

        val (status, color) = model.getLiveStatus()
        view.showLiveStatus(status, color)

        view.showLastUpdated(model.getLastUpdated())

        val (session, startTime, usedBy) = model.getSpinSessionDetails()
        view.showSpinSessionDetails(session, startTime, usedBy)
    }
    fun onHistoryClicked() {
        view.navigateToHistory()
    }
}
