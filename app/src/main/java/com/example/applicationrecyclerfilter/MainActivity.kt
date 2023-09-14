package com.example.applicationrecyclerfilter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var noSearchResultsFoundText: TextView
    private val sportsList: List<Sports> = sportsList(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.search_list)
        noSearchResultsFoundText = findViewById(R.id.no_search_results_found_text)

        attachAdapter(sportsList)
        toggleRecyclerView(sportsList)
    }
    private fun attachAdapter(list: List<Sports>) {
        val searchAdapter = SearchAdapter(list)
        recyclerView.adapter = searchAdapter
    }

    private fun toggleRecyclerView(sportsList: List<Sports>) {
        if (sportsList.isEmpty()) {
            recyclerView.visibility = View.INVISIBLE
            noSearchResultsFoundText.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE
            noSearchResultsFoundText.visibility = View.INVISIBLE
        }
    }
}