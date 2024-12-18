package com.example.ucp2pam_079.data.repository

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "barang")
data class Barang(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama: String,
    val deskripsi: String,
    val harga: Double,
    val stok: Int,
    val namaSuplier: String
)
