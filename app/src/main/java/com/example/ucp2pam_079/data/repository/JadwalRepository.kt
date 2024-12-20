package com.example.ucp2pam_079.data.repository

import com.example.ucp2pam_079.data.entity.Jadwal
import JadwalDao

class JadwalRepository(private val jadwalDao: JadwalDao) {
    suspend fun insertJadwal(jadwal: Jadwal) {
        jadwalDao.insertJadwal(jadwal)
    }

    suspend fun getAllJadwal(): List<Jadwal> {
        return jadwalDao.getAllJadwal()
    }
}
