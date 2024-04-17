package com.ellycrab.a5week.data.repository.img

import com.ellycrab.a5week.data.remote.img.SearchImgRemoteDatasource

import com.ellycrab.a5week.presentation.search.model.img.toEntity
import com.ellycrab.a5week.presentation.search.repository.SearchImgRepository

class SearchImgRepositoryImpl(
    private val remoteImgDatasource: SearchImgRemoteDatasource,
) : SearchImgRepository {

    override suspend fun getSearchImage(
        query: String,
        sort: String,
        page: Int,
        size: Int,
    ) = remoteImgDatasource.getSearchImage(
        query,
        sort,
        page,
        size
    ).toEntity()
}