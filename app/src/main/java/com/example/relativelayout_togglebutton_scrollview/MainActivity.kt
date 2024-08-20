package com.example.relativelayout_togglebutton_scrollview

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var loadBTN: Button
    private lateinit var contentTV: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadBTN = findViewById(R.id.loadBTN)
        contentTV = findViewById(R.id.contentTV)
        loadBTN.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val book = database(resources.getString(R.string.content))
        contentTV.text = ""
        for (temp in loadBook(book.text)) contentTV.append(temp)
    }
}

fun loadBook(text: String): List<String> = listOf(text.trim(' '))