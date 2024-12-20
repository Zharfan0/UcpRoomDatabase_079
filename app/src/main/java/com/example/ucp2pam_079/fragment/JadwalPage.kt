package com.example.ucp2pam_079.fragment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.ucp2pam_079.data.entity.Jadwal
import com.example.ucp2pam_079.viewModel.JadwalViewModel

@Composable
fun JadwalScreen(viewModel: JadwalViewModel) {
    var namaDokter by remember { mutableStateOf(TextFieldValue("")) }
    var namaPasien by remember { mutableStateOf(TextFieldValue("")) }
    var noHp by remember { mutableStateOf(TextFieldValue("")) }
    var tanggal by remember { mutableStateOf(TextFieldValue("")) }
    var status by remember { mutableStateOf(TextFieldValue("")) }

    // Observasi data jadwal dari StateFlow
    val jadwalList by viewModel.jadwalList.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Tambah Jadwal", style = MaterialTheme.typography.titleLarge)

        BasicTextField(
            value = namaDokter,
            onValueChange = { namaDokter = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.padding(8.dp)) {
                    if (namaDokter.text.isEmpty()) Text("Nama Dokter")
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
                    if (namaPasien.text.isEmpty()) Text("Nama Pasien")
                    innerTextField()
                }
            }
        )

        Button(
            onClick = {
                viewModel.insertJadwal(
                    Jadwal(
                        id = 0,
                        namaDokter = namaDokter.text,
                        namaPasien = namaPasien.text,
                        noHp = noHp.text,
                        tanggal = tanggal.text,
                        status = status.text
                    )
                )
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Simpan")
        }

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(jadwalList) { jadwal ->
                Row(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
                    Text(jadwal.namaDokter, modifier = Modifier.weight(1f))
                    Text(jadwal.namaPasien, modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
