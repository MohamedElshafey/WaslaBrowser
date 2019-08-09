package com.wasla.browser.util

import android.content.Context
import com.wasla.browser.R
import java.util.regex.Pattern

//Check if the string is valid url
fun isValidUrl(searchKey: String): Boolean {
    val patternString =
        "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?\$"
    val pattern = Pattern.compile(patternString)
    val matcher = pattern.matcher(searchKey)
    return matcher.matches()
}

//Adding http protocol if the url not have
fun getClearUrl(url: String): String {
    if (!url.startsWith("http://")) {
        return "http://$url"
    }
    return url
}

fun getGoogleSearchUrl(context: Context, searchKey: String): String {
    return context.getString(R.string.googleSearchPrefix).let { String.format(it, searchKey) }
}
