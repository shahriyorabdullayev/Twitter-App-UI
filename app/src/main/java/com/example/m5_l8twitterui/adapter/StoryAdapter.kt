package com.example.m5_l8twitterui.adapter

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l8twitterui.R
import com.example.m5_l8twitterui.model.Story
import com.google.android.material.imageview.ShapeableImageView

class StoryAdapter(val context: Context, val items: ArrayList<Story>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val story = items[position]

        if (holder is StoryViewHolder) {
            holder.apply {
                ivProfile.setImageResource(story.profile)
                tvFullname.text = story.fullname
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class StoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val ivProfile = view.findViewById<ShapeableImageView>(R.id.iv_profile)
        val tvFullname = view.findViewById<TextView>(R.id.tv_fullname)
    }
}