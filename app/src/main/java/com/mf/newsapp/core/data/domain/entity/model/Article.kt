package com.mf.newsapp.core.data.domain.entity.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mf.newsapp.core.utils.DateUtils
import com.mf.newsapp.core.utils.convertDateTimeToTimesAgo
import java.io.Serializable

@Entity(tableName = "articles")
data class Article(
  @PrimaryKey(autoGenerate = true)
  val id: Int,
  val author: String,
  val content: String,
  val description: String,
  val publishedAt: String,
  val title: String,
  val url: String,
  val urlToImage: String,
  val source: Source
) : Serializable {

  val articleDateFormatted
    get() = publishedAt.convertDateTimeToTimesAgo(DateUtils.FULL_DATE_TIME_FORMAT)
}

data class Source(
  val name: String
)