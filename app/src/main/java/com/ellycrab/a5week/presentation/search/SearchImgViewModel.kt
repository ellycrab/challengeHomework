package com.ellycrab.a5week.presentation.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.ellycrab.a5week.data.repository.img.SearchImgRepositoryImpl


import com.ellycrab.a5week.network.img.RetrofitaImgClient
import com.ellycrab.a5week.presentation.search.model.img.ImageDocumentEntity
import com.ellycrab.a5week.presentation.search.model.img.SearchImageEntity
import kotlinx.coroutines.launch

class SearchImgViewModel(
    private val searchImgRepository: SearchImgRepositoryImpl,

): ViewModel() {

    private val _imageSearchResult = MutableLiveData<List<ImageDocumentEntity>?>()
    val imageSearchResponse:MutableLiveData<List<ImageDocumentEntity>?> get() = _imageSearchResult


    fun onSearch(query:String) = viewModelScope.launch {
        runCatching{
            val response = searchImgRepository.getSearchImage(query)
            imageSearchResponse.value = response.documents?.map { it }

            //응답결과
            Log.d("SearchViewModel",response.toString())
        }.onFailure {

            // Handle error
            Log.d("error","Error occured$it")

        }
    }
}

/*
SearchImgViewModelFactory를 제공하여
의존성 주입을 수행. 이는 ViewModel의 생성시점에
필요한 의존성을 제공하는 데 사용됨
 */
class SearchImgViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {

        return SearchImgViewModel(
            SearchImgRepositoryImpl(RetrofitaImgClient.search)
        ) as T
    }
}