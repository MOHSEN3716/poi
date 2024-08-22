import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private lateinit var database: CourseDatabase
class AddCourseViewModel : ViewModel() {
    private val ioScope = CoroutineScope(Dispatchers.IO)
    fun insertCourse(course: Course) {
        fun getAllCourses() = ioScope.launch {
            val courseDao = database.courseDao()
            courseDao.insertCourse(course)
        }
        }

}