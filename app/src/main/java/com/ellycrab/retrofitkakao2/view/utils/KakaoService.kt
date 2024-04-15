package com.ellycrab.retrofitkakao2.view.utils


import com.ellycrab.retrofitkakao2.view.model.ImageSearchResponse


import com.ellycrab.retrofitkakao2.view.model.VideoSearchResponse
import retrofit2.http.GET

import retrofit2.http.Query

interface KakaoService {
    @GET("search/image")
    suspend fun searchImages(
       //입력은 스트링으로 타이핑
        @Query("query") query: String
    ): ImageSearchResponse  //결과는 dataclass전체

    @GET("search/vclip")
    suspend fun searchVideos(
        @Query("query") query: String
    ): VideoSearchResponse
}