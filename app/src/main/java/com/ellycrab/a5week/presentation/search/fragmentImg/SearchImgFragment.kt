package com.ellycrab.a5week.presentation.search.fragmentImg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ellycrab.a5week.databinding.FragmentSearchImgBinding
import com.ellycrab.a5week.presentation.adapter.ImgAdapter
import com.ellycrab.a5week.presentation.search.SearchImgViewModel
import com.ellycrab.a5week.presentation.search.SearchImgViewModelFactory
import com.ellycrab.a5week.presentation.search.SharedViewModel


class SearchImgFragment : Fragment(),ImgAdapter.OnSwitchStateChangeListener {

    val sharedViewModel:SharedViewModel by activityViewModels()

    override fun onSwitchStateChanged(position: Int, isChecked: Boolean) {
        if(isChecked){
            val itemToBookmark = imageResultAdapter.currentList[position]

            sharedViewModel.bookmarkedItems.value = sharedViewModel.bookmarkedItems
                .value?.plus(itemToBookmark) ?: listOf(itemToBookmark)
        }
    }

    private val binding by lazy { FragmentSearchImgBinding.inflate(layoutInflater) }



    private lateinit var imageResultAdapter:ImgAdapter

    private val viewModel: SearchImgViewModel by viewModels{
        SearchImgViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerImg.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            //구분선 추가
            addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
            imageResultAdapter = ImgAdapter(this@SearchImgFragment)
            adapter = imageResultAdapter
        }

        viewModel.imageSearchResponse.observe(viewLifecycleOwner){
            imageList->
            imageResultAdapter.submitList(imageList)
        }

        binding.imgSrcBtn.setOnClickListener {
            performImageSearch()
        }



    }

    private fun performImageSearch() {
        val searchQuery = binding.imgSearch.text.toString()

        viewModel.onSearch(searchQuery)
    }

}