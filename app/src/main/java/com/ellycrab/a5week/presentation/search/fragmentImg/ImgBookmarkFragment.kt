package com.ellycrab.a5week.presentation.search.fragmentImg

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ellycrab.a5week.R
import com.ellycrab.a5week.databinding.FragmentImgBookmarkBinding
import com.ellycrab.a5week.databinding.FragmentSearchImgBinding
import com.ellycrab.a5week.presentation.adapter.BookmarkAdapter

import com.ellycrab.a5week.presentation.search.SharedViewModel

class ImgBookmarkFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var bookmarkAdapter: BookmarkAdapter
    private val binding by lazy { FragmentImgBookmarkBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeBookmarkedItems()
    }

    private fun observeBookmarkedItems() {
        sharedViewModel.bookmarkedItems.observe(viewLifecycleOwner) { bookmarkedItems ->
            bookmarkAdapter.submitList(bookmarkedItems)
        }
    }

    private fun setupRecyclerView() {
        bookmarkAdapter = BookmarkAdapter()
        binding.bookmarkRv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bookmarkAdapter
        }
    }
}