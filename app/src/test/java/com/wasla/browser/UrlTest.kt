package com.wasla.browser

import com.google.common.truth.Truth.assertThat
import com.wasla.browser.util.isValidUrl
import org.junit.Test

class UrlTest {

    @Test
    fun urlValidationTest() {
        assertThat(isValidUrl("test@email.com")).isFalse()
        assertThat(isValidUrl("fb.com")).isTrue()
        assertThat(isValidUrl("www.facebook.com")).isTrue()
        assertThat(isValidUrl("www.youtube.com")).isTrue()
        assertThat(isValidUrl("http://wuzzuf.net")).isTrue()
        assertThat(isValidUrl("eg.linkedin.com")).isTrue()
        assertThat(isValidUrl("eg.linkedin")).isFalse()
        assertThat(isValidUrl("https://truth.dev")).isTrue()
        assertThat(isValidUrl("truth.dev")).isTrue()
        assertThat(isValidUrl("test.org")).isTrue()
        assertThat(isValidUrl("facebook")).isFalse()
    }

}