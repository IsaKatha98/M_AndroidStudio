package com.example.ejercicio01_tema01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.concat
import android.widget.Toast
import android.content.Intent
import com.example.ejercicio01_tema01.databinding.ActivityMainBinding
import com.example.ejercicio01_tema01.databinding.BienvenidaBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var boton = binding.button

        boton.setOnClickListener {

                val toast= Toast.makeText(
                    applicationContext,
                    "Me has pulsado",
                    Toast.LENGTH_SHORT
                ).show()

            val oBinding= BienvenidaBinding.inflate(layoutInflater)
            setContentView(oBinding.root)

            val intent = Intent(this , Bienvenida::class.java)
            intent.putExtra("usuario", binding.tvUser.text.toString())
            startActivity(intent)
           /* if(binding.tvUser.text.toString().isEmpty() || binding.tvUser.text.toString().isEmpty()){
                Toast.makeText(applicationContext, "Error al iniciar sesión", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this , Bienvenida::class.java)
                intent.putExtra("usuario", binding.tvUser.text.toString())
                startActivity(intent)
                Toast.makeText(applicationContext, "Iniciando sesión..." + binding.tvUser.text.toString(), Toast.LENGTH_SHORT).show()
            }

*/





        }
    }

}