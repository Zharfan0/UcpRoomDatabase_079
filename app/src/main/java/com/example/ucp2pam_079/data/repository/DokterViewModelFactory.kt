package com.example.ucp2pam_079.data.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ucp2pam_079.data.repository.DokterRepository
import com.example.ucp2pam_079.viewModel.DokterViewModel

class DokterViewModelFactory(private val repository: DokterRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DokterViewModel::class.java)) {
            return DokterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
