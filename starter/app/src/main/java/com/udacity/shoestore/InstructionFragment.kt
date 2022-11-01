package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentInstructionBinding>(
            inflater,
            R.layout.fragment_instruction,
            container,
            false
        )

        val shoeListButton = binding.shoeListButton
        shoeListButton.setOnClickListener {
            val action = InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment()
            val navOptions = NavOptions.Builder().setPopUpTo(R.id.LoginFragment, true).build()
            findNavController().navigate(action, navOptions)
        }

        return binding.root
    }

}