package com.ellycrab.a5week.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ellycrab.a5week.databinding.ImgsearchrsBinding

import com.ellycrab.a5week.presentation.callback.ImgDiffCallback
import com.ellycrab.a5week.presentation.search.model.img.ImageDocumentEntity
import com.ellycrab.a5week.presentation.viewholder.ImageViewHolder

class ImgAdapter(private val switchStateChangeListener: OnSwitchStateChangeListener) : ListAdapter<ImageDocumentEntity, RecyclerView.ViewHolder>(ImgDiffCallback()) {

    interface OnSwitchStateChangeListener {
        fun onSwitchStateChanged(position: Int, isChecked: Boolean)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = ImageViewHolder(
            ImgsearchrsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            switchStateChangeListener
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ImageViewHolder) {
            val imageDocumentEntity = getItem(position) as ImageDocumentEntity
            holder.bind(imageDocumentEntity)
        }
    }
}