package com.example.trainingcourseapp.ui

import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun Context.findActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

/**
 * load data.json from assets
 */
fun Context.loadJsonStrFromAssets(fileName: String): String {
    var jsonString = ""
    try {
        jsonString = assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (e: Exception) {
        e.printStackTrace()
        return jsonString
    }
    return jsonString
}

/**
 * convert json string into list of specific data class
 */
inline fun <reified T> String.fromJson(): List<T> {
    val gson = Gson()
    val listType = object : TypeToken<List<T>>() {}.type
    return gson.fromJson(this, listType)
}