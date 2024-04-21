북마크까지 완료


<br>


![제목 없는 디자인 (2)](https://github.com/ellycrab/challengeHomework/assets/54714275/89524bd9-e116-4b5b-abc1-0d593dfded7d)  <br>

ImgAdapter에서 interface OnSwitchStateChangeListener 안에<br>
메서드 onSwitchStateChanged 를 이용해서 <br>
메인화면 SearchImgFragment.kt 에서 메서드 onSwitchStateChanged를 오버라이드함 <br>

//이미 찜되어있으면  <br>
if(isBookmarked){ <br>
            //북마크에서 제거
            val updatedBookmarkedItems = bookmarkedItems - item <br>
            sharedViewModel.bookmarkedItems.value = updatedBookmarkedItems
            //찜되지 않았으면<br>
        }else{
            //북마크에 추가
            val updatedBookmarkedItems = bookmarkedItems + item
            sharedViewModel.bookmarkedItems.value = updatedBookmarkedItems
        }
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
