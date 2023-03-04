package com.androiddevs.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.ui.NewsActivity
import com.androiddevs.mvvmnewsapp.ui.NewsViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class ArticleFragment : Fragment( R.layout.fragment_article ) {
    lateinit var viewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel

        val article = args.article

        view.findViewById<WebView>(R.id.webView).apply {
            if(article.url != null) {
                webViewClient = WebViewClient()
                loadUrl(article.url)
            }
        }

        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Article was Saved Successfully!", Snackbar.LENGTH_SHORT).show()
        }
    }
}