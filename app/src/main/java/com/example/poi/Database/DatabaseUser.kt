//package com.example.poi.Database
//
//import android.content.ContentValues
//import android.content.Context
//import android.database.Cursor
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//import android.util.Log
//
//class DatabaseUser(context: Context) : SQLiteOpenHelper(context, "User", null, 1) {
//
//    companion object {
//        const val Table_User = "User"
//        const val Name = "Name"
//        const val LastName = "LastName"
//        const val Email = "Email"
//        const val Password = "Password"
//        const val Ege = "Ege"
//    }
//
//    override fun onCreate(db: SQLiteDatabase?) {
//        val createTable =
//            "CREATE TABLE $Table_User ( $Name TEXT PRIMARY KEY, " +
//                    "$LastName TEXT, "+
//                    "$Password INTEGER, "+
//                    "$Ege INTEGER, "+
//                    "$Email TEXT ) "
//        db?.execSQL(createTable)
//        Log.d("TAGXX", "onCreate: Database created successfully.")
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//        db?.execSQL("DROP TABLE IF EXISTS $Table_User")
//        onCreate(db)
//    }
//
//    fun addUser(user: ModelUser) {
//        val db = this.writableDatabase
//        val contentValues = ContentValues()
//        contentValues.put(Name, user.name)
//        contentValues.put(LastName, user.lastname)
//        contentValues.put(Password, user.Password)
//        contentValues.put(Ege, user.Ege)
//        contentValues.put(Email, user.Email)
//        db.insert(Table_User, null, contentValues)
//        db.close()
//        Log.d("tagq", "User added successfully.")
//    }
//
//
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
//
//
//}
