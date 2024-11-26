package com.example.practical_6_22012011104

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var alarmAnimation: AnimationDrawable
    private lateinit var heartAnimation: AnimationDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val heartImg = findViewById<ImageView>(R.id.heartAnim)
        val clockImg = findViewById<ImageView>(R.id.clockImg)

        heartImg.setBackgroundResource(R.drawable.heart_animation_list)
        clockImg.setBackgroundResource(R.drawable.alarm_animation_list)

        alarmAnimation = clockImg.background as AnimationDrawable
        this.heartAnimation = heartImg.background as AnimationDrawable

    }

        override fun onWindowFocusChanged(hasFocus: Boolean) {
            super.onWindowFocusChanged(hasFocus)
            if (hasFocus) {
                heartAnimation.start()
                alarmAnimation.start()
            }
            else{
                heartAnimation.stop()
                alarmAnimation.stop()

            }

        }
    }
