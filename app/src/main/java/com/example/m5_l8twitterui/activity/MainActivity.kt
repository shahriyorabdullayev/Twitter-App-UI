package com.example.m5_l8twitterui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5_l8twitterui.R
import com.example.m5_l8twitterui.adapter.FeedAdapter
import com.example.m5_l8twitterui.adapter.StoryAdapter
import com.example.m5_l8twitterui.model.Post
import com.example.m5_l8twitterui.model.Story

class MainActivity : AppCompatActivity() {

    private lateinit var rvStory: RecyclerView
    private lateinit var rvFeed: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        initViews()
    }

    private fun initViews() {
        rvFeed = findViewById(R.id.rv_feed)
        rvStory = findViewById(R.id.rv_story)

        rvStory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvFeed.layoutManager = GridLayoutManager(this, 1)

        refreshFeedAdapter(getFeed())
        refreshStoryAdapter(getStory())

    }

    private fun refreshStoryAdapter(items:ArrayList<Story>){
        val adapter = StoryAdapter(this, items)
        rvStory.adapter = adapter
    }

    private fun refreshFeedAdapter(items:ArrayList<Post>){
        val adapter = FeedAdapter(this, items)
        rvFeed.adapter = adapter
    }

    private fun getStory():ArrayList<Story> {
         val list = ArrayList<Story>()

        for (i in 0..20) {
            list.add(Story(R.drawable.im_profile, "Diyorbek"))
        }
        return list
    }

    private fun getFeed():ArrayList<Post> {
        val list = ArrayList<Post>()

        for (i in 0..20) {
            list.add(Post(R.drawable.im_profile, "Diyorbek Abdullayev", R.drawable.im_tennis))
        }
        return list
    }
}