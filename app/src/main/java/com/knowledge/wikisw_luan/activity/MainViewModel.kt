package com.knowledge.wikisw_luan.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.knowledge.wikisw_luan.data.repository.SwRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: SwRepository) : ViewModel() {
    private val _state : MutableLiveData<Any> = MutableLiveData()
    val state : MutableLiveData<Any> get() = _state
    fun getCharacters() {
        viewModelScope.launch {
            val list = repository.getCharacters()
            _state.postValue(SwState.ShowCharacters(list))
        }
    }
}