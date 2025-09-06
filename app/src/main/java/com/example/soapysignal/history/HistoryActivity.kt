package com.example.soapysignal.history

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.example.soapysignal.R

class HistoryActivity : Activity(), HistoryView {

    private lateinit var presenter: HistoryPresenter

    private lateinit var tvNoHistory: TextView
    private lateinit var tvInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        // Bind UI
        //tvNoHistory = findViewById(R.id.tvNoHistory)
        //tvInfo = findViewById(R.id.tvInfo)

        presenter = HistoryPresenter(this, HistoryModel())
        presenter.loadHistory()
    }

     override fun showNoHistory() {
        //tvNoHistory.text = getString(R.string.no_history)
        //tvInfo.text = getString(R.string.status_info)
    }

    override fun showHistory(history: List<String>) {
        //tvNoHistory.text = getString(R.string.history_found)
        tvInfo.text = history.joinToString("\n")
    }
}