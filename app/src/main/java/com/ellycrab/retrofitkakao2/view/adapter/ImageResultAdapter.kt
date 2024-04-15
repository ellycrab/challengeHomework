package com.ellycrab.retrofitkakao2.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ellycrab.retrofitkakao2.R
import com.ellycrab.retrofitkakao2.databinding.ItemImageResultBinding
import com.ellycrab.retrofitkakao2.view.model.ImageDocument

class ImageResultAdapter(var imageList: List<ImageDocument>) : RecyclerView.Adapter<ImageResultAdapter.ImageResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageResultViewHolder {
        val binding = ItemImageResultBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageResultViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    inner class ImageResultViewHolder(val binding: ItemImageResultBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(imageDocument: ImageDocument) {

            Glide.with(itemView.context)
                .load(imageDocument.thumbnail_url)
                .into(binding.imageViewThumbnail)


            binding.textViewTitle.text = imageDocument.collection

        }
    }
}