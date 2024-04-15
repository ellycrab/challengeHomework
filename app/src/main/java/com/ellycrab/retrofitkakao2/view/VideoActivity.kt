package com.ellycrab.retrofitkakao2.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ellycrab.retrofitkakao2.R
import com.ellycrab.retrofitkakao2.databinding.ActivityVideoBinding
import com.ellycrab.retrofitkakao2.view.fragment.videoRsFragment
import com.ellycrab.retrofitkakao2.view.fragment.videosrchFragment

class VideoActivity : AppCompatActivity() {

    private val binding by lazy { ActivityVideoBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        //videoSearch 프레임 레이아웃에 videosrchFragment 추가
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.videoSearch,videosrchFragment())
            commit()
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.videoSearchRs,videoRsFragment())
            commit()
        }
    }
}