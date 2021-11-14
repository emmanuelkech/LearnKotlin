package com.kodecamp.learnkotlin.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.kodecamp.learnkotlin.R
import com.kodecamp.learnkotlin.databinding.TopicListItemBinding

class TopicListAdapter : RecyclerView.Adapter<TopicListAdapter.ViewHolder>()
{

    companion object {
        var topicTitles = arrayListOf("Android Basics in Kotlin",
            "Jetpack Compose", "Kotlin coroutines", "Advanced Android Development")

        var topicDescriptions = arrayListOf("Welcome to Android Basics in Kotlin! In this course, you will learn the basics....",
            "Get started with Jetpack Compose, a modern toolkit for building Android UI.",
            "Use coroutines to simplify task management for commons use cases....",
            "Expand the user experience, improve app performance, and add features like....")

        var topicDifficulty = arrayListOf("Training Level: Beginner", "Training Level: Intermediate",
            "Training Level: Intermediate", "Training Level:  Advanced")

        var topicDetails = arrayListOf("Welcome to Android Basics in Kotlin! In this course, you'll learn the basics" +
                " of building Android apps with the Kotlin programming language. Along the way, you'll develop a collection of" +
                " apps to start your journey as an Android developer.\n\n Learn more at https://developer.android.com/courses/android-basics-kotlin/course",
            "Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development" +
                    " on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.\n\n" +
                    "Learn more at https://developer.android.com/jetpack/compose",
            "Learn to use coroutines to simplify background task management in common use cases, such as making network calls" +
                    " and accessing local data.\n\n Learn more at https://developer.android.com/courses/pathways/android-coroutines?hl=nl", "Take your Android coding skills to the next level in our free, self-paced" +
                    " Advanced Android Development training. The course uses the Java programming language and teaches you ways" +
                    " to expand the user experience, improve app performance, and add features like custom views, animations" +
                    ", and location-awareness. \n\n Learn more at https://developer.android.com/courses/advanced-training/overview")
        val topicImage = arrayListOf(R.drawable.img_1, R.drawable.img_2, R.drawable.img_3, R.drawable.img_4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val topicListBinding = TopicListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(topicListBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.allViews(position)
    }

    override fun getItemCount() = topicTitles.size

    class ViewHolder(private val binding: TopicListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun allViews(position: Int) {
            binding.topicTitle.text = topicTitles[position]
            binding.topicDescription.text = topicDescriptions[position]
            binding.topicDifficulty.text = topicDifficulty[position]
            binding.topicImage.setImageResource(topicImage[position])

            binding.topicHolder.setOnClickListener {
                val title = topicTitles[position]
                val details = topicDetails[position]
                val image = topicImage[position]

                val bundle = Bundle()
                bundle.putString("TITLE", title)
                bundle.putString("DETAILS", details)
                bundle.putInt("IMAGE", image)
                Navigation.findNavController(binding.root).navigate(R.id.action_topicListFragment_to_topicDetailsFragment, bundle)
            }
        }
    }
}