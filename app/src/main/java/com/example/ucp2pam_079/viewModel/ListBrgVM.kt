package com.example.ucp2pam_079.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2pam_079.data.entity.Barang
import com.example.ucp2pam_079.data.repository.RepoBrg
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class ListBrgViewModel(
    private val repoBrg: RepoBrg
) : ViewModel(){
    val listBrgUiState: StateFlow<ListBrgUIstate> = repoBrg.getAllBrg()
        .filterNotNull()
        .map {
            ListBrgUIstate(
                listBrg = it.toList(),
                isLoading = false,
            )
        }
        .onStart {
            emit(ListBrgUIstate(isLoading = true))
            delay(900)
        }
        .catch {
            emit(
                ListBrgUIstate(
                    isLoading = false,
                    isError = false,
                    errorMessage = it.message?: "Terjadi Kesalahan"
                )
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = ListBrgUIstate(
                isLoading = true
            )
        )
}

data class ListBrgUIstate(
    val listBrg: List<Barang> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)