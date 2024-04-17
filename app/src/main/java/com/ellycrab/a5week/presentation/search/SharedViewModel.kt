package com.ellycrab.a5week.presentation.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ellycrab.a5week.presentation.search.model.img.ImageDocumentEntity

class SharedViewModel: ViewModel() {
    val bookmarkedItems = MutableLiveData<List<ImageDocumentEntity>>()
}