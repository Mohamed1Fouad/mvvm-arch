package com.mf.newsapp.ui.news.news_details

import androidx.lifecycle.viewModelScope
import com.mf.newsapp.core.utils.SingleLiveEvent
import com.mf.newsapp.core.view.BaseViewModel
import com.mf.newsapp.core.data.repository.NewsRepository
import com.mf.newsapp.core.data.domain.entity.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailsViewModel @Inject constructor(private val repository: NewsRepository) : BaseViewModel() {

  val onArticleSavedToLocal: SingleLiveEvent<Void> = SingleLiveEvent()

  private fun saveArticleToLocal(article: Article) = viewModelScope.launch {
    repository.saveArticleToLocal(article)
  }

  fun saveArticle(article: Article) {
    saveArticleToLocal(article)
    onArticleSavedToLocal.call()
  }
}