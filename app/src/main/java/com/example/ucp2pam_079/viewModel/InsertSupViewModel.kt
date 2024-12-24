package com.example.ucp2pam_079.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2pam_079.data.repository.RepoSup
import com.example.ucp2pam_079.data.entity.Supplier
import kotlinx.coroutines.launch

class InsertSupViewModel(private val repoSup: RepoSup) : ViewModel() {
    var uiState by mutableStateOf(SupUIState())

    fun updateStateSup(supplierEvent: SupplierEvent) {
        uiState = uiState.copy(
            supplierEvent = supplierEvent
        )
    }

    private fun validateFieldsSup(): Boolean {
        val event = uiState.supplierEvent
        val errorState = FormErrorState(
            namaSup = if (event.namaSup.isNotEmpty()) null else "Nama Supplier tidak boleh kosong",
            kontakSup = if (event.kontakSup.isNotEmpty()) null else "Kontak Supplier tidak boleh kosong",
            alamatSup = if (event.alamatSup.isNotEmpty()) null else "Alamat Supplier tidak boleh kosong",
        )

        uiState = uiState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }

    fun saveDataSup() {
        val currentEvent = uiState.supplierEvent

        if (validateFieldsSup()) {
            viewModelScope.launch {
                try {
                    repoSup.insertSup(currentEvent.toSupplierEntity())
                    uiState = uiState.copy(
                        snackBarMessage = "Data Supplier Berhasil Disimpan",
                        supplierEvent = SupplierEvent(),
                        isEntryValid = FormErrorState()
                    )
                } catch (e: Exception) {
                    uiState = uiState.copy(
                        snackBarMessage = "Data Supplier gagal disimpan"
                    )
                }
            }
        } else {
            uiState = uiState.copy(
                snackBarMessage = "Input tidak valid. Periksa kembali data Anda."
            )
        }
    }

    fun resetSnackBarMessage() {
        uiState = uiState.copy(snackBarMessage = null)
    }
}

data class SupUIState(
    val supplierEvent: SupplierEvent = SupplierEvent(),
    val isEntryValid: FormErrorState = FormErrorState(),
    val snackBarMessage: String? = null
)

data class FormErrorState(
    val namaSup: String? = null,
    val kontakSup: String? = null,
    val alamatSup: String? = null
) {
    fun isValid(): Boolean {
        return namaSup == null && kontakSup == null && alamatSup == null
    }
}

data class SupplierEvent(
    val namaSup: String = "",
    val kontakSup: String = "",
    val alamatSup: String = ""
)



fun SupplierEvent.toSupplierEntity(): Supplier = Supplier(
    namaSup = namaSup,
    kontakSup = kontakSup,
    alamatSup = alamatSup
)

