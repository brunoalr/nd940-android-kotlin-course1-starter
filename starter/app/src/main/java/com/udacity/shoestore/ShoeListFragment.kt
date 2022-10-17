package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeLayoutBinding


class ShoeListFragment : Fragment() {
    private val viewModel: ShoeListViewModel by activityViewModels(factoryProducer = { ShoeListViewModelFactory() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )

        val shoeDetailButton = binding.shoeDetailButton
        shoeDetailButton.setOnClickListener{
            val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
            findNavController().navigate(action)
        }

        viewModel.shoeList.observe(viewLifecycleOwner) { shoeList ->
            shoeList.forEach { shoe ->
                val shoeLayout = DataBindingUtil.inflate<ShoeLayoutBinding>(
                    inflater, R.layout.shoe_layout, container, false
                )
                with(shoeLayout) {
                    shoeName.text = shoe.name
                    shoeCompany.text = shoe.company
                    shoeSize.text = shoe.size.toString()
                    shoeDescription.text = shoe.description
                }

                binding.shoeListLinearLayout.addView(shoeLayout.shoeLinearLayout)
            }
        }

        return binding.root
    }
}