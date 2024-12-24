package com.example.ucp2pam_079.viewModel

import androidx.lifecycle.ViewModel

class HomeVM(
): ViewModel(){
}

data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)