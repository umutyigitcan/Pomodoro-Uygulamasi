package com.example.pomodoro

class VeriTabaniDao {
    fun ayardegistir(vt:VeriTabaniYardimcisi,pomodorosuresi:Int,molasayisi:Int,molasuresi:Int){
        var db=vt.writableDatabase
        db.execSQL("UPDATE ayarlar SET pomodorosuresi=$pomodorosuresi")
        db.execSQL("UPDATE ayarlar SET molasayisi=$molasayisi")
        db.execSQL("UPDATE ayarlar SET molasuresi=$molasuresi")
        db.close()
    }
    fun ayargetir(vt:VeriTabaniYardimcisi):ArrayList<VeriTabani>{
        var db=vt.writableDatabase
        var ayarlar=ArrayList<VeriTabani>()
        var cursor=db.rawQuery("SELECT * FROM ayarlar",null)
        while (cursor.moveToNext()){
            var ayar=VeriTabani(cursor.getInt(cursor.getColumnIndexOrThrow("pomodorosuresi")),
                cursor.getInt(cursor.getColumnIndexOrThrow("molasayisi")),
                cursor.getInt(cursor.getColumnIndexOrThrow("molasuresi")))
            ayarlar.add(ayar)
        }
        return ayarlar
    }
}