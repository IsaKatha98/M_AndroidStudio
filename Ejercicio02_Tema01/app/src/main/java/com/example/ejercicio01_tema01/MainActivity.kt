package com.example.ejercicio01_tema01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.ejercicio01_tema01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding=ActivityMainBinding.inflate (layoutInflater)
        setContentView(R.layout.activity_main)
    }
}