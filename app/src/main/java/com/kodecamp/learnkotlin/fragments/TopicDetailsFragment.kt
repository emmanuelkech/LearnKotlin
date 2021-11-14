package com.kodecamp.learnkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kodecamp.learnkotlin.R
import com.kodecamp.learnkotlin.databinding.FragmentTopicDetailsBinding
import kotlinx.android.synthetic.main.fragment_topic_details.*

class TopicDetailsFragment : Fragment() {

    private var binding: FragmentTopicDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentTopicDetailsBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        val bundle = arguments
        binding!!.title.text = bundle?.getString("TITLE")
        binding!!.details.text = bundle?.getString("DETAILS")
        binding!!.topicImage.setImageResource(bundle!!.getInt("IMAGE"))

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            topicDetails = this@TopicDetailsFragment
        }
    }

    fun goBack() {
        findNavController().navigate(R.id.action_topicDetailsFragment_to_topicListFragment)
    }
}