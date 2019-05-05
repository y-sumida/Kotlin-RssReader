package com.example.rssreader

import android.content.Context
import android.content.ReceiverCallNotAllowedException
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.grid_article_cell.view.*

class ArticlesAdapter(private val context: Context,
                      private val articles: List<Article>,
                      private val onArticleClicked: (Article) -> Unit) : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun getItemCount() = articles.size

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ArticleViewHolder {
        val view = inflater.inflate(R.layout.grid_article_cell, p0, false)

        val viewHolder = ArticleViewHolder(view)

        view.setOnClickListener {
            val position = viewHolder.adapterPosition

            val article = articles[position]

            onArticleClicked(article)
        }

        return viewHolder
    }

    override fun onBindViewHolder(p0: ArticleViewHolder, p1: Int) {
        val article = articles[p1]

        p0.title.text = article.title
        p0.pubDate.text = context.getString(R.string.pubDate, article.pubDate)
    }


    class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.title
        val pubDate = view.pubDate
    }
}