package com.example.poi.Database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import kotlin.math.log

class DatabaseUser(context: Context) : SQLiteOpenHelper(context, "User", null, 1) {
    companion object {
        val Table_User = "User"
        val Name = "Name"
        val LastName = "LastName"
        val Email = "Email"
        val Password = "Password"
        val Ege = "Ege"

    }
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable =
            "CREATE TABLE ${Table_User} ( $Name integer primary key autoincrement, " +
                    "${LastName} text, "+
                    "${Password} integer, "+
                    "${Ege} integer, "+
                    "${Email} text ) "
        db?.execSQL(createTable)
        Log.d("TAGXX","onResponse")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun addUser(User:ModelUser) {
        var db= this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Name,User.name)
        contentValues.put(LastName,User.Lastname)
        contentValues.put(Password,User.Password)
        contentValues.put(Ege,User.Ege)
        contentValues.put(Email,User.Email)
        db.insert(Table_User,null,contentValues)
        Log.d("tagq","in")
    }

    fun GetAldata():List<ModelUser>{
        var query = "select * from ${Table_User}"
        var db = this.readableDatabase
        val UserList= mutableListOf<ModelUser>()

        var curosr = db.rawQuery(query, null)
        while (curosr.moveToNext()){
            val Name = curosr.getString(curosr.getColumnIndexOrThrow(Name))
            val LastName = curosr.getString(curosr.getColumnIndexOrThrow(LastName))
            val Password = curosr.getInt(curosr.getColumnIndexOrThrow(Password))
            val Ege = curosr.getInt(curosr.getColumnIndexOrThrow(Ege))
            val Email = curosr.getString(curosr.getColumnIndexOrThrow(Email))

            val user=ModelUser(Name,LastName,Email, Password, Ege)

            UserList.add(user)
        }
        Log.d("tagw", "${UserList}")

        return UserList
    }
}