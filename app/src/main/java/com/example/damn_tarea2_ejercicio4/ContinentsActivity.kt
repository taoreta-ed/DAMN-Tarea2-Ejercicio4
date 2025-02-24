package com.example.damn_tarea2_ejercicio4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ContinentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_continents)

        val buttonAfrica = findViewById<Button>(R.id.buttonAfrica)
        buttonAfrica.setOnClickListener { navigateToCountries("África") }

        val buttonAmerica = findViewById<Button>(R.id.buttonAmerica)
        buttonAmerica.setOnClickListener { navigateToCountries("América") }

        val buttonAsia = findViewById<Button>(R.id.buttonAsia)
        buttonAsia.setOnClickListener { navigateToCountries("Asia") }

        val buttonEurope = findViewById<Button>(R.id.buttonEurope)
        buttonEurope.setOnClickListener { navigateToCountries("Europa") }

        val buttonOceania = findViewById<Button>(R.id.buttonOceania)
        buttonOceania.setOnClickListener { navigateToCountries("Oceanía") }

        // Ejemplo de cómo guardar un punto de interés
        val buttonAddPoint = findViewById<Button>(R.id.buttonAddPoint)
        buttonAddPoint.setOnClickListener {
            val point = PointOfInterest("Punto en un Continente", "Descripción del punto", "Continente")
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

    private fun navigateToCountries(continent: String) {
        val intent = Intent(this, CountriesActivity::class.java)
        intent.putExtra("continent", continent)
        startActivity(intent)
    }
}