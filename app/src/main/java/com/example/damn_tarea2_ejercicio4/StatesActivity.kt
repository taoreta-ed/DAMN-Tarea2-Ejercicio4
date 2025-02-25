package com.example.damn_tarea2_ejercicio4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class StatesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_states)

        val country = intent.getStringExtra("country") ?: ""
        val textCountry = findViewById<TextView>(R.id.textCountry)
        textCountry.text = "Estados de $country"

        // Set the background based on the country
        val rootLayout = findViewById<ConstraintLayout>(R.id.statesRootLayout)
        when (country) {
            "Egipto" -> rootLayout.setBackgroundResource(R.drawable.egipto)
            "Sudáfrica" -> rootLayout.setBackgroundResource(R.drawable.sudafrica)
            "Nigeria" -> rootLayout.setBackgroundResource(R.drawable.nigeria)
            "Estados Unidos" -> rootLayout.setBackgroundResource(R.drawable.eeuu)
            "Canadá" -> rootLayout.setBackgroundResource(R.drawable.canada)
            "Brasil" -> rootLayout.setBackgroundResource(R.drawable.brasil)
            "Japón" -> rootLayout.setBackgroundResource(R.drawable.japon)
            "China" -> rootLayout.setBackgroundResource(R.drawable.china)
            "India" -> rootLayout.setBackgroundResource(R.drawable.india)
            "España" -> rootLayout.setBackgroundResource(R.drawable.espana)
            "Francia" -> rootLayout.setBackgroundResource(R.drawable.francia)
            "Alemania" -> rootLayout.setBackgroundResource(R.drawable.alemania)
            "Australia" -> rootLayout.setBackgroundResource(R.drawable.australia)
            "Nueva Zelanda" -> rootLayout.setBackgroundResource(R.drawable.nuevazelanda)
            "Fiyi" -> rootLayout.setBackgroundResource(R.drawable.fiyi)
            else -> rootLayout.setBackgroundResource(R.drawable.earth) // Default background
        }

        // Get the states for the selected country
        val states = StateData.statesByCountry[country] ?: emptyList()

        // Set the button texts dynamically
        val buttonState1 = findViewById<Button>(R.id.buttonState1)
        val buttonState2 = findViewById<Button>(R.id.buttonState2)

        if (states.isNotEmpty()) {
            buttonState1.text = states[0]
        } else {
            buttonState1.isEnabled = false
        }

        if (states.size > 1) {
            buttonState2.text = states[1]
        } else {
            buttonState2.isEnabled = false
        }

        // Example of how to save a point of interest
        val buttonAddPoint = findViewById<Button>(R.id.buttonAddPoint)
        buttonAddPoint.setOnClickListener {
            val point = PointOfInterest("Punto en $country", "Descripción del punto", "Estado")
            DataStorage.savePointOfInterest(this, point)
            Toast.makeText(this, "Punto de interés guardado", Toast.LENGTH_SHORT).show()
        }

        // Example of how to retrieve points of interest
        val buttonShowPoints = findViewById<Button>(R.id.buttonShowPoints)
        buttonShowPoints.setOnClickListener {
            val points = DataStorage.getPointsOfInterest(this)
            val message = if (points.isEmpty()) {
                "No hay puntos de interés"
            } else {
                points.joinToString("\n") { "${it.name}: ${it.description}" }
            }
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }

        // Back button
        val buttonBack = findViewById<Button>(R.id.buttonBack)
        buttonBack.setOnClickListener {
            finish() // Closes the current activity and returns to the previous one
        }
    }
}