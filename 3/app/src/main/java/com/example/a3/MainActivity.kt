package com.example.a3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private lateinit var moneyTextView: TextView
    private lateinit var dolar_1: ImageView
    private lateinit var centavos_5: ImageView
    private lateinit var centavos_10: ImageView
    private lateinit var centavos_25: ImageView
    private var money: Double = 0.00
    private var t : Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        clicListener()
    }

    fun bind(){
        moneyTextView = findViewById(R.id.Calcular)
        dolar_1 = findViewById(R.id.imageViewDolar)
        centavos_5 = findViewById(R.id.imageView5Centavos)
        centavos_10 = findViewById(R.id.imageView10Centavos)
        centavos_25 = findViewById(R.id.imageView25Centavos)
    }

    fun clicListener(){


        dolar_1.setOnClickListener {
            money += 1.00
            t = String.format("%.2f", money).toDouble()
            moneyTextView.text = "$${t}"

        centavos_5.setOnClickListener{
            money += 0.05
            t = String.format("%.2f", money).toDouble()
            moneyTextView.text = "$${t}"}


        centavos_10.setOnClickListener{
            money += 0.10
            t = String.format("%.2f", money).toDouble()
            moneyTextView.text = "$${t}"
        }

        centavos_25.setOnClickListener{
            money += 0.25
            t = String.format("%.2f", money).toDouble()
            moneyTextView.text = "$${t}"
        }



    }
}}