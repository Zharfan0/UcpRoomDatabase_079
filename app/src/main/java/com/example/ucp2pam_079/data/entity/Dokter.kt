package com.example.ucp2pam_079.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Dokter")
data class Dokter(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama: String,
    val spesialis: String,
    val klinik: Double,
    val noHp: Int,
    val jamKerja: String
)