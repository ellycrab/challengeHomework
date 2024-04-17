package com.ellycrab.a5week.presentation.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ellycrab.a5week.databinding.ImgsearchrsBinding
import com.ellycrab.a5week.presentation.adapter.ImgAdapter
import com.ellycrab.a5week.presentation.search.model.img.ImageDocumentEntity

class ImageViewHolder(val binding:ImgsearchrsBinding,val switchStateChangeListener: ImgAdapter.OnSwitchStateChangeListener)
    :RecyclerView.ViewHolder(binding.root) {


    fun bind(data: ImageDocumentEntity){
        Glide.with(itemView.context)
            .load(data.thumbnailUrl)
            .into(binding.imageViewThumbnail)


        binding.textViewTitle.text = data.collection
        binding.displaySitename.text = data.displaySitename
        binding.datetime.text = data.datetime.toString()

        binding.switch1.setOnCheckedChangeListener  {
            _,isChecked->
            switchStateChangeListener.onSwitchStateChanged(adapterPosition,isChecked)
        }

    }
}