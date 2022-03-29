package com.example.m5_l8twitterui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l8twitterui.R
import com.example.m5_l8twitterui.model.Post
import com.google.android.material.imageview.ShapeableImageView
import org.w3c.dom.Text

class FeedAdapter(val context: Context, val items: ArrayList<Post>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is FeedViewHolder) {
            holder.apply {
                ivProfile.setImageResource(feed.profile)
                post.setImageResource(feed.photo)
                tvFullname.text = feed.fullname
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class FeedViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val ivProfile = view.findViewById<ShapeableImageView>(R.id.iv_profile)
        val post = view.findViewById<ShapeableImageView>(R.id.iv_post)
        val tvFullname = view.findViewById<TextView>(R.id.tv_fullname)
    }
}