package com.example.ucp2pam_079.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "barang")
data class Barang(
    @PrimaryKey(autoGenerate = true)
    val idBarang: Int = 0,
    val nama: String,
    val deskripsi: String,
    val harga: String,
    val stok: Int,
    val nama_sup: String,
)