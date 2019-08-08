package com.wasla.browser

import android.databinding.BindingAdapter
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.widget.AutoCompleteTextView

class BrowserBindingAdapter {

    companion object {
        @JvmStatic
        @BindingAdapter("search")
        fun performSearch(searchEditText: AutoCompleteTextView, webView: WebView?) {
            searchEditText.setOnEditorActionListener { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    if (webView != null) {
                        val searchKey = searchEditText.text.toString()
                        executeSearch(webView, searchKey)
                    }

                    return@setOnEditorActionListener true
                }
                return@setOnEditorActionListener false
            }

        }
    }
}