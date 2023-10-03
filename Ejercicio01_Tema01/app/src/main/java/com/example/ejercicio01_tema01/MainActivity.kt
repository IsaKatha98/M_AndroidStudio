package com.example.ejercicio01_tema01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejercicio01_tema01.databinding.ActivityMainBinding
import com.example.ejercicio01_tema01.databinding.BienvenidaBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var boton = binding.button

        boton.setOnClickListener {
            val toast = Toast.makeText(
                applicationContext,
                "Me has pulsado",
                Toast.LENGTH_SHORT
            ).show()

            val otroBinding= BienvenidaBinding.inflate(layoutInflater)
            setContentView(otroBinding.root)

        }
    }

}