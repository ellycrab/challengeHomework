package com.ellycrab.retrofitkakao2.view.model

data class ImageSearchResponse(
    val documents: List<ImageDocument>,
    val meta: Meta

)

data class Meta (
    val total_count: Int, //검색된 문서수
    val pageable_count: Int, // total_count 중 노출 가능 문서 수
    val is_end: Boolean // 현재 페이지가 마지막 페이지인지 여부, 값이 false면 page를 증가시켜 다음페이지를
    //요청할 수 있음
)

data class ImageDocument(
    val collection: String,//컬렉션
    val thumbnail_url: String,//미리보기 이미지url
    val image_url: String,//이미지 url
    val width: Int,//이미지 가로길이
    val height: Int, //이미지 세로길이
    val display_sitename: String, //출처
    val doc_url: String, //문서 url
    val datetime: String //문서 작성 시간-공식문서에는 Datetime으로 되어있음
)
