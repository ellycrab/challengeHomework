package com.ellycrab.retrofitkakao2.view.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.Request

object RetrofitClient {//retrofit 인스턴스 만들기
    private const val BASE_URL = "https://dapi.kakao.com/v2/"
    private const val REST_API_KEY = "app_key 입력"

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val originalRequest = chain.request()
                val requestBuilder: Request.Builder = originalRequest.newBuilder()
                    .header("Authorization", "KakaoAK $REST_API_KEY")
                val request: Request = requestBuilder.build()


                return chain.proceed(request)
            }
        })
    }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val kakaoService: KakaoService = retrofit.create(KakaoService::class.java)
}
