import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Course::class, Professor::class], version = 1)
abstract class CourseDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao

}
