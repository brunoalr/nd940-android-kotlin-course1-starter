package com.udacity.shoestore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.models.Shoe

@Suppress("UNCHECKED_CAST")
class ShoeListViewModelFactory(private val shoeList: List<Shoe> = emptyList()) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoeListViewModel::class.java)) {
            return ShoeListViewModel(shoeList)  as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}