package com.example.pomodoro

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeriTabaniYardimcisi(context:Context): SQLiteOpenHelper(context,"ayarlar",null,1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE ayarlar(pomodorosuresi INTEGER,molasayisi INTEGER,molasuresi INTEGER);")
        db.execSQL("INSERT INTO ayarlar(pomodorosuresi, molasayisi, molasuresi) VALUES(0,0,0);")

    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {

        db.execSQL("DROP TABLE IF EXISTS ayarlar")
        onCreate(db)
    }
}