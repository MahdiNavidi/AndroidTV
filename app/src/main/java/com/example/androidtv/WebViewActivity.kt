package com.example.androidtv

import android.net.http.SslError
import android.os.Bundle
import android.webkit.SslErrorHandler
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class WebViewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        val url = intent.extras?.getString("url")

        val webView = findViewById<WebView>(R.id.webView)
        webView.setWebChromeClient(WebChromeClient())
        webView.setWebViewClient(WebViewClient())
//        webView.setWebViewClient(object : WebViewClient() {
//            override fun onReceivedSslError(
//                view: WebView?,
//                handler: SslErrorHandler?,
//                error: SslError?
//            ) {
////                super.onReceivedSslError(view, handler, error)
////                handler?.proceed()
//            }
//        })

        webView.post {
            webView.settings.allowContentAccess = true
            webView.settings.loadWithOverviewMode = true
            webView.settings.useWideViewPort = true
            webView.settings.builtInZoomControls = true
            webView.settings.allowFileAccess = true
            webView.settings.domStorageEnabled = true
            webView.settings.loadsImagesAutomatically = true
            webView.settings.javaScriptEnabled=true
            webView.settings.javaScriptCanOpenWindowsAutomatically=true
            webView.clearSslPreferences()

            webView.loadUrl(url!!)
        }
    }
}