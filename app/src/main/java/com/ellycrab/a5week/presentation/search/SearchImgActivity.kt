package com.ellycrab.a5week.presentation.search

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ellycrab.a5week.databinding.ActivitySearchImgBinding
import com.ellycrab.a5week.presentation.adapter.FragmentImgAdapter
import com.ellycrab.a5week.presentation.search.fragmentImg.ImgBookmarkFragment
import com.ellycrab.a5week.presentation.search.fragmentImg.SearchImgFragment

import com.google.android.material.tabs.TabLayoutMediator

class SearchImgActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySearchImgBinding.inflate(layoutInflater) }

    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //1. 페이지 데이터 로드
        val list = listOf(SearchImgFragment(), ImgBookmarkFragment())

        //2. 아답터 생성
        val pagerAdapter = FragmentImgAdapter(list, this)

        //3. 아답터와 뷰페이저 연결
        val viewPager = binding.viewPager
        viewPager.adapter = pagerAdapter

        //4. 탭 메뉴의 갯수만큼 제목을 목록으로 생성
        val titles = listOf("Search", "Bookmark")

        //5. 탭 레이아웃과 뷰페이저 연결
        TabLayoutMediator(binding.tabLayout, viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }
}
