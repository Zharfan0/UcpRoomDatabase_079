package com.example.ucp2pam_079.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ucp2pam_079.data.entity.Barang
import kotlinx.coroutines.flow.Flow

@Dao
interface BarangDao {
    @Insert
    suspend fun insertBarang( barang: Barang )

    @Query("SELECT * FROM barang")
    fun getAllBarang() : Flow<List<Barang>>

    @Query("SELECT * FROM barang WHERE idBarang = :idBarang")
    fun getBarang(idBarang: Int): Flow<Barang>

    @Delete
    suspend fun deleteBarang(barang: Barang)

    @Update
    suspend fun updateBarang(barang: Barang)
}