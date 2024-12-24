package com.example.ucp2pam_079.viewModel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2pam_079.data.entity.Barang
import com.example.ucp2pam_079.data.repository.RepoBrg
import kotlinx.coroutines.launch

class InsertBrgViewModel(private  val repoBrg: RepoBrg) : ViewModel(){

    var uiState by mutableStateOf(BrgUIState())

    fun updateBrgState(barangEvent: BarangEvent){
        uiState = uiState.copy(
            barangEvent = barangEvent
        )
    }

    private fun validateBrgField(): Boolean{
        val event = uiState.barangEvent
        val errorBrgState = FormErrorBrgState(
            nama = if (event.nama.isNotEmpty()) null else "Nama barang tidak boleh kosong",
            deskripsi = if (event.deskripsi.isNotEmpty()) null else "Deskripsi tidak boleh kosong",
            harga = if (event.harga.isNotEmpty()) null else "Harga tidak boleh kosong",
            stok = if (event.stok.isNotEmpty()) null else "Stok tidak boleh kosong",
            nama_sup = if (event.nama_sup.isNotEmpty()) null else "Nama Supplier tidak boleh kosong"
        )

        uiState = uiState.copy(isEntryValid = errorBrgState)
        return errorBrgState.isBrgValid()
    }

    fun saveDataBrg(){
        val currentEvent = uiState.barangEvent

        if (validateBrgField()){
            viewModelScope.launch {
                try {
                    repoBrg.insertBrg(currentEvent.toBarangEntity())
                    uiState = uiState.copy(
                        snackbarMessage = "Data Barang Berhasil Diasimpan",
                        barangEvent = BarangEvent(),
                        isEntryValid = FormErrorBrgState()
                    )
                } catch (e: Exception){
                    uiState = uiState.copy(
                        snackbarMessage = "Data barang gagal disimpan"
                    )
                }
            }
        } else{
            uiState = uiState.copy(
                snackbarMessage = "Input tidak valid. Periksa kembali data anda."
            )
        }
    }
    fun resetSnackBarMessageBrg(){
        uiState = uiState.copy(snackbarMessage = null)
    }
}


data class BrgUIState(
    val barangEvent: BarangEvent = BarangEvent(),
    val isEntryValid : FormErrorBrgState = FormErrorBrgState(),
    val snackbarMessage: String? = null
)

data class FormErrorBrgState(
    val idBarang: String? = null,
    val nama: String? = null,
    val deskripsi: String? = null,
    val harga: String? = null,
    val stok: String? = null,
    val nama_sup: String? = null,

    ){
    fun isBrgValid(): Boolean {
        return nama == null && deskripsi == null &&
                harga == null && stok == null && nama_sup == null
    }
}


fun BarangEvent.toBarangEntity(): Barang = Barang(
    idBarang = idBarang,
    nama = nama,
    deskripsi = deskripsi,
    harga = harga,
    stok = stok.toInt(),
    nama_sup = nama_sup
)

data class BarangEvent(
    val idBarang: Int = 0,
    val nama: String = "",
    val deskripsi: String = "",
    val harga: String = "",
    val stok: String = "",
    val nama_sup: String = "",
)

object ListSup {
    @Composable
    fun DataSup(
        supViewModel: ListSupViewModel = viewModel(factory = PenydiaVM.Factory)
    ): List<String>{
        val GetAllNamaSup by supViewModel.listUiState.collectAsState()
        val NamaSup = GetAllNamaSup.listSup.map { it.namaSup }
        return NamaSup
    }
}