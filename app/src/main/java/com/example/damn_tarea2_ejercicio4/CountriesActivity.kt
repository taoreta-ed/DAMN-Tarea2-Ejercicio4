package com.example.damn_tarea2_ejercicio4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class CountriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_countries)

        val continent = intent.getStringExtra("continent") ?: ""
        val textContinent = findViewById<TextView>(R.id.textContinent)
        textContinent.text = "Países de $continent"

        // Set the background based on the continent
        val rootLayout = findViewById<ConstraintLayout>(R.id.countriesRootLayout)
        when (continent) {
            "África" -> rootLayout.setBackgroundResource(R.drawable.africa)
            "América" -> rootLayout.setBackgroundResource(R.drawable.america)
            "Asia" -> rootLayout.setBackgroundResource(R.drawable.asia)
            "Europa" -> rootLayout.setBackgroundResource(R.drawable.europa)
            "Oceanía" -> rootLayout.setBackgroundResource(R.drawable.oceania)
            else -> rootLayout.setBackgroundResource(R.drawable.earth) // Default background
        }

        // Get the countries for the selected continent
        val countries = CountryData.countriesByContinent[continent] ?: emptyList()

        // Set the button texts dynamically
        val buttonCountry1 = findViewById<Button>(R.id.buttonCountry1)
        val buttonCountry2 = findViewById<Button>(R.id.buttonCountry2)
        val buttonCountry3 = findViewById<Button>(R.id.buttonCountry3)

        if (countries.isNotEmpty()) {
            buttonCountry1.text = countries[0]
            buttonCountry1.setOnClickListener { navigateToStates(countries[0]) }
        } else {
            buttonCountry1.isEnabled = false
        }

        if (countries.size > 1) {
            buttonCountry2.text = countries[1]
            buttonCountry2.setOnClickListener { navigateToStates(countries[1]) }
        } else {
            buttonCountry2.isEnabled = false
        }

        if (countries.size > 2) {
            buttonCountry3.text = countries[2]
            buttonCountry3.setOnClickListener { navigateToStates(countries[2]) }
        } else {
            buttonCountry3.isEnabled = false
        }

        // Example of how to save a point of interest
        val buttonAddPoint = findViewById<Button>(R.id.buttonAddPoint)
        buttonAddPoint.setOnClickListener {
            val point = PointOfInterest("Punto en $continent", "Descripción del punto", "País")
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

    private fun navigateToStates(country: String) {
        val intent = Intent(this, StatesActivity::class.java)
        intent.putExtra("country", country)
        startActivity(intent)
    }
}