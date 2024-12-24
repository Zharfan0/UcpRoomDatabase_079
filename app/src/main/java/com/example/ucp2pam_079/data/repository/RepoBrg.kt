package com.example.ucp2pam_079.data.repository

import com.example.ucp2pam_079.data.entity.Barang
import kotlinx.coroutines.flow.Flow

interface RepoBrg {
    suspend fun insertBrg(barang: Barang)

    fun getAllBrg() : Flow<List<Barang>>

    fun getBrg(idBarang: Int) : Flow<Barang>

    suspend fun deleteBrg(barang: Barang)

    suspend fun updateBrg(barang: Barang)
}