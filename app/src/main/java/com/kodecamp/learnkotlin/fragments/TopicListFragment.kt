package com.kodecamp.learnkotlin.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodecamp.learnkotlin.R
import com.kodecamp.learnkotlin.adapter.TopicListAdapter
import com.kodecamp.learnkotlin.databinding.FragmentTopicListBinding

class TopicListFragment : Fragment() {

    private var binding: FragmentTopicListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentTopicListBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            dashboard = this@TopicListFragment
        }

        val activity = activity as Context

        val recyclerView = binding?.recyclerView
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.adapter = TopicListAdapter()
    }

    fun signOut() {
        findNavController().navigate(R.id.action_topicListFragment_to_signInFragment)
    }

    fun share() {
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_note))
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Learn More")
        startActivity(Intent.createChooser(shareIntent, "Learn More"))
    }

}