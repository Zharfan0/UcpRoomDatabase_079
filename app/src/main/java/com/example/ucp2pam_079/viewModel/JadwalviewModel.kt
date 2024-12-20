package com.example.ucp2pam_079.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2pam_079.data.entity.Jadwal
import com.example.ucp2pam_079.data.repository.JadwalRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class JadwalViewModel(private val repository: JadwalRepository) : ViewModel() {

    private val _jadwalList = MutableStateFlow<List<Jadwal>>(emptyList())
    val jadwalList: StateFlow<List<Jadwal>> get() = _jadwalList

    fun insertJadwal(jadwal: Jadwal) {
        viewModelScope.launch {
            repository.insertJadwal(jadwal)
            loadJadwalList() // Refresh list after insertion
        }
    }

    fun loadJadwalList() {
        viewModelScope.launch {
            _jadwalList.value = repository.getAllJadwal()
        }
    }
}

