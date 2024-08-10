package com.example.poi.Database
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class Databaseprofessor(context: Context) : SQLiteOpenHelper(context, "professor", null, 1) {
        companion object {
            const val TABLE_PROFESSOR = "professor"
            const val NAME = "Name"
            const val LAST_NAME = "LastName"
            const val TABLE_COURSES = "courses"
            const val COURSE_NAME = "name"
            const val TABLE_PROFESSOR_COURSES = "professor_courses"
        }

        override fun onCreate(db: SQLiteDatabase?) {
            val createProfessorTable = "CREATE TABLE $TABLE_PROFESSOR " +
                    "($NAME TEXT PRIMARY KEY," +
                    " $LAST_NAME TEXT)"
            val createCoursesTable = "CREATE TABLE $TABLE_COURSES " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " $COURSE_NAME TEXT)"
            val createProfessorCoursesTable = "CREATE TABLE $TABLE_PROFESSOR_COURSES " +
                    "(professor_id TEXT," +
                    " course_id INTEGER" +
                    ", FOREIGN KEY(professor_id) " +
                    "REFERENCES $TABLE_PROFESSOR($NAME)" +
                    ", FOREIGN KEY(course_id)" +
                    " REFERENCES $TABLE_COURSES(id))"

            db?.execSQL(createProfessorTable)
            db?.execSQL(createCoursesTable)
            db?.execSQL(createProfessorCoursesTable)

            // افزودن دروس به جدول courses
            val courses = listOf("ریاضی پیش", "ریاضی 1", "فیزیک 1")
            courses.forEach { course ->
                val values = ContentValues().apply {
                    put(COURSE_NAME, course)
                }
                db?.insert(TABLE_COURSES, null, values)
            }
        }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_PROFESSOR")
        onCreate(db)
    }


    // ... سایر متدها ...

        fun addProfessor(user: Modelprofessor, courseIds: List<Int>) {
            val db = this.writableDatabase
            val contentValues = ContentValues()
            contentValues.put(NAME, user.name)
            contentValues.put(LAST_NAME, user.lastname)
            val professorId = db.insertOrThrow(TABLE_PROFESSOR, null, contentValues)

            courseIds.forEach { courseId ->
                val professorCourseValues = ContentValues().apply {
                    put("professor_id", professorId)
                    put("course_id", courseId)
                }
                db?.insert(TABLE_PROFESSOR_COURSES, null, professorCourseValues)
            }
            db.close()
        }
    }



//    override fun onCreate(db: SQLiteDatabase?) {
//        val createTable =
//            "CREATE TABLE $Table_professor ( $Name TEXT PRIMARY KEY, " +
//                    "$LastName TEXT, " +
//                    "$Course TEXT ) "
//
//        db?.execSQL(createTable)
//        db?.execSQL("UPDATE $Table_professor SET $Course = 'ریاضی پیش, ریاضی 1, فیزیک 1, مبانی جامعه شناسی, زبان فارسی, زبان انگلیسی پیش ترکیبی, تربیت بدنی, اندیشه اسلامی 1, ریاضی 2, فیزیک 2, استاتیک و مقاومت مصالح, مبانی برنامه سازی کامپیوتر, مبانی تحقیق در عملیات, نقشه کشی و نقشه خوانی مهندسی 1, زبان انگلیسی ترکیبی 1, آزمایشگاه فیزیک 1, اندیشه اسلامی 2, فرایندهای تولید 1, احتمالات و کاربرد, تحقیق در عملیات 1, معادلات دیفرانسیل, اقتصاد عمومی 1, زبان انگلیسی ترکیبی 2, آزمایشگاه فیزیک 2, اخلاق اسلامی, انس با قرآن, علم مواد, آمار مهندسی, تحقیق در عملیات 2, مبانی مهندسی برق, اقتصاد عمومی 2, محاسبات عددی, زبان انگلیسی ترکیبی 3, تاریخ فرهنگ و تمدن اسلام و ایران, کارگاه فلزکاری, اصول حسابداری و هزینه یابی, ارزیابی کار و زمان, اقتصاد مهندسی, کنترل کیفیت 1, تحلیل سیستم ها, تفسیر موضوعی قرآن, کارگاه ماشینهای افزار, ورزش 1, برنامه ریزی کنترل تولید و موجودی ها, طرحریزی واحدهای صنعتی, مدیریت و کنترل پروژه, شبیه سازی, سیستم های اطلاعاتی مدیریت, اصول مدیریت و تئوری سازمان, دانش خانواده و جمعیت, برنامه ریزی نگهداری و تعمیرات, برنامه ریزی تولید, تحلیل تصمیم گیری, مدیریت مالی, کارآموزی, انقلاب اسلامی ایران, طراحی ایجاد صنایع, مبانی مدیریت کیفیت و بهره وری, تحلیل اطلاعات در کسب و کارها, اصول بازاریابی, روش تحقیق و گزارش نویسی, آشنایی با ارزشهای دفاع مقدس, تاریخ امامت درس ها و توصیه های امام خمینی (ره)\n" +
//                "\n'")
//
//        Log.d("TAGXX", "onCreate: Database created successfully.")
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//        db?.execSQL("DROP TABLE IF EXISTS $Table_professor")
//        onCreate(db)
//    }
//
//    fun addprofessor(user: Modelprofessor) {
//        val db = this.writableDatabase
//        val contentValues = ContentValues()
//        contentValues.put(Name, user.name)
//        contentValues.put(LastName, user.lastname)
//        contentValues.put(Course, user.Course)
//
//
//        db.insert(Table_professor, null, contentValues)
//        db.close()
//        Log.d("tagq", "${Course}")
//    }


//    fun getAllUsers(): List<ModelUser> {
//        val userList = mutableListOf<ModelUser>()
//        val db = readableDatabase
//        val query = "SELECT * FROM $Table_User"
//        val cursor = db.rawQuery(query, null)
//        cursor.use {
//            while (it.moveToNext()) {
//                val user = ModelUser(
//                    it.getString(it.getColumnIndexOrThrow(Name)),
//                    it.getString(it.getColumnIndexOrThrow(LastName)),
//                    it.getString(it.getColumnIndexOrThrow(Email)),
//                    it.getInt(it.getColumnIndexOrThrow(Password)),
//                    it.getInt(it.getColumnIndexOrThrow(Ege))
//                )
//                userList.add(user)
//            }
//        }
//        db.close()
//        return userList
//    }

