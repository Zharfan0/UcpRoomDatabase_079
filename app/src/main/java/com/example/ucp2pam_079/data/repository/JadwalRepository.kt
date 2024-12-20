package com.example.ucp2pam_079.data.repository

import JadwalDao
import com.example.ucp2pam_079.data.entity.Jadwal

class JadwalRepository(private val jadwalDao: JadwalDao) {
    suspend fun insertJadwal(jadwal: Jadwal) = jadwalDao.insertJadwal(jadwal)
    suspend fun getAllJadwal() = jadwalDao.getAllJadwal()
    suspend fun updateJadwal(jadwal: Jadwal) = jadwalDao.updateJadwal(jadwal)
    suspend fun deleteJadwal(jadwal: Jadwal) = jadwalDao.deleteJadwal(jadwal)
    suspend fun getJadwalById(id: Int) = jadwalDao.getJadwalById(id)
}
