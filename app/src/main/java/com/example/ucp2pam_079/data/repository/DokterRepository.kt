package com.example.ucp2pam_079.data.repository

import DokterDao
import com.example.ucp2pam_079.data.entity.Dokter

class DokterRepository (private val dokterDao: DokterDao){
    suspend fun insertDokter(dokter: Dokter) = dokterDao.insertDokter(dokter)
    suspend fun getAllDokter() = dokterDao.getAllDokter()
}