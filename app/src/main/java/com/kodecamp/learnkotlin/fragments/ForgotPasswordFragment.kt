package com.kodecamp.learnkotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kodecamp.learnkotlin.R
import com.kodecamp.learnkotlin.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment() {

    private var binding: FragmentForgotPasswordBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner =viewLifecycleOwner
            submit = this@ForgotPasswordFragment
        }

//        binding.submitBtn.setOnClickListener {
//            inputValidEmail()
//        }
//
//        binding.backToSignIn.setOnClickListener {
//            navCon.navigate(R.id.action_forgotPasswordFragment_to_signInFragment)
//        }
    }

    fun backToSignInScreen() {
        findNavController().navigate(R.id.action_forgotPasswordFragment_to_signInFragment)
    }

//    private fun inputValidEmail() {
//        if (binding.enterEmail.length()==0){
//            binding.enterEmail.error = "Provide Email"
//        }else (navCon.navigate(R.id.action_forgotPasswordFragment_to_signInFragment))
//    }
}