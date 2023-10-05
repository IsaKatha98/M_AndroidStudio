package com.example.ejercicio01_tema01

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.concat
import android.widget.Toast
import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.View
import androidx.core.app.NotificationCompat
import com.example.ejercicio01_tema01.databinding.ActivityMainBinding
import com.example.ejercicio01_tema01.databinding.BienvenidaBinding
import com.example.ejercicio01_tema01.databinding.PausaBinding


class MainActivity : AppCompatActivity() {

    var parar= false
    var nombre =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("act","on create")

    }

    override fun onStart () {

        super.onStart()

        Log.i("act","on start")

    }

    override fun onResume() {

        super.onResume()

        Log.i("act","on resume")


        val binding = ActivityMainBinding.inflate(layoutInflater)
        val calcB = BienvenidaBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var boton = binding.button
        var vuelta=calcB.btnBack
        var suma= calcB.btnSuma
        var resta=calcB.btnResta
        var mult=calcB.btnMult
        var div= calcB.btnDiv
        var numUno= calcB.numPrimerFact.text.toString()
        var numDos= calcB.numSegundoFact.text.toString()

        if (parar) {

            setContentView(calcB.root)

            parar=false


        } else {

            //El botón que va del login hacia la calculadora
            boton.setOnClickListener {

                val toast = Toast.makeText(
                    applicationContext,
                    "Palante",
                    Toast.LENGTH_SHORT
                ).show()

                //vista de la calculadora
                setContentView(calcB.root)



                //botón que va de la calculadora al login
                vuelta.setOnClickListener() {

                    val toast = Toast.makeText(
                        applicationContext,
                        "Patrás",
                        Toast.LENGTH_SHORT
                    ).show()

                    setContentView(binding.root)

                }

                var numUno= calcB.numPrimerFact.text.toString()
                var numDos= calcB.numSegundoFact.text.toString()

                //botón que suma
                suma.setOnClickListener() {

                    var res=0.0

                    if (numUno.isEmpty()){

                        Log.i("act","el primer num era 0")
                        var  uno= numUno.toDouble()
                        uno=0.0

                        res= (uno.toDouble())+(numDos.toDouble())


                    } else if (numDos.isEmpty()) {

                        Log.i("act","el segundo num era 0")
                      var dos= numDos.toDouble()

                        dos=0.0

                        res=(numUno.toDouble())+(dos.toDouble())


                    } else {

                        Log.i ("act","suma")

                        res= (numUno.toDouble())+(numDos.toDouble())
                    }


                    calcB.res.text="$res"
                }

                //botón que resta
                resta.setOnClickListener() {

                    var res=0.0

                    if (numUno.isEmpty()){

                        Log.i("act","el primer num era 0")
                        var  uno= numUno.toDouble()
                        uno=0.0

                        res= (uno.toDouble())-(numDos.toDouble())


                    } else if (numDos.isEmpty()) {

                        Log.i("act","el segundo num era 0")
                        var dos= numDos.toDouble()

                        dos=0.0

                        res=(numUno.toDouble())-(dos.toDouble())


                    } else {

                        Log.i ("act","suma")

                        res= (numUno.toDouble())-(numDos.toDouble())
                    }


                    calcB.res.text="$res"
                }

                //botón que suma
                mult.setOnClickListener() {

                    var res=0.0

                    if (numUno.isEmpty()){

                        Log.i("act","el primer num era 0")
                        var  uno= numUno.toDouble()
                        uno=0.0

                        res= (uno.toDouble())*(numDos.toDouble())


                    } else if (numDos.isEmpty()) {

                        Log.i("act","el segundo num era 0")
                        var dos= numDos.toDouble()

                        dos=0.0

                        res=(numUno.toDouble())*(dos.toDouble())


                    } else {

                        Log.i ("act","suma")

                        res= (numUno.toDouble())*(numDos.toDouble())
                    }


                    calcB.res.text="$res"
                }



            }
        }

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


        val calcB = com.example.ejercicio01_tema01.databinding.CalculadoraBinding.inflate(layoutInflater)
        setContentView(calcB.root)


    }

    override fun onDestroy() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "mi_canal_id"
            val channelName = "Mi Canal de Notificación"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, channelName, importance)

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }

        // Crea un intent para abrir una actividad cuando se toque la notificación
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        // Crea la notificación
        val notificationBuilder = NotificationCompat.Builder(this, "mi_canal_id")
            .setSmallIcon(R.drawable.noti)
            .setContentTitle("Cierre de sesión")
            .setContentText("Se ha cerrado la sesión de $nombre")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true) // Cierra la notificación al tocarla
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // Muestra la notificación
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.notify(1, notificationBuilder.build())

        super.onDestroy()
    }



}





