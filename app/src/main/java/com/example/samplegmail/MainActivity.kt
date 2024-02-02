package com.example.samplegmail

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var emails: MutableList<Email>
    private lateinit var emailAdapter: EmailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

        findViewById<Button>(R.id.loadMoreBtn).setOnClickListener {
            loadMoreEmails()
        }
    }

    private fun setupRecyclerView() {
        val emailView = findViewById<RecyclerView>(R.id.recyclerView)
        emails = EmailFetcher.getEmails().toMutableList()
        emailAdapter = EmailAdapter(emails)
        emailView.adapter = emailAdapter
        emailView.layoutManager = LinearLayoutManager(this)
    }

    private fun loadMoreEmails() {
        val newEmails = EmailFetcher.getNext5Emails()
        emails.addAll(newEmails)
        emailAdapter.notifyDataSetChanged()
    }
}
