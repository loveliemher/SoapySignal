package com.example.soapysignal.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.soapysignal.R
import com.example.soapysignal.history.HistoryActivity

class HomeActivity : Activity(), HomeView {

    private lateinit var presenter: HomePresenter
    private lateinit var tvHousehold: TextView
    private lateinit var tvGreeting: TextView
    private lateinit var tvLiveStatus: TextView
    private lateinit var tvLastUpdated: TextView
    private lateinit var tvSpinSession: TextView
    private lateinit var btnHome: LinearLayout
    private lateinit var btnHistory: LinearLayout
    private lateinit var btnSettings: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        tvHousehold = findViewById(R.id.tvHousehold)
        tvGreeting = findViewById(R.id.tvGreeting)
        tvLiveStatus = findViewById(R.id.tvLiveStatus)
        tvLastUpdated = findViewById(R.id.tvLastUpdated)
        tvSpinSession = findViewById(R.id.tvSpinSession)
        btnHome = findViewById(R.id.btnHome)
        btnHistory = findViewById(R.id.btnHistory)
        btnSettings = findViewById(R.id.btnSettings)

        presenter = HomePresenter(this, HomeModel())
        presenter.loadHomeData()

        btnHistory.setOnClickListener {
            presenter.onHistoryClicked()
        }
    }

    override fun showLiveStatus(status: String, color: Int) {
        tvLiveStatus.text = status
        tvLiveStatus.setTextColor(color)
    }

    override fun showLastUpdated(time: String) {
        tvLastUpdated.text = "Last Updated: $time"
    }

    override fun showSpinSessionDetails(session: String, startTime: String, usedBy: String) {
        tvSpinSession.text = "Spin Session of the Day: $session\nStarted: $startTime\nUsed by: $usedBy"
    }

    override fun showGreetingMessage(message: String) {
        tvGreeting.text = message
    }
    override fun navigateToHome(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
    override fun navigateToHistory(){
       val intent = Intent(this, HistoryActivity::class.java)
        startActivity(intent)
        finish()
    }
    //override fun navigateToSettings(){
    //    val intent = Intent(this, HistoryActivity::class.java)
    //    startActivity(intent)
    //    finish()
    //}
}
