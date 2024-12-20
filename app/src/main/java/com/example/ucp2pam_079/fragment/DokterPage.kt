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
    var dokterList by remember { mutableStateOf(listOf<Dokter>()) }
    var nama by remember { mutableStateOf("") }
    var spesialis by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Dokter Page", style = MaterialTheme.typography.titleLarge)

        BasicTextField(
            value = nama,
            onValueChange = { nama = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.padding(8.dp)) {
                    if (nama.isEmpty()) Text("Nama Dokter")
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
                    if (spesialis.isEmpty()) Text("Spesialis")
                    innerTextField()
                }
            }
        )

        Button(onClick = {
            viewModel.insertDokter(Dokter(nama, spesialis))
            nama = ""
            spesialis = ""
        }, modifier = Modifier.padding(8.dp)) {
            Text("Add Dokter")
        }

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

