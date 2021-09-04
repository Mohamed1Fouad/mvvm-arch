package com.mf.newsapp.core.view

import androidx.lifecycle.ViewModel
import com.mf.newsapp.core.utils.SingleLiveEvent

open class BaseViewModel : ViewModel() {

  var dataLoadingEvent: SingleLiveEvent<Int> = SingleLiveEvent()

}