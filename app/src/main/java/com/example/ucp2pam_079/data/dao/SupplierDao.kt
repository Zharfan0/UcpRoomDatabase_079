package com.example.ucp2pam_079.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ucp2pam_079.data.entity.Supplier
import kotlinx.coroutines.flow.Flow

@Dao
interface SupplierDao {
    @Insert
    suspend fun insertSupplier(
        supplier: Supplier
    )

    @Query("SELECT * FROM supplier ORDER BY namaSup ASC")
    fun getAllSupplier() : Flow<List<Supplier>>

    @Query("SELECT * FROM supplier WHERE idSup = :idSup")
    fun getSupplier(idSup: Int): Flow<Supplier>

}