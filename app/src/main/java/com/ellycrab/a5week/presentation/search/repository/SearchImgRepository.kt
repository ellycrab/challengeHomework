package com.ellycrab.a5week.presentation.search.repository

import com.ellycrab.a5week.presentation.search.model.img.SearchImageEntity

interface SearchImgRepository {
    suspend fun getSearchImage(
        query: String,
        sort: String = "accuracy",
        page: Int = 1,
        size: Int = 80
    ): SearchImageEntity
}