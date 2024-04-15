package com.ellycrab.retrofitkakao2.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ellycrab.retrofitkakao2.R
import com.ellycrab.retrofitkakao2.databinding.FragmentImgRsBinding
import com.ellycrab.retrofitkakao2.view.adapter.ImageResultAdapter
import com.ellycrab.retrofitkakao2.view.view_model.ImgViewModel


class imgRsFragment : Fragment() {

    private lateinit var imgViewModel: ImgViewModel
    private lateinit var imageResultAdapter: ImageResultAdapter
    private lateinit var binding:FragmentImgRsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImgRsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        imgViewModel = ViewModelProvider(requireActivity()).get(ImgViewModel::class.java)


        binding.recyclerImg.layoutManager = LinearLayoutManager(requireContext())
        imageResultAdapter = ImageResultAdapter(emptyList()) // 초기에 빈화면
        binding.recyclerImg.adapter = imageResultAdapter


        imgViewModel.imageSearchResponse.observe(viewLifecycleOwner) { imageList ->
            imageResultAdapter.imageList = imageList ?: emptyList()
            imageResultAdapter.notifyDataSetChanged()
        }
    }
}