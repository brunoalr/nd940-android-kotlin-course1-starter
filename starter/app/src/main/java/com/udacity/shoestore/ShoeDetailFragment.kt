package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {
    private val viewModel: ShoeListViewModel by activityViewModels(factoryProducer = { ShoeListViewModelFactory() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        val cancelButton = binding.detailCancelButton
        cancelButton.setOnClickListener {
            navigateToShoeList()
        }

        val saveButton = binding.detailSaveButton
        saveButton.setOnClickListener {
            val shoe = with(binding) {
                Shoe(
                    name = shoeNameEditText.text.toString(),
                    size = if (shoeSizeEditText.text.toString()
                            .isNotEmpty()
                    ) shoeSizeEditText.text.toString().toDouble() else 0.0,
                    company = companyEditText.text.toString(),
                    description = shoeDescriptionEditText.text.toString()
                )
            }
            viewModel.addNewShow(shoe)
            navigateToShoeList()
        }

        return binding.root
    }

    private fun navigateToShoeList() {
        val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        findNavController().navigate(action)
    }
}