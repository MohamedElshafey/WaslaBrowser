package com.wasla.browser.browser

import android.databinding.BindingAdapter
import android.graphics.Bitmap
import android.view.View
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.AutoCompleteTextView
import android.widget.ProgressBar
import com.wasla.browser.util.getUrl

class BrowserBindingAdapter {

    companion object {
        @JvmStatic
        @BindingAdapter("search")
        fun performSearch(searchEditText: AutoCompleteTextView, webView: WebView?) {
            searchEditText.setOnEditorActionListener { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    if (webView != null) {
                        val searchKey = searchEditText.text.toString()
                        webView.loadUrl(getUrl(webView.context, searchKey))
                    }
                    return@setOnEditorActionListener true
                }
                return@setOnEditorActionListener false
            }
        }


        @JvmStatic
        @BindingAdapter("webViewProgressBar")
        fun addWebViewProgressBar(webView: WebView, progressBar: ProgressBar?) {
            webView.webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    progressBar?.visibility = View.VISIBLE
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    progressBar?.visibility = View.GONE
                }
            }
        }


        @JvmStatic
        @BindingAdapter("loadUrl")
        fun loadUrl(webView: WebView, url: String?) {
            webView.loadUrl(url)
        }
    }
}