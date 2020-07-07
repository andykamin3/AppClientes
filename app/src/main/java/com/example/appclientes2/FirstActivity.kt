package com.example.appclientes2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView

class FirstActivity : AppCompatActivity() {

    private val TIME : Long = 3000
    lateinit var splashScreenIv : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        splashScreenIv = findViewById(R.id.imageViewSplashScreen)

        GlideApp.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/Logo.PNG?alt=media&token=a7542c36-d7a4-4366-ac1d-42249ae6126d")
            .into(splashScreenIv)

        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },TIME)

    }
}