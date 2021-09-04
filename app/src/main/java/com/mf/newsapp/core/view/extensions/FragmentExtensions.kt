package com.mf.newsapp.core.view.extensions

import androidx.fragment.app.Fragment
import com.mf.newsapp.R
import com.mf.newsapp.core.network.FailureStatus.API_FAIL
import com.mf.newsapp.core.network.FailureStatus.NO_INTERNET
import com.mf.newsapp.core.network.FailureStatus.OTHER
import com.mf.newsapp.core.network.FailureStatus.SERVER_SIDE_EXCEPTION
import com.mf.newsapp.core.network.FailureStatus.TOKEN_EXPIRED
import com.mf.newsapp.core.network.Resource.Failure
import com.mf.newsapp.core.utils.hideSoftInput
import com.mf.newsapp.core.utils.showMessage
import com.mf.newsapp.core.utils.showNoInternetAlert

fun Fragment.handleApiError(
  failure: Failure,
  retryAction: (() -> Unit)? = null,
  noDataAction: (() -> Unit)? = null,
  noInternetAction: (() -> Unit)? = null
) {
  when (failure.failureStatus) {
    API_FAIL, SERVER_SIDE_EXCEPTION -> {
      noDataAction?.let {
        it()
      }

      requireView().showSnackBar(
        resources.getString(R.string.some_error),
        resources.getString(R.string.retry),
        retryAction
      )
    }
    TOKEN_EXPIRED -> {
      // TODO : CALL API TO REFRESH TOKEN
      // OR (depends on your application business)
      // TODO : LOG OUT
    }
    NO_INTERNET -> {
      noInternetAction?.let {
        it()
      }

      showNoInternetAlert(requireActivity())
    }
    OTHER -> {
      noDataAction?.let {
        it()
      }

      requireView().showSnackBar(
        resources.getString(R.string.some_error),
        resources.getString(R.string.retry),
        retryAction
      )
    }
  }
}

fun Fragment.hideKeyboard() = hideSoftInput(requireActivity())

fun Fragment.showNoInternetAlert() = showNoInternetAlert(requireActivity())

fun Fragment.showMessage(message: String?) = showMessage(requireContext(), message)

fun Fragment.showError(message: String, retryActionName: String? = null, action: (() -> Unit)? = null) =
  requireView().showSnackBar(message, retryActionName, action)
