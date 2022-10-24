package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeLayoutBinding
import com.udacity.shoestore.models.Shoe


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
        shoeDetailButton.setOnClickListener {
            val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
            findNavController().navigate(action)
        }

        viewModel.shoeList.observe(viewLifecycleOwner) { shoeList ->
            shoeList.forEach { shoe ->
                val shoeLayout = DataBindingUtil.inflate<ShoeLayoutBinding>(
                    inflater, R.layout.shoe_layout, container, false
                )
                shoeLayout.fromShoe(shoe)
                binding.shoeListLinearLayout.addView(shoeLayout.shoeLinearLayout)
            }
        }

        return binding.root
    }

    private fun ShoeLayoutBinding.fromShoe(shoe: Shoe) {
        shoeName.text = getString(R.string.name_format, shoe.name)
        shoeCompany.text = getString(R.string.company_format, shoe.company)
        shoeSize.text = getString(R.string.size_format, shoe.size)
        shoeDescription.text = getString(R.string.description_format, shoe.description)
    }
}