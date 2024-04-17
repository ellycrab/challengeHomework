package com.ellycrab.a5week.network.img

import com.ellycrab.a5week.data.remote.img.SearchImgRemoteDatasource
import com.ellycrab.a5week.network.AuthorizationInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitaImgClient {

    private const val BASE_URL = "https://dapi.kakao.com"

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(AuthorizationInterceptor("카카오 restapi키 입력"))
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val search: SearchImgRemoteDatasource by lazy {
        retrofit.create(SearchImgRemoteDatasource::class.java)
    }
}