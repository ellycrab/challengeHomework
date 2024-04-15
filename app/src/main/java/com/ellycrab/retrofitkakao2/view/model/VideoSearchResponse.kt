package com.ellycrab.retrofitkakao2.view.model

data class VideoSearchResponse(

    val documents:List<VideoDocument>,
    val meta:MetaVideo
)
data class MetaVideo (
    val total_count: Int, //검색된 문서수
    val pageable_count: Int, // total_count 중 노출 가능 문서 수
    val is_end: Boolean // 현재 페이지가 마지막 페이지인지 여부, 값이 false면 page를 증가시켜 다음페이지를
    //요청할 수 있음
)




data class VideoDocument(
    val title:String?, //동영상 제목
    val url:String?, //동영상 링크
    val datetime:String?,
    val play_time:Int?,//동영상 재생시간,초 단위
    val thumbnail:String?, //동영상 미리보기 url
    val author:String? //동영상 업로더
)
