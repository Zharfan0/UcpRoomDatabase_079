package com.example.ucp2pam_079.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "supplier")
data class Supplier(
    @PrimaryKey(autoGenerate = true)
    val idSup: String = 0,
    val namaSup: String,
    val kontakSup: String,
    val alamatSup: String
)

