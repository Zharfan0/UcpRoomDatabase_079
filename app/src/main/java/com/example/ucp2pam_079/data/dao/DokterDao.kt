import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ucp2pam_079.data.entity.Dokter

@Dao
interface DokterDao {
    @Insert
    suspend fun insertDokter(dokter: Dokter)

    @Query("SELECT * FROM dokter")
    suspend fun getAllDokter(): List<Dokter>
}
