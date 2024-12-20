package com.example.ucp2pam_079.data.repository

import com.example.ucp2pam_079.data.entity.Dokter
import DokterDao

class DokterRepository(private val dokterDao: DokterDao) {
    suspend fun insertDokter(dokter: Dokter) {
        dokterDao.insertDokter(dokter)
    }

    suspend fun getAllDokter(): List<Dokter> {
        return dokterDao.getAllDokter()
    }
}
