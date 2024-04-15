package com.ellycrab.retrofitkakao2.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ellycrab.retrofitkakao2.R
import com.ellycrab.retrofitkakao2.databinding.ItemVideoResultBinding
import com.ellycrab.retrofitkakao2.view.model.VideoDocument

class VideoResultAdapter(var videoList:List<VideoDocument>):RecyclerView.Adapter<VideoResultAdapter.VideoResultViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoResultViewHolder {
        val binding = ItemVideoResultBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoResultViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    override fun onBindViewHolder(holder: VideoResultViewHolder, position: Int) {
        holder.bind(videoList[position])
    }

    inner class VideoResultViewHolder(val binding:ItemVideoResultBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(videoDocument: VideoDocument){
            Glide.with(itemView.context)
                .load(videoDocument.thumbnail)
                .into(binding.videoThumb)

            binding.videoTitle.text =videoDocument.title
        }
    }


}