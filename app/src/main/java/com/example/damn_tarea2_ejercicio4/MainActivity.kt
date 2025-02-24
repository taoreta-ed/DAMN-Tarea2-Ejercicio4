package com.example.damn_tarea2_ejercicio4

import android.content.Intent
import android.os.Bundle
import android.widget.Button // Import the Button class
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonExplore = findViewById<Button>(R.id.buttonExplore)
        buttonExplore.setOnClickListener {
            val intent = Intent(this, ContinentsActivity::class.java)
            startActivity(intent)
        }
    }
}