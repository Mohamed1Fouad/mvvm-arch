package com.mf.newsapp.core.data.domain.entity.response

import com.mf.newsapp.core.data.domain.entity.model.Article

data class NewsResponse(
  val articles: List<Article>,
  val status: String,
  val totalResults: Int
)