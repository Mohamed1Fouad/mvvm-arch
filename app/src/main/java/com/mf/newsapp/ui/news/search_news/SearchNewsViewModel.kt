package com.mf.newsapp.ui.news.search_news

import androidx.lifecycle.liveData
import com.mf.newsapp.core.network.Resource
import com.mf.newsapp.core.utils.SingleLiveEvent
import com.mf.newsapp.core.view.BaseViewModel
import com.mf.newsapp.core.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class SearchNewsViewModel @Inject constructor(private val repository: NewsRepository) : BaseViewModel() {

  var searchQuery: String = ""
  var shouldLoadMore = false
  var isLoading = false
  var page: Int = 1

  val clearSearchArea: SingleLiveEvent<Void> = SingleLiveEvent()

  fun searchForNews() = liveData(Dispatchers.IO) {
    emit(Resource.Loading)
    emit(repository.searchForNews(searchQuery, page))
  }

  fun onDismissClicked() {
    clearSearchArea.call()
  }
}