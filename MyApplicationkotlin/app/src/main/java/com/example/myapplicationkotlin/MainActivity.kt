package com.example.myapplicationkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var progr = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateProgressBar()
        val button_incr = findViewById<Button>(R.id.button_incr)
        val button_decr = findViewById<Button>(R.id.button_decr)


        button_incr.setOnClickListener {
            if (progr <= 90) {
                progr += 10
                updateProgressBar()
            }
        }

        button_decr.setOnClickListener {
            if (progr >= 10) {
                progr -= 10
                updateProgressBar()
            }
        }
    }

    private fun updateProgressBar() {
        val progress_bar = findViewById<ProgressBar>(R.id.progress_bar)
        val text_view_progress = findViewById<TextView>(R.id.text_view_progress)

        progress_bar.progress = progr
        text_view_progress.text = "$progr%"
    }
}