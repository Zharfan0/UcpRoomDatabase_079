package com.example.ucp2pam_079.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Jadwal(
    val namaDokter: String,
    val namaPasien: String,
    val tanggalKonsultasi: String,
    val noHp: String,
    val status: String
)
