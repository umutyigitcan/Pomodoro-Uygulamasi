package com.example.pomodoro

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class gorevVeriTabaniYardimcisi(mContext:Context):SQLiteOpenHelper(mContext,"gorevler",null,1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE gorevler(gorevId INTEGER PRIMARY KEY AUTOINCREMENT,gorevAdi TEXT);")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
     db.execSQL("DROP TABLE IF EXISTS gorevler")
        onCreate(db)
    }
}