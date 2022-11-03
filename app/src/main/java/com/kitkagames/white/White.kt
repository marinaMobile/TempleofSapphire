package com.kitkagames.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kitkagames.R
import kotlinx.android.synthetic.main.activity_white.*

class White : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_white)

        wheel.setOnClickListener{
            startActivity(Intent(this, Game::class.java))
        }
    }
}