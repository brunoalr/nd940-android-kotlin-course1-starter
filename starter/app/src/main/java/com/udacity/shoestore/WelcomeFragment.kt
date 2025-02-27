package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentWelcomeBinding>(
            inflater, R.layout.fragment_welcome, container, false
        )

        val simpleInstructionText = binding.simpleInstructionText
        simpleInstructionText.text =
            getString(R.string.simple_instruction, getString(R.string.instructions_button))

        val instructionsButton = binding.instructionsButton
        instructionsButton.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }

}