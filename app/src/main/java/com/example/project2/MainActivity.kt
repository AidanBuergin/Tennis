package com.example.project2

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tennis : Tennis = Tennis()

        val leftButton = findViewById<Button>(R.id.leftButton)
        val rightButton = findViewById<Button>(R.id.rightButton)

        val leftSet = findViewById<TextView>(R.id.leftSet)
        val rightSet = findViewById<TextView>(R.id.rightSet)
        val leftGame = findViewById<TextView>(R.id.leftGame)
        val rightGame = findViewById<TextView>(R.id.rightGame)
        val winner = findViewById<TextView>(R.id.winner)

        fun computeScores (player : String){
            val newScore = tennis.score(player)
            leftGame.text=newScore[0]
            rightGame.text=newScore[1]
            leftSet.text=("" + tennis.leftSetScore)
            rightSet.text=("" + tennis.rightSetScore)
            if(tennis.winner != ""){
                winner.text=tennis.winner
                leftButton.isEnabled = false
                rightButton.isEnabled = false
            }
            winner.text=tennis.winner
        }

        leftButton.setOnClickListener {
            computeScores("left")
        }

        rightButton.setOnClickListener {
            computeScores("right")
        }


    }
}