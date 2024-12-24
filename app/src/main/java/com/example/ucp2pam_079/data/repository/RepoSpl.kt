package com.example.ucp2pam_079.data.repository

import com.example.ucp2pam_079.data.entity.Supplier
import kotlinx.coroutines.flow.Flow

interface RepoSup {
    suspend fun insertSup(supplier: Supplier)

    fun getAllSup() : Flow<List<Supplier>>

    fun getSup(idSup: Int): Flow<Supplier>
}