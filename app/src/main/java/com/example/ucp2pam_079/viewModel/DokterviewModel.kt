package com.example.ucp2pam_079.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2pam_079.data.entity.Dokter
import com.example.ucp2pam_079.data.repository.DokterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DokterViewModel(private val repository: DokterRepository) : ViewModel() {
    private val _dokterList = MutableStateFlow<List<Dokter>>(emptyList())
    val dokterList: StateFlow<List<Dokter>> get() = _dokterList

    init {
        loadDokterList()
    }

    fun insertDokter(dokter: Dokter) {
        viewModelScope.launch {
            repository.insertDokter(dokter)
            loadDokterList()
        }
    }

    fun loadDokterList() {
        viewModelScope.launch {
            _dokterList.value = repository.getAllDokter()
        }
    }
}
