package com.mf.newsapp.core.data.data_source.remote

import com.mf.newsapp.core.data.domain.entity.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsServices {

  @GET("top-headlines")
  suspend fun getBreakingNews(
    @Query("country") country: String,
    @Query("page") page: Int,
    @Query("pageSize") pageSize: Int
  ): NewsResponse

  @GET("everything")
  suspend fun searchForNews(
    @Query("q") searchQuery: String,
    @Query("page") page: Int,
    @Query("pageSize") pageSize: Int
  ): NewsResponse

}