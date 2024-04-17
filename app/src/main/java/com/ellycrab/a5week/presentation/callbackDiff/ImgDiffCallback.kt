package com.ellycrab.a5week.presentation.callbackDiff

import androidx.recyclerview.widget.DiffUtil
import com.ellycrab.a5week.presentation.search.model.img.ImageDocumentEntity

class ImgDiffCallback: DiffUtil.ItemCallback<ImageDocumentEntity>() {
    override fun areItemsTheSame(
        oldItem: ImageDocumentEntity,
        newItem: ImageDocumentEntity
    ): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(
        oldItem: ImageDocumentEntity,
        newItem: ImageDocumentEntity
    ): Boolean {
        return oldItem == newItem
    }
}