package com.ellycrab.a5week.presentation.search.model.img

import java.util.Date
//데이터가 사용자 인터페이스에 표시되는 방식과 더 관련있다.
//ImageDocumentResponse의 단순화된 버전인 ImageDocumentEntity가 있다.

data class SearchImageEntity(
    val meta: MetaEntity?,
    val documents: List<ImageDocumentEntity>?,
)

data class MetaEntity(
    val totalCount: Int?,
    val pageableCount: Int?,
    val isEnd: Boolean?,
)

data class ImageDocumentEntity(
    val collection: String?,
    val thumbnailUrl: String?,
    val imageUrl: String?,
    val width: Int?,
    val height: Int?,
    val displaySitename: String?,
    val docUrl: String?,
    val datetime: Date?,
)