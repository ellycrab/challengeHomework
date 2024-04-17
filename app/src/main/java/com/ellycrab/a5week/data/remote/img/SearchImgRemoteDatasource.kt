package com.ellycrab.a5week.data.remote.img

import com.ellycrab.a5week.data.model.img.SearchImageResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchImgRemoteDatasource {
    @GET("/v2/search/image")
    suspend fun getSearchImage(
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): SearchImageResponse
}