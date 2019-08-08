package com.wasla.browser

import android.webkit.WebView
import android.widget.Toast
import java.util.regex.Pattern

fun executeSearch(webView: WebView, searchKey: String) {
    openUrl(webView, searchKey)
    if (isUrl(searchKey)) {
        Toast.makeText(webView.context, "Open Url", Toast.LENGTH_LONG).show()
        val url = getClearUrl(searchKey)
        openUrl(webView, url)
    } else {
        searchOnGoogle(webView, searchKey)
    }
}

private fun isUrl(searchKey: String): Boolean {
    val patternString =
        "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?\$"
    val pattern = Pattern.compile(patternString)
    val matcher = pattern.matcher(searchKey)
    return matcher.matches()
}

private fun getClearUrl(url: String): String {
    if (!url.startsWith("http://")) {
        return "http://$url"
    }
    return url
}

private fun searchOnGoogle(webView: WebView, searchKey: String) {
    val context = webView.context

    val url = context?.getString(R.string.googleSearchPrefix)?.let { String.format(it, searchKey) } ?: ""

    openUrl(webView, url)
}

private fun openUrl(webView: WebView, url: String) {
    webView.loadUrl(url)
}
