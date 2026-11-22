package udg.cuvalles.app.mydataroom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
        @Query("SELECT * FROM User ORDER BY uid DESC")
        fun getAll(): Flow<List<User>>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insert(user: User)

        @Delete
        suspend fun delete(user: User)
}