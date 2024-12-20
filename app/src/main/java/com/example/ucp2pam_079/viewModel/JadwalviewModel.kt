package com.example.ucp2pam_079.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2pam_079.data.entity.Jadwal
import com.example.ucp2pam_079.data.repository.JadwalRepository
import kotlinx.coroutines.launch

class JadwalViewModel(private val repository: JadwalRepository) : ViewModel() {
    fun insertJadwal(jadwal: Jadwal) {
        viewModelScope.launch {
            repository.insertJadwal(jadwal)
        }
    }

    suspend fun getAllJadwal() = repository.getAllJadwal()
    fun updateJadwal(jadwal: Jadwal) {
        viewModelScope.launch {
            repository.updateJadwal(jadwal)
        }
    }

    fun deleteJadwal(jadwal: Jadwal) {
        viewModelScope.launch {
            repository.deleteJadwal(jadwal)
        }
    }
}
