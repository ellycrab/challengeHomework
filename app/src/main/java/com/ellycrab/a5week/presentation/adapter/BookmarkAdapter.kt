package com.ellycrab.a5week.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import com.ellycrab.a5week.databinding.BookmarkItemLayoutBinding

import com.ellycrab.a5week.presentation.callbackDiff.BookmarkDiffCallback
import com.ellycrab.a5week.presentation.search.model.img.ImageDocumentEntity
import com.ellycrab.a5week.presentation.viewholder.BookmarkViewHolder

//class BookmarkAdapter :
 //   ListAdapter<ImageDocumentEntity, BookmarkViewHolder>(BookmarkDiffCallback()) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
//        val viewHolder = BookmarkViewHolder(
//            BookmarkItemLayoutBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//        return viewHolder
//    }
//
//    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
//        val bookmarkItem = getItem(position)
//        holder.bind(bookmarkItem)
//    }
//}