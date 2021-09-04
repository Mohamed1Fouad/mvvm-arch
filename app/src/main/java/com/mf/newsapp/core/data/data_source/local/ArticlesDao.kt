package com.mf.newsapp.core.data.data_source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mf.newsapp.core.data.domain.entity.model.Article

@Dao
interface ArticlesDao {

  @Query("SELECT * FROM articles")
  fun getAll(): LiveData<List<Article>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insert(article: Article)

  @Delete
  suspend fun delete(article: Article)
}