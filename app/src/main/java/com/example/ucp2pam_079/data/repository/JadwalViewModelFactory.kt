package com.example.ucp2pam_079.data.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ucp2pam_079.data.repository.JadwalRepository
import com.example.ucp2pam_079.viewModel.JadwalViewModel

class JadwalViewModelFactory(private val repository: JadwalRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JadwalViewModel::class.java)) {
            return JadwalViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
