package com.ellycrab.retrofitkakao2.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ellycrab.retrofitkakao2.R
import com.ellycrab.retrofitkakao2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            button.setOnClickListener {
                val intent = Intent(this@MainActivity,ImageActivity::class.java)
                startActivity(intent)
            }
            button2.setOnClickListener {
                val intent = Intent(this@MainActivity,VideoActivity::class.java)
                Log.d("MainActivity","$intent")
                startActivity(intent)
            }
        }
    }
}