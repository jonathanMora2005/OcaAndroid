package com.dam.jonathan.juegodelaoca

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var N1: TextView
    private lateinit var N2: TextView
    private lateinit var P1: TextView
    private lateinit var P2: TextView
    private lateinit var TC: TextView
    private lateinit var M1: ConstraintLayout
    private lateinit var M2: ConstraintLayout

    private lateinit var oca: Oca
    private  var j: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        N1 = findViewById(R.id.n1)
        N2 = findViewById(R.id.n2)
        P1 = findViewById(R.id.p1)
        P2 = findViewById(R.id.p2)
        M1 = findViewById(R.id.m1)
        M2 = findViewById(R.id.m2)
        TC = findViewById(R.id.tc)

        TC.setTextColor(Color.parseColor("#FFFFFF"))
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun Tira(view: View) {
        val roll = oca.tirada()
        if (oca.nextPlayer() == 1) {
            P1.text = (P1.text.toString().toInt() + roll).toString()
            if (!oca.casellaEspacial(P1.text.toString().toInt())){
                oca.intercanviarColors(M1,M2)
                TC.setTextColor(Color.parseColor("#FFFFFF"))

            }
            else{
                TC.setTextColor(Color.parseColor("#FF5733"))
                oca.nextPlayer()
            }
            if (oca.guanyador(P1.text.toString().toInt())){
                TC.setTextColor(Color.parseColor("#f9ff33"))
                TC.text = "el jugador " + N1.text + " a ganador"
                M1.setBackgroundColor(Color.parseColor("#FFFFFF"))
                M2.setBackgroundColor(Color.parseColor("#FFFFFF"))
            }



        } else {
            P2.text = (P2.text.toString().toInt() + roll).toString()
            if (!oca.casellaEspacial(P2.text.toString().toInt())){
                oca.intercanviarColors(M1,M2)
                TC.setTextColor(Color.parseColor("#FFFFFF"))

            }
            else{
                TC.setTextColor(Color.parseColor("#FF5733"))
                oca.nextPlayer()
            }
            if (oca.guanyador(P2.text.toString().toInt())){
                TC.setTextColor(Color.parseColor("#f9ff33"))
                TC.text = "el jugador " + N2.text + " a ganador"
                M1.setBackgroundColor(Color.parseColor("#FFFFFF"))
                M2.setBackgroundColor(Color.parseColor("#FFFFFF"))
            }
        }

    }
    fun Comensa(view: View) {
        if (N1.text != null && N2.text != null) {
            oca = Oca()
            M1.setBackgroundColor(Color.parseColor("#FF5733"))
            M2.setBackgroundColor(Color.parseColor("#FFFFFF"))



        }
    }


}