package com.example.ucp2pam_079.fragment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.ucp2pam_079.data.entity.Dokter
import com.example.ucp2pam_079.viewModel.DokterViewModel

@Composable
fun DokterScreen(viewModel: DokterViewModel) {
    var nama by remember { mutableStateOf(TextFieldValue("")) }
    var spesialis by remember { mutableStateOf(TextFieldValue("")) }
    var klinik by remember { mutableStateOf(TextFieldValue("")) }
    var noHp by remember { mutableStateOf(TextFieldValue("")) }
    var jamKerja by remember { mutableStateOf(TextFieldValue("")) }

    // Mengamati dokterList sebagai StateFlow
    val dokterList by viewModel.dokterList.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Tambah Dokter", style = MaterialTheme.typography.titleLarge)

        BasicTextField(
            value = nama,
            onValueChange = { nama = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.padding(8.dp)) {
                    if (nama.text.isEmpty()) Text("Nama Dokter")
                    innerTextField()
                }
            }
        )

        BasicTextField(
            value = spesialis,
            onValueChange = { spesialis = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.padding(8.dp)) {
                    if (spesialis.text.isEmpty()) Text("Spesialis")
                    innerTextField()
                }
            }
        )

        Button(
            onClick = {
                viewModel.insertDokter(
                    Dokter(
                        id = 0,
                        nama = nama.text,
                        spesialis = spesialis.text,
                        klinik = klinik.text,
                        noHp = noHp.text,
                        jamKerja = jamKerja.text
                    )
                )
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Simpan")
        }

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(dokterList) { dokter ->
                Row(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
                    Text(dokter.nama, modifier = Modifier.weight(1f))
                    Text(dokter.spesialis, modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
