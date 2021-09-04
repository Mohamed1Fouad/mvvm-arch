package com.mf.newsapp.ui.splash

import android.os.Handler
import android.os.Looper
import com.mf.newsapp.R
import com.mf.newsapp.core.view.BaseActivity
import com.mf.newsapp.core.view.extensions.openActivityAndClearStack
import com.mf.newsapp.databinding.ActivitySplashBinding
import com.mf.newsapp.ui.news.NewsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

  override
  fun getLayoutId() = R.layout.activity_splash

  override
  fun setUpViews() {
    decideNavigationLogic()
  }

  private fun decideNavigationLogic() {
    Handler(Looper.getMainLooper()).postDelayed({
      openActivityAndClearStack(NewsActivity::class.java)
    }, 2000)
  }
}