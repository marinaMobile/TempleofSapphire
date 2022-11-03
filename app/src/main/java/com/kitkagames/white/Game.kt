package com.kitkagames.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.kitkagames.R

class Game : AppCompatActivity() {
    lateinit var enemyPic: ImageView
    lateinit var playerPic: ImageView
    val choices = mutableListOf<String>("Clover", "Grape", "Strawberry")
    var playerscore = 0
    var enemyscore = 0
    lateinit var playerScoreText: TextView
    lateinit var enemyScoreText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        enemyPic = findViewById(R.id.enemy_pic)
        playerPic = findViewById(R.id.player_pic)

        playerScoreText = findViewById(R.id.player_score_text)
        enemyScoreText = findViewById(R.id.enemy_score_text)
        win()

    }
    fun rock(v: View){
        playerPic.setImageResource(R.drawable.clover)
        val enemychoice = choices.random()
        when (enemychoice){
            "Clover" -> {enemyPic.setImageResource(R.drawable.clover)}

            "Grape" -> {enemyPic.setImageResource(R.drawable.grape)
                enemyscore++
                enemyScoreText.text = enemyscore.toString()

            }

            "Strawberry" -> {enemyPic.setImageResource(R.drawable.straw)
                playerscore++
                playerScoreText.text = playerscore.toString()

            }

        }


    }

    fun paper(v: View){
        playerPic.setImageResource(R.drawable.grape)
        val enemychoice = choices.random()
        when (enemychoice){
            "Clover" -> {enemyPic.setImageResource(R.drawable.clover)
                playerscore++
                playerScoreText.text = playerscore.toString()}

            "Grape" -> {enemyPic.setImageResource(R.drawable.grape)}

            "Strawberry" -> {enemyPic.setImageResource(R.drawable.straw)
                enemyscore++
                enemyScoreText.text = enemyscore.toString()}

        }
        win()
    }

    fun scissors(v: View) {
        playerPic.setImageResource(R.drawable.straw)
        val enemychoice = choices.random()
        when (enemychoice) {
            "Clover" -> {
                enemyPic.setImageResource(R.drawable.clover)
                enemyscore++
                enemyScoreText.text = enemyscore.toString()
            }

            "Grape" -> {
                enemyPic.setImageResource(R.drawable.grape)
                playerscore++
                playerScoreText.text = playerscore.toString()
            }

            "Strawberry" -> {
                enemyPic.setImageResource(R.drawable.straw)
            }

        }
        win()
    }

    private fun win() {
        val plscr = playerscore.toString()
        val enscr = enemyscore.toString()
        val intent = Intent(this@Game, FinishAct::class.java)
        intent.putExtra("key", plscr)
        intent.putExtra("key2", enscr)

        if (playerscore > 2 && playerscore > enemyscore) {

            startActivity(intent)

        } else if (enemyscore > 2 && enemyscore > playerscore ) {

            startActivity(intent)

        }
    }

}