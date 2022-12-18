package com.example.generator

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fun getRandPassword(n: Int): String
        {
            val characterSet = "!#$%&/()?{}[]¿0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

            val random = Random(System.nanoTime())
            val password = StringBuilder()

            for (i in 0 until n)
            {
                val rIndex = random.nextInt(characterSet.length)
                password.append(characterSet[rIndex])
            }

            return password.toString()
        }


        val boton = findViewById<Button>(R.id.button)
        val special_character = findViewById<Button>(R.id.special_character)
        val ABC = findViewById<Button>(R.id.ABC)
        val abc = findViewById<Button>(R.id.abc)
        val numero = findViewById<Button>(R.id.num)

        special_character.setOnClickListener{
            special_character.setTextColor(Color.GREEN)
        }

        ABC.setOnClickListener{
            ABC.setTextColor(Color.GREEN)
        }

        abc.setOnClickListener{
            abc.setTextColor(Color.GREEN)
        }

        numero.setOnClickListener{
            numero.setTextColor(Color.GREEN)
        }

        boton.setOnClickListener{
            AlertDialog.Builder(this).apply{
                setTitle("Su contraseña es:" )
                setMessage(getRandPassword(16))
                setPositiveButton("Salir"){ _: DialogInterface, _:Int ->
                }


            }.show()




        }
    }
}