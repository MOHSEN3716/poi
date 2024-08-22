import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Course(
    val id: Int, @PrimaryKey(autoGenerate = true)
    val name: String,
    val professorId: Int
)

@Entity
data class Professor(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String
)

@Entity
data class CourseWithProfessor(
    @Embedded val course: Course,
    @Embedded val professor: Professor
)