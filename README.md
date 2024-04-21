북마크까지 완료


<br>



![제목 없는 디자인 (2)](https://github.com/ellycrab/challengeHomework/assets/54714275/e854f90e-69a4-426b-880c-d40c283e53c1)

<br>




[SearchImgFragment.kt]


override fun onSwitchStateChanged(position: Int, isChecked: Boolean) {

        val item = imageResultAdapter.currentList[position]
        val bookmarkedItems = sharedViewModel.bookmarkedItems.value ?: emptyList()

        //아이템이 이미 북마크됬는지 체크
        val isBookmarked = bookmarkedItems.contains(item)

        if(isBookmarked){//이미 찜되어있으면
            //북마크에서 제거
            val updatedBookmarkedItems = bookmarkedItems - item
            sharedViewModel.bookmarkedItems.value = updatedBookmarkedItems
        }else{//찜되지 않았으면
            //북마크에 추가
            val updatedBookmarkedItems = bookmarkedItems + item
            sharedViewModel.bookmarkedItems.value = updatedBookmarkedItems
        }
    }
