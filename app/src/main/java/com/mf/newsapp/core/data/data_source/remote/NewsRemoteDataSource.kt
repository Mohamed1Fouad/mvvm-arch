package com.mf.newsapp.core.data.data_source.remote

import com.mf.newsapp.core.data.data_source.BaseRemoteDataSource
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(private val apiService: NewsServices) : BaseRemoteDataSource() {

  suspend fun getBreakingNews(country: String, page: Int) = safeApiCall {
    apiService.getBreakingNews(country, page, LIST_PAGE_SIZE)
  }

  suspend fun searchForNews(searchQuery: String, page: Int) = safeApiCall {
    apiService.searchForNews(searchQuery, page, LIST_PAGE_SIZE)
  }
}