package com.wasla.browser

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wasla.browser.databinding.ActivityBrowserBinding

class BrowserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil
            .setContentView<ActivityBrowserBinding>(this@BrowserActivity, R.layout.activity_browser)

//        val browserViewModel = BrowserViewModel()
//
//        binding.browserVM = browserViewModel


    }
}
