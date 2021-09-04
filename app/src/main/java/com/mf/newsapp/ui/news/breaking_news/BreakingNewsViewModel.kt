package com.mf.newsapp.ui.news.breaking_news

import androidx.lifecycle.liveData
import com.mf.newsapp.core.network.Resource
import com.mf.newsapp.core.view.BaseViewModel
import com.mf.newsapp.core.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class BreakingNewsViewModel @Inject constructor(private val repository: NewsRepository) : BaseViewModel() {

  var shouldLoadMore = false
  var isLoading = false
  var page: Int = 1

  fun getBreakingNews(country: String) = liveData(Dispatchers.IO) {
    emit(Resource.Loading)
    emit(repository.getBreakingNews(country, page))
  }
}