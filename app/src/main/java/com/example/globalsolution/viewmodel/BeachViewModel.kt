package com.example.globalsolution.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.globalsolution.model.Beach

class BeachViewModel : ViewModel() {

    private var items = mutableListOf<Beach>()
    val itemsLiveData = MutableLiveData<List<Beach>>()

    fun addItem(name: String, city: String, state: String) {
        val item = Beach(id = 0, name = name, city = city, state = state, onRemove = ::removeItem)
        items.add(item)
        itemsLiveData.value = items
    }

    private fun removeItem(item: Beach) {
        items.remove(item)
        itemsLiveData.value = items
    }

}