package com.example.rssreader

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.Loader
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<Rss> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportLoaderManager.initLoader(1, null, this)
    }

    override fun onCreateLoader(p0: Int, p1: Bundle?) = RssLoader(this)

    override fun onLoaderReset(p0: Loader<Rss>) {}

    override fun onLoadFinished(p0: Loader<Rss>, p1: Rss?) {
        if (p1 != null) {
            val adapter = ArticlesAdapter(this, p1.articles) { article ->

            }

            articles.adapter = adapter

            val layoutManager = GridLayoutManager(this, 2)

            articles.layoutManager = layoutManager
        }
    }
}
