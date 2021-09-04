package com.mf.newsapp.core.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mf.newsapp.core.data.data_source.local.ArticlesDao
import com.mf.newsapp.core.data.domain.Converters
import com.mf.newsapp.core.data.domain.entity.model.Article

@Database(entities = [Article::class], version = MyDatabase.DATABASE_VERSION)
@TypeConverters(Converters::class)
abstract class MyDatabase : RoomDatabase() {

  companion object {
    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "NewsDatabase"
  }

  abstract fun getArticlesDao(): ArticlesDao
}