package com.example.damn_tarea2_ejercicio4

import android.content.Context
import android.content.SharedPreferences

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DataStorage {
    private const val PREFS_NAME = "GeoExplorerPrefs"
    private const val POINTS_KEY = "pointsOfInterest"

    fun savePointOfInterest(context: Context, point: PointOfInterest) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val points = getPointsOfInterest(context).toMutableList()
        points.add(point)
        savePoints(prefs, points)
    }

    fun getPointsOfInterest(context: Context): List<PointOfInterest> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(POINTS_KEY, null)
        return if (json != null) {
            val type = object : TypeToken<List<PointOfInterest>>() {}.type
            Gson().fromJson(json, type)
        } else {
            emptyList()
        }
    }

    private fun savePoints(prefs: SharedPreferences, points: List<PointOfInterest>) {
        val editor = prefs.edit()
        val json = Gson().toJson(points)
        editor.putString(POINTS_KEY, json)
        editor.apply()
    }
}