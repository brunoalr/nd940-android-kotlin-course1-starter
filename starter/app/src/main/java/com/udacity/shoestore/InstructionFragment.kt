package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentInstructionBinding>(
            inflater, R.layout.fragment_instruction, container, false
        )

        val shoeListButton = binding.shoeListButton
        shoeListButton.setOnClickListener {
            // TODO: setup directions to shoe list
        }

        return binding.root
    }

}