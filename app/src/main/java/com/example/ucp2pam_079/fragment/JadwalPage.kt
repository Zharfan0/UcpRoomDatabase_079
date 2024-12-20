package com.example.ucp2pam_079.fragment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ucp2pam_079.data.entity.Jadwal
import com.example.ucp2pam_079.viewModel.JadwalViewModel

@Composable
fun JadwalScreen(viewModel: JadwalViewModel) {
    var jadwalList by remember { mutableStateOf(listOf<Jadwal>()) }
    var namaDokter by remember { mutableStateOf("") }
    var namaPasien by remember { mutableStateOf("") }
    var tanggal by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Jadwal Page", style = MaterialTheme.typography.titleLarge)

        BasicTextField(
            value = namaDokter,
            onValueChange = { namaDokter = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.padding(8.dp)) {
                    if (namaDokter.isEmpty()) Text("Nama Dokter")
                    innerTextField()
                }
            }
        )

        BasicTextField(
            value = namaPasien,
            onValueChange = { namaPasien = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.padding(8.dp)) {
                    if (namaPasien.isEmpty()) Text("Nama Pasien")
                    innerTextField()
                }
            }
        )

        BasicTextField(
            value = tanggal,
            onValueChange = { tanggal = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.padding(8.dp)) {
                    if (tanggal.isEmpty()) Text("Tanggal Konsultasi")
                    innerTextField()
                }
            }
        )

        BasicTextField(
            value = noHp,
            onValueChange = { noHp = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.padding(8.dp)) {
                    if (noHp.isEmpty()) Text("No HP")
                    innerTextField()
                }
            }
        )

        BasicTextField(
            value = status,
            onValueChange = { status = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.padding(8.dp)) {
                    if (status.isEmpty()) Text("Status")
                    innerTextField()
                }
            }
        )

        Button(onClick = {
            viewModel.insertJadwal(
                Jadwal(
                    namaDokter = namaDokter,
                    namaPasien = namaPasien,
                    tanggalKonsultasi = tanggal,
                    noHp = noHp,
                    status = status
                )
            )
            // Reset input fields
            namaDokter = ""
            namaPasien = ""
            tanggal = ""
            noHp = ""
            status = ""
        }, modifier = Modifier.padding(8.dp)) {
            Text("Add Jadwal")
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(jadwalList) { jadwal ->
                Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Text(jadwal.namaDokter, modifier = Modifier.weight(1f))
                    Text(jadwal.namaPasien, modifier = Modifier.weight(1f))
                }
            }
        }
    }
}


