package com.example.canongame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity: AppCompatActivity() {

    lateinit var canonView: CanonView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        canonView = findViewById<CanonView>(R.id.vMain)
    }

    override fun onPause() {
        super.onPause()
        canonView.pause()
    }

    override fun onResume() {
        super.onResume()
        canonView.resume()
    }
}