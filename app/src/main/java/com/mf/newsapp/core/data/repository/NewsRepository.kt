package com.mf.newsapp.core.data.repository

import com.mf.newsapp.core.data.data_source.local.NewsLocalDataSource
import com.mf.newsapp.core.data.data_source.remote.NewsRemoteDataSource
import com.mf.newsapp.core.data.domain.entity.model.Article
import javax.inject.Inject

class NewsRepository @Inject constructor(
  private val remoteDataSource: NewsRemoteDataSource,
  private val newsLocalDataSource: NewsLocalDataSource
) {

  suspend fun getBreakingNews(country: String, page: Int) = remoteDataSource.getBreakingNews(country, page)

  suspend fun searchForNews(searchQuery: String, page: Int) = remoteDataSource.searchForNews(searchQuery, page)

  fun getArticlesFromLocal() = newsLocalDataSource.getArticlesFromLocal()

  suspend fun saveArticleToLocal(article: Article) = newsLocalDataSource.saveArticleToLocal(article)

  suspend fun deleteArticleFromLocal(article: Article) = newsLocalDataSource.deleteArticleFromLocal(article)
}