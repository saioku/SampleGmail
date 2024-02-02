package com.example.samplegmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.samplegmail.R

class MainActivity : AppCompatActivity() {
    lateinit var emails: List<Email>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val emailView= findViewById<RecyclerView>(R.id.recyclerView)
        emails = EmailFetcher.getEmails()
        val adapter = EmailAdapter(emails)
        emailView.adapter = adapter
        emailView.layoutManager = LinearLayoutManager(this)
        findViewById<Button>(R.id.loadMoreBtn).setOnClickListener {
            val newEmails = EmailFetcher.getNext5Emails()
            (emails as MutableList<Email>).addAll(newEmails)
            adapter.notifyDataSetChanged()
        }

    }
}