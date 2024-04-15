package com.ellycrab.retrofitkakao2.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.ellycrab.retrofitkakao2.R
import com.ellycrab.retrofitkakao2.databinding.FragmentImgsrchBinding
import com.ellycrab.retrofitkakao2.view.view_model.ImgViewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class imgsrchFragment : Fragment() {

    private lateinit var imgViewModel: ImgViewModel

    private val binding by lazy { FragmentImgsrchBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        imgViewModel = ViewModelProvider(requireActivity()).get(ImgViewModel::class.java)


        binding.imgSrcBtn.setOnClickListener {

            performImageSearch()
        }
    }

    private fun performImageSearch() {

        val searchQuery = binding.imgSearch.text.toString()


        imgViewModel.searchImages(searchQuery)
    }
}