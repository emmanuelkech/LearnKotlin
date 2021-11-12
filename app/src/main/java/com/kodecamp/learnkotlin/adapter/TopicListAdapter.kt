package com.kodecamp.learnkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.kodecamp.learnkotlin.R
import com.kodecamp.learnkotlin.databinding.TopicListItemBinding
import com.kodecamp.learnkotlin.fragments.TopicDetailsFragment
import com.kodecamp.learnkotlin.fragments.TopicListFragment
import com.kodecamp.learnkotlin.model.TopicModel

class TopicListAdapter(private val context: TopicListFragment, private val itemList: List<TopicModel> ) : RecyclerView.Adapter<TopicListAdapter.ViewHolder>()
{

    class ViewHolder(binding: TopicListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val topicImage : ImageView = binding.topicImage
        val topicTitle : TextView = binding.topicTitle
        val topicDescription : TextView = binding.topicDescription
        val topicDifficulty : TextView = binding.topicDifficulty
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val topicListBinding = TopicListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(topicListBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val topic = itemList[position]
        holder.apply {
            topicImage.setImageResource(topic.imageResId)
            topicTitle.text = context.resources.getString(topic.title)
            topicDescription.text = context.resources.getString(topic.description)
            topicDifficulty.text = context.resources.getString(topic.difficulty)
            itemView.setOnClickListener { p0 ->
                val activity = p0?.context as AppCompatActivity
                val topicDetails = TopicDetailsFragment()
                activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.root_layout, topicDetails).addToBackStack(null).commit()
            }
        }
    }

    override fun getItemCount() = itemList.size
}