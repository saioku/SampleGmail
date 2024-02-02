package com.example.samplegmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>) :
    RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    inner class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderTextView: TextView = itemView.findViewById(R.id.sender)
        val titleTextView: TextView = itemView.findViewById(R.id.title)
        val summaryTextView: TextView = itemView.findViewById(R.id.summary)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val emailItemView = inflater.inflate(R.layout.email_item, parent, false)
        return EmailViewHolder(emailItemView)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emails[position]
        with(holder) {
            senderTextView.text = email.sender
            titleTextView.text = email.title
            summaryTextView.text = email.summary
        }
    }

    override fun getItemCount(): Int {
        return emails.size
    }
}
