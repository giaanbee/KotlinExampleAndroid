package com.collagemedia.kotlinexample.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.collagemedia.kotlinexample.App
import com.collagemedia.kotlinexample.model.StudentModel
import org.jetbrains.anko.db.*

/*
 * Created by Gia An Bee on 6/6/2017.
 */
class DataOpenHelper(ctx: Context = App.instance()) : ManagedSQLiteOpenHelper(ctx, DB_NAME, null, DB_VERSION) {


    public val TABLE_NAME = "DATA_TEST"
    public val ID = "id"
    public val NAME = "name"
    public val BIRTHDAY = "birthday"
    public val IMAGE = "image"

    companion object {
        val DB_NAME = "data.db"
        val DB_VERSION = 1
        private var instance: DataOpenHelper? = null

        fun getInstance(ctx: Context): DataOpenHelper {
            if (instance == null) {
                instance = DataOpenHelper(ctx.applicationContext)
            }
            return instance!!
        }
    }


    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(
                TABLE_NAME,
                true,
                ID to INTEGER + PRIMARY_KEY,
                NAME to TEXT,
                BIRTHDAY to TEXT,
                IMAGE to INTEGER
        )
    }

    fun addData(data: StudentModel) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(ID, data.id)
        values.put(NAME, data.name)
        values.put(BIRTHDAY, data.birthday)
        values.put(IMAGE, data.image)
        db.insert(TABLE_NAME, null, values)
    }

    fun getData(id: Int): StudentModel {
        val db = this.readableDatabase
        val cursor = db.query(TABLE_NAME,
                arrayOf<String>(ID, NAME, BIRTHDAY, IMAGE), ID + "=?",
                arrayOf(id.toString()), null, null, null, null)

        cursor.moveToFirst()

        val contact = StudentModel(Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(3)),
                cursor.getString(1), cursor.getString(2))

        cursor.close()
        return contact
    }

    fun getCount(): Int {
        val countQuery = "SELECT  * FROM " + TABLE_NAME
        val db = this.readableDatabase
        val cursor = db.rawQuery(countQuery, null)
        val count = cursor.count
        cursor.close()
        return count
    }

    fun getAllData(): ArrayList<StudentModel> {
        val contactList = ArrayList<StudentModel>()
        val selectQuery = "SELECT  * FROM " + TABLE_NAME
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val contact = StudentModel()
                contact.id = Integer.parseInt(cursor.getString(0))
                contact.name = cursor.getString(1)
                contact.birthday = cursor.getString(2)
                contact.image = Integer.parseInt(cursor.getString(3))
                // Adding contact to list
                contactList.add(contact)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return contactList
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(TABLE_NAME, true)
        onCreate(db)
    }


    val Context.database: DataOpenHelper
        get() = DataOpenHelper.getInstance(getApplicationContext())

}