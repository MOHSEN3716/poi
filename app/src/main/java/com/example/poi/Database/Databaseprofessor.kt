package com.example.poi.Database
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class Databaseprofessor(context: Context) : SQLiteOpenHelper(context, "professor", null, 1) {

    companion object {
        const val Table_professor = "professor"
        const val Name = "Name"
        const val LastName = "LastName"
        const val Course = "Course"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable =
            "CREATE TABLE $Table_professor ( $Name TEXT PRIMARY KEY, " +
                    "$LastName TEXT, "+
                    "$Course TEXT ) "

        db?.execSQL(createTable)
        Log.d("TAGXX", "onCreate: Database created successfully.")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $Table_professor")
        onCreate(db)
    }

    fun addprofessor(user: Modelprofessor) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Name, user.name)
        contentValues.put(LastName, user.lastname)
        contentValues.put(Course, user.Course)


        db.insert(Table_professor, null, contentValues)
        db.close()
        Log.d("tagq", "User added successfully.")
    }


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


}
