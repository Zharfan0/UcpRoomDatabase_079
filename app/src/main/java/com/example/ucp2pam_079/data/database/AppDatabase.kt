package com.example.ucp2pam_079.data.database

import DokterDao
import JadwalDao
import android.content.Context
import android.provider.CalendarContract.Instances
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ucp2pam_079.data.entity.Dokter
import com.example.ucp2pam_079.data.entity.Jadwal

@Database(entities = [Dokter::class, Jadwal::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract  fun dokterDao(): DokterDao
    abstract  fun jadwalDao(): JadwalDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return  INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}