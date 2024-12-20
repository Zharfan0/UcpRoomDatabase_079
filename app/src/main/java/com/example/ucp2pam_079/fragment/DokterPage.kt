package com.example.ucp2pam_079.fragment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ucp2pam_079.data.entity.Dokter
import com.example.ucp2pam_079.viewModel.DokterViewModel

@Composable
fun DokterPage(viewModel: DokterViewModel) {
    var nama by remember { mutableStateOf("") }
    var spesialis by remember { mutableStateOf("") }
    var klinik by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var jamKerja by remember { mutableStateOf("") }

    val dokterList by viewModel.dokterList.collectAsState(initial = emptyList())

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Dokter Page", style = MaterialTheme.typography.titleLarge)

        // Input fields
        BasicTextField(value = nama, onValueChange = { nama = it }, modifier = Modifier.fillMaxWidth().padding(8.dp)) { innerTextField ->
            Box(modifier = Modifier.padding(8.dp)) {
                if (nama.isEmpty()) Text("Nama Dokter")
                innerTextField()
            }
        }
        BasicTextField(value = spesialis, onValueChange = { spesialis = it }, modifier = Modifier.fillMaxWidth().padding(8.dp)) { innerTextField ->
            Box(modifier = Modifier.padding(8.dp)) {
                if (spesialis.isEmpty()) Text("Spesialis")
                innerTextField()
            }
        }
        BasicTextField(value = klinik, onValueChange = { klinik = it }, modifier = Modifier.fillMaxWidth().padding(8.dp)) { innerTextField ->
            Box(modifier = Modifier.padding(8.dp)) {
                if (klinik.isEmpty()) Text("Klinik")
                innerTextField()
            }
        }
        BasicTextField(value = noHp, onValueChange = { noHp = it }, modifier = Modifier.fillMaxWidth().padding(8.dp)) { innerTextField ->
            Box(modifier = Modifier.padding(8.dp)) {
                if (noHp.isEmpty()) Text("No HP")
                innerTextField()
            }
        }
        BasicTextField(value = jamKerja, onValueChange = { jamKerja = it }, modifier = Modifier.fillMaxWidth().padding(8.dp)) { innerTextField ->
            Box(modifier = Modifier.padding(8.dp)) {
                if (jamKerja.isEmpty()) Text("Jam Kerja")
                innerTextField()
            }
        }

        Button(onClick = {
            viewModel.insertDokter(Dokter(0, nama, spesialis, klinik, noHp, jamKerja))
            nama = ""
            spesialis = ""
            klinik = ""
            noHp = ""
            jamKerja = ""
        }, modifier = Modifier.padding(8.dp)) {
            Text("Add Dokter")
        }

        // Display list of Dokter
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(dokterList) { dokter ->
                Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Text(dokter.nama, modifier = Modifier.weight(1f))
                    Text(dokter.spesialis, modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
