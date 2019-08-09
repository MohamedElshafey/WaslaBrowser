package com.wasla.browser.util

import android.content.Context

fun getUrl(context: Context, searchKey: String): String {
    return if (isValidUrl(searchKey)) {
        getClearUrl(searchKey)
    } else {
        getGoogleSearchUrl(context, searchKey)
    }
}