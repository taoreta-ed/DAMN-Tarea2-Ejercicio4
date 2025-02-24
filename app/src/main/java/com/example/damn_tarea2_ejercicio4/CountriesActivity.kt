package com.example.damn_tarea2_ejercicio4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class CountriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)

        val continent = intent.getStringExtra("continent")
        val textContinent = findViewById<TextView>(R.id.textContinent)
        textContinent.text = "Países de $continent"

        val buttonCountry1 = findViewById<Button>(R.id.buttonCountry1)
        buttonCountry1.setOnClickListener { navigateToStates("País 1") }

        val buttonCountry2 = findViewById<Button>(R.id.buttonCountry2)
        buttonCountry2.setOnClickListener { navigateToStates("País 2") }

        val buttonCountry3 = findViewById<Button>(R.id.buttonCountry3)
        buttonCountry3.setOnClickListener { navigateToStates("País 3") }

        // Ejemplo de cómo guardar un punto de interés
        val buttonAddPoint = findViewById<Button>(R.id.buttonAddPoint)
        buttonAddPoint.setOnClickListener {
            val point = PointOfInterest("Punto en $continent", "Descripción del punto", "País")
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

        // Botón de regreso
        val buttonBack = findViewById<Button>(R.id.buttonBack)
        buttonBack.setOnClickListener {
            finish() // Cierra la actividad actual y regresa a la anterior
        }
    }

    private fun navigateToStates(country: String) {
        val intent = Intent(this, StatesActivity::class.java)
        intent.putExtra("country", country)
        startActivity(intent)
    }
}