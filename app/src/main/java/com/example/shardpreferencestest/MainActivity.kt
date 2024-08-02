package com.example.shardpreferencestest

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val restoreButton : Button = findViewById(R.id.restoreButton)
        val savebutton : Button = findViewById(R.id.saveButton)
        savebutton.setOnClickListener{
            val editor = getSharedPreferences("data",Context.MODE_PRIVATE).edit()
            editor.putString("name","Tom")
            editor.putInt("age",28)
            editor.putBoolean("married",false)
            editor.apply()
        }

        restoreButton.setOnClickListener {
            val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
            val name = prefs.getString("name","")
            val age = prefs.getInt("age",0)
            val married = prefs.getBoolean("married",false)
            Log.d("MainActivity","name is $name")
            Log.d("MainActivity","age is $age")
            Log.d("MainActivity","married is $married")
        }
    }
}