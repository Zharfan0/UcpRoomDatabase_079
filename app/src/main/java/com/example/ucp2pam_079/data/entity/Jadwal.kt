package com.example.ucp2pam_079.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jadwal")
data class Jadwal(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val namaDokter: String,
    val namaPasien: String,
    val noHp: String,
    val tanggalKonsultasi: String,
    val status: String
)