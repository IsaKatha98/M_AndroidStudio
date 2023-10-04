package com.example.ejercicio01_tema01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.concat
import android.widget.Toast
import android.content.Intent
import android.util.Log
import android.view.View
import com.example.ejercicio01_tema01.databinding.ActivityMainBinding
import com.example.ejercicio01_tema01.databinding.BienvenidaBinding
import com.example.ejercicio01_tema01.databinding.PausaBinding


class MainActivity : AppCompatActivity() {

    var parar= false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("act","on create")

    }

    override fun onStart () {

        super.onStart()

        Log.i("act","on start")

        val principal= BienvenidaBinding.inflate(layoutInflater)
        setContentView(principal.root)


    }

    override fun onResume() {

        super.onResume()

        Log.i("act","on resume")

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val oBinding = BienvenidaBinding.inflate(layoutInflater)


        setContentView(binding.root)

        var boton = binding.button

        var nombre = binding.tvUser.text.toString()

        if (parar) {


            setContentView(oBinding.root)

            oBinding.textHola.text = "Nos alegramos de volver a verte, $nombre"

            parar=false


        } else {

            boton.setOnClickListener {

                val toast = Toast.makeText(
                    applicationContext,
                    "Me has pulsado",
                    Toast.LENGTH_SHORT
                ).show()

                setContentView(oBinding.root)

                oBinding.textHola.text = "Nos alegramos de volver a verte, $nombre"


                /*val intent = Intent(this , Bienvenida::class.java)
            intent.putExtra("usuario", binding.tvUser.text.toString())
            startActivity(intent)*/


            }
        }

        /*Log.i("act", "resuman")
        Toast.makeText(applicationContext, "Bienvenido de vuelta", Toast.LENGTH_SHORT).show()*/


    }
        override fun onPause() {
            super.onPause()

            Log.i("act", "onpause")
            Toast.makeText(applicationContext, "He parado", Toast.LENGTH_SHORT).show()

            val pausa = PausaBinding.inflate(layoutInflater)
            setContentView(pausa.root)

            parar=true




        }

    override fun onStop() {
        super.onStop()
        Log.i("actividad","on stop")

        onRestart()

    }

    override fun onRestart() {
        super.onRestart()

        Log.i("act", "onRestrart")

        Toast.makeText(applicationContext, "Bienvenido de vuelta", Toast.LENGTH_SHORT).show()

        val principal= BienvenidaBinding.inflate(layoutInflater)
        setContentView(principal.root)


    }

    override fun onDestroy() {




        super.onDestroy()
    }



}



           /* if(binding.tvUser.text.toString().isEmpty() || binding.tvUser.text.toString().isEmpty()){
                Toast.makeText(applicationContext, "Error al iniciar sesión", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this , Bienvenida::class.java)
                intent.putExtra("usuario", binding.tvUser.text.toString())
                startActivity(intent)
                Toast.makeText(applicationContext, "Iniciando sesión..." + binding.tvUser.text.toString(), Toast.LENGTH_SHORT).show()
            }

*/




