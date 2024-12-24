package com.example.ucp2pam_079.data.repository

import com.example.ucp2pam_079.data.dao.SupplierDao
import com.example.ucp2pam_079.data.entity.Supplier
import kotlinx.coroutines.flow.Flow

class LocalRepoSup(
    private val supplierDao: SupplierDao
): RepoSup {
    override suspend fun insertSup(supplier: Supplier) {
        supplierDao.insertSupplier(supplier)
    }

    override fun getAllSup(): Flow<List<Supplier>> {
        return supplierDao.getAllSupplier()
    }

    override fun getSup(idSup: Int): Flow<Supplier> {
        return supplierDao.getSupplier(idSup)
    }

}