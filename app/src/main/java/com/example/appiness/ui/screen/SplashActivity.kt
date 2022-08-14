package com.example.appiness.ui.screen

/**
 * Created by Sourabh Kumar on 14,June,2022
 */
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.appiness.R

class SplashActivity : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler=Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000) // delaying 3 seconds to open main activity
    }
}


