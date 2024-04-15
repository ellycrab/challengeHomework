package com.ellycrab.retrofitkakao2.view.fragment

import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ellycrab.retrofitkakao2.R
import com.ellycrab.retrofitkakao2.databinding.FragmentVideoRsBinding
import com.ellycrab.retrofitkakao2.view.adapter.VideoResultAdapter
import com.ellycrab.retrofitkakao2.view.view_model.VideoViewModel


class videoRsFragment : Fragment() {

    private lateinit var viewdeoViewModel: VideoViewModel
    private lateinit var videoResultAdapter: VideoResultAdapter
    private lateinit var binding:FragmentVideoRsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVideoRsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewdeoViewModel = ViewModelProvider(requireActivity()).get(VideoViewModel::class.java)

        binding.recyclerVideo.layoutManager = LinearLayoutManager(requireContext())
        videoResultAdapter = VideoResultAdapter(emptyList()) //초기에 빈화면
        binding.recyclerVideo.adapter = videoResultAdapter

        viewdeoViewModel.videoSearchResponse.observe(viewLifecycleOwner){
            videoList->
            videoResultAdapter.videoList = videoList ?: emptyList()
            videoResultAdapter.notifyDataSetChanged()
        }
    }

}