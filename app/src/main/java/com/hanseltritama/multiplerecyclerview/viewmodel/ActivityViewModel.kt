package com.hanseltritama.multiplerecyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanseltritama.multiplerecyclerview.model.Characters
import com.hanseltritama.multiplerecyclerview.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActivityViewModel : ViewModel() {

    val charactersLiveData: MutableLiveData<Characters> = MutableLiveData()

    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitInstance.getMortyAPI()?.getAllCharacters()
            charactersLiveData.postValue(response)
        }
    }
}