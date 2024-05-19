package com.example.pomodoro

class gorevVeriTabaniDao {
    fun gorevEkle(vt2:gorevVeriTabaniYardimcisi,gorevAdi:String){
        var db=vt2.writableDatabase
        db.execSQL("INSERT INTO gorevler(gorevAdi) VALUES('$gorevAdi')")
        db.close()
    }

    fun gorevListele(vt2: gorevVeriTabaniYardimcisi):ArrayList<gorevVeriTabani>{
        var db=vt2.writableDatabase
        var gorevler=ArrayList<gorevVeriTabani>()
        var cursor=db.rawQuery("SELECT * FROM gorevler",null)
        while (cursor.moveToNext()){
            var goreveklenen=gorevVeriTabani(cursor.getInt(cursor.getColumnIndexOrThrow("gorevId")),
                cursor.getString(cursor.getColumnIndexOrThrow("gorevAdi")))
            gorevler.add(goreveklenen)
        }
        return gorevler
    }
    fun gorevSil(vt2: gorevVeriTabaniYardimcisi,gorevId: Int){
        var db=vt2.writableDatabase
        db.execSQL("DELETE FROM gorevler WHERE gorevID=$gorevId")
        db.close()
    }
}