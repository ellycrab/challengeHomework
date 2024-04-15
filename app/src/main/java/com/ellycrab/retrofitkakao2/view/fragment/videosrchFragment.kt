package com.ellycrab.retrofitkakao2.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.ellycrab.retrofitkakao2.R
import com.ellycrab.retrofitkakao2.databinding.FragmentVideosrchBinding
import com.ellycrab.retrofitkakao2.view.view_model.VideoViewModel


class videosrchFragment : Fragment() {


    private lateinit var videoViewModel:VideoViewModel
    private val binding by lazy { FragmentVideosrchBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        videoViewModel = ViewModelProvider(requireActivity()).get(VideoViewModel::class.java)

        binding.videoSrcBtn.setOnClickListener {
            performVideoSearch()
        }
    }

    private fun performVideoSearch() {

        val searchQuery = binding.videoSearch.text.toString()
        videoViewModel.searchVideos(searchQuery)

    }
}