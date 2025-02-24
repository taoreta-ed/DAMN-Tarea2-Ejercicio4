package com.example.damn_tarea2_ejercicio4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class StatesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_states)

        val country = intent.getStringExtra("country")
        val textCountry = findViewById<TextView>(R.id.textCountry)
        textCountry.text = "Estados de $country"

        // Ejemplo de cómo guardar un punto de interés
        val buttonAddPoint = findViewById<Button>(R.id.buttonAddPoint)
        buttonAddPoint.setOnClickListener {
            val point = PointOfInterest("Punto en $country", "Descripción del punto", "Estado")
            DataStorage.savePointOfInterest(this, point)
            Toast.makeText(this, "Punto de interés guardado", Toast.LENGTH_SHORT).show()
        }

        // Ejemplo de cómo recuperar los puntos de interés
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
    }
}