package com.kodecamp.learnkotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kodecamp.learnkotlin.R
import com.kodecamp.learnkotlin.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private var binding: FragmentSignInBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentSignInBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner =viewLifecycleOwner
            signIn = this@SignInFragment
        }
    }

    fun goToForgotPasswordScreen() {
        findNavController().navigate(R.id.action_signInFragment_to_forgotPasswordFragment)
    }

    fun goToSignUpScreen() {
        findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
    }

    fun goToDashboard() {
        findNavController().navigate(R.id.action_signInFragment_to_topicListFragment)
    }
}