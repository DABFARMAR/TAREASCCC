package com.example.generator

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recorrido: MutableList<String> = mutableListOf("ABCDEFGHIJKLMNOPQRSTUVWXYZ","abcdefghijklmnopqrstuvwxyz","0123456789","!#$%&/()?{}[]¿.,+-")

        fun getRandPassword(n: Int,l: MutableList<String> ): String
        {

            val characterSet = StringBuilder()


            for (i  in  l){
                if (i != "false"){ characterSet.append((i)) }
            }


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
        val cantidad = findViewById<EditText>(R.id.Cantidad)

        special_character.setOnClickListener{
            special_character.setTextColor(Color.GREEN)
            recorrido[3] = false.toString()
        }
        ABC.setOnClickListener{
            ABC.setTextColor(Color.GREEN)
            recorrido[0] = false.toString()
        }

        abc.setOnClickListener{
            abc.setTextColor(Color.GREEN)
            recorrido[1] = false.toString()
        }

        numero.setOnClickListener{
            numero.setTextColor(Color.GREEN)
            recorrido[2] = false.toString()
        }

        boton.setOnClickListener{
            AlertDialog.Builder(this).apply{
                setTitle("Su contraseña es:" )
                setMessage(getRandPassword(cantidad.getText().toString().toInt(),recorrido))
                setPositiveButton("Salir"){ _: DialogInterface, _:Int ->
                }
                ABC.setTextColor(Color.WHITE)
                abc.setTextColor(Color.WHITE)
                numero.setTextColor(Color.WHITE)
                special_character.setTextColor(Color.WHITE)

            }.show()




        }
    }
}