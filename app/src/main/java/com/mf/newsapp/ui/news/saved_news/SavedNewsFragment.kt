package com.mf.newsapp.ui.news.saved_news

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mf.newsapp.R
import com.mf.newsapp.core.utils.SwipeToDeleteCallback
import com.mf.newsapp.core.view.BaseFragment
import com.mf.newsapp.core.view.extensions.showError
import com.mf.newsapp.databinding.FragmentSavedNewsBinding
import com.mf.newsapp.core.data.domain.entity.model.Article
import com.mf.newsapp.ui.news.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedNewsFragment : BaseFragment<FragmentSavedNewsBinding>() {

  private val viewModel: SavedNewsViewModel by viewModels()

  private lateinit var articlesAdapter: NewsAdapter

  override
  fun getLayoutId() = R.layout.fragment_saved_news

  override
  fun setUpViews() {
    setUpRecyclerView()

    getSavedNews()
  }

  private fun setUpRecyclerView() {
    articlesAdapter = NewsAdapter { onArticleClick(it) }
    binding.recyclerView.apply {
      setHasFixedSize(true)
      layoutManager = LinearLayoutManager(requireContext())
      adapter = articlesAdapter
    }

    val itemTouchHelper = ItemTouchHelper(object : SwipeToDeleteCallback(requireContext()) {
      override
      fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val article = articlesAdapter.getItemByPosition(viewHolder.adapterPosition)
        viewModel.deleteArticleFromLocal(article)

        showError(
          resources.getString(R.string.article_removed),
          resources.getString(R.string.undo)
        ) { viewModel.saveArticleToLocal(article) }
      }
    })
    itemTouchHelper.attachToRecyclerView(binding.recyclerView)
  }

  private fun getSavedNews() {
    viewModel.getArticlesFromLocal().observe(this, { articlesAdapter.submitList(it) })
  }

  private fun onArticleClick(article: Article) {
    val bundle = Bundle().apply {
      putSerializable("article", article)
    }
    findNavController().navigate(
      R.id.action_open_news_details_fragment,
      bundle
    )
  }
}