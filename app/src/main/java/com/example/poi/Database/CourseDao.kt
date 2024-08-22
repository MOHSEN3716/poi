import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Query("SELECT * FROM Course")
    fun getAllCourses(): Flow<List<Course>>

    @Transaction
    @Query("SELECT * FROM Course, Professor WHERE Course.professorId = Professor.id")
    fun getCoursesWithProfessors(): Flow<List<CourseWithProfessor>>
    @Insert
    suspend fun insertCourse(course: Course)

    @Insert
    suspend fun insertProfessor(professor: Professor)
}
