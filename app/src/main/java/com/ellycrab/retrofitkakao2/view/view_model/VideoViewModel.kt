package com.ellycrab.retrofitkakao2.view.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ellycrab.retrofitkakao2.view.model.VideoDocument
import com.ellycrab.retrofitkakao2.view.utils.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VideoViewModel : ViewModel() {

    private val _videoSearchResult = MutableLiveData<List<VideoDocument>?>()
    val videoSearchResponse: MutableLiveData<List<VideoDocument>?> get() = _videoSearchResult

    fun searchVideos(query: String) {
        viewModelScope.launch(Dispatchers.Main){
            try {
                val response = RetrofitClient.kakaoService.searchVideos(query)
                videoSearchResponse.value = response.documents?.map { it }
                //응답 결과
                Log.d("viewviewmodel","Received ${response.documents?.size ?: 0} viedeo search rs")
            } catch (e: Exception) {
                //에러 결과
                videoSearchResponse.value = emptyList()
                Log.d("videoviewmodel","Error occurred while fetching image search results: ${e.message}", e)
            }
        }
    }

}