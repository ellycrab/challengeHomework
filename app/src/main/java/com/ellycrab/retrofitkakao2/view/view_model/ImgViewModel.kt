package com.ellycrab.retrofitkakao2.view.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ellycrab.retrofitkakao2.view.model.ImageDocument
import com.ellycrab.retrofitkakao2.view.utils.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImgViewModel: ViewModel() {

    private val _imageSearchResult = MutableLiveData<List<ImageDocument>?>()
    //읽기 전용 속성-_imageSearchResult의 getter  imageSearchResponse를통해 데이터 접근
    val imageSearchResponse: MutableLiveData<List<ImageDocument>?> get() = _imageSearchResult


    fun searchImages(query: String) {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                val response = RetrofitClient.kakaoService.searchImages(query)
                imageSearchResponse.value = response.documents?.map { it }

                // 응답 결과
                Log.d("imgviewmodel", "Received ${response.documents?.size ?: 0} image search results")
            } catch (e: Exception) {
                // 에러 결과
                imageSearchResponse.value = emptyList()
                Log.e("imgviewmodel", "Error occurred while fetching image search results: ${e.message}", e)
            }
        }
    }
}