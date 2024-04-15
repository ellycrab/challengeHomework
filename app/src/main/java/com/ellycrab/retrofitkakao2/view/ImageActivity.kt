package com.ellycrab.retrofitkakao2.view

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.ellycrab.retrofitkakao2.R


import com.ellycrab.retrofitkakao2.databinding.ActivityImageBinding
import com.ellycrab.retrofitkakao2.view.fragment.imgRsFragment
import com.ellycrab.retrofitkakao2.view.fragment.imgsrchFragment

class ImageActivity : AppCompatActivity() {

    private val binding by lazy { ActivityImageBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        //imageSearch 프레임 레이아웃에 imgsrchFragment 추가
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.imageSearch, imgsrchFragment())
            commit()
        }

        // imageSearchRs 프레임 레이아웃에 imgRsFragment 추가
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.imageSearchRs, imgRsFragment())
            commit()
        }


    }
}