package com.example.practical_6_22012011104

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity(),Animation.AnimationListener {
    lateinit var guni_animation:AnimationDrawable
    lateinit var tweenAnimation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }


        val uvpce_imageview = findViewById<ImageView>(R.id.uvpceanimation)
        /* using setBackgroundResource to apply background of view like image view
        as drawable resource, means a resource which is drawable
        AnimationDrawable is a subclass of Drawable used to create frame-by-frame animations.
        check this for more understanding : https://chatgpt.com/c/673cc143-e79c-8008-905e-91a7b3217419
        */
        uvpce_imageview.setBackgroundResource(R.drawable.uvpce_animation_list)
        guni_animation = uvpce_imageview.background as AnimationDrawable
        tweenAnimation= AnimationUtils.loadAnimation(this, R.anim.tween)
        tweenAnimation.setAnimationListener(this)


    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus){
            guni_animation.start()
            findViewById<ImageView>(R.id.uvpceanimation).startAnimation(tweenAnimation)
        }
            else{
                guni_animation.stop()
            }
    }

    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {
        Intent(this, MainActivity::class.java).also { startActivity(it) }
    }

    override fun onAnimationRepeat(p0: Animation?) {

    }
}