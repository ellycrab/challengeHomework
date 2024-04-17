package com.ellycrab.a5week.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ellycrab.a5week.databinding.ActivityMainBinding
import com.ellycrab.a5week.presentation.search.SearchImgActivity
import com.ellycrab.a5week.presentation.search.SearchVideoActivity

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        with(binding){
            imgBtn.setOnClickListener {
                val intent = Intent(this@MainActivity,SearchImgActivity::class.java)
                startActivity(intent)
            }

            videoBtn.setOnClickListener {
                val intent = Intent(this@MainActivity,SearchVideoActivity::class.java)
                startActivity(intent)
            }
        }
    }
}