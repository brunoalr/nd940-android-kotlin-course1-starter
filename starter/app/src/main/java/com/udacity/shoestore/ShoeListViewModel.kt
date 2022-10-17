package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel(newList: List<Shoe>) : ViewModel() {
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    fun addNewShow(shoe: Shoe) {
        _shoeList.value = _shoeList.value?.plus(shoe) ?: listOf(shoe)
    }

    init {
        _shoeList.value = newList
    }
}