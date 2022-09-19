package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater, R.layout.fragment_login, container, false
        )

        val joinButton = binding.buttonJoin
        joinButton.setOnClickListener {
            navigateToWelcomeFragment()
        }

        val signinButton = binding.buttonSignin
        signinButton.setOnClickListener {
            navigateToWelcomeFragment()
        }

        return binding.root
    }

    private fun navigateToWelcomeFragment() {
        val navController = findNavController()
        navController.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }
}