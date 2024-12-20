import androidx.room.*
import com.example.ucp2pam_079.data.entity.Jadwal

@Dao
interface JadwalDao {
    @Insert
    suspend fun insertJadwal(jadwal: Jadwal)

    @Query("SELECT * FROM jadwal")
    suspend fun getAllJadwal(): List<Jadwal>

    @Update
    suspend fun updateJadwal(jadwal: Jadwal)

    @Delete
    suspend fun deleteJadwal(jadwal: Jadwal)

    @Query("SELECT * FROM jadwal WHERE id = :id")
    suspend fun getJadwalById(id: Int): Jadwal
}
