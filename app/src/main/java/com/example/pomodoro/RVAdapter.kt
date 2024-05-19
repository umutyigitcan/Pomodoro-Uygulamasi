package com.example.pomodoro

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
class RVAdapter(private var mContext:Context,private var gelenListe:ArrayList<GorevlerData>):RecyclerView.Adapter<RVAdapter.cardViewNesneleriniTutucu>() {
    inner class cardViewNesneleriniTutucu(view:View):RecyclerView.ViewHolder(view){
        var cardview:CardView
        var checkbox:CheckBox
        var gorevismi:TextView
        var delete:ImageView
        init{
            cardview=view.findViewById(R.id.cardView)
            checkbox=view.findViewById(R.id.checkbox)
            gorevismi=view.findViewById(R.id.gorevismi)
            delete=view.findViewById(R.id.delete)
        }
    }


    override fun onBindViewHolder(holder: cardViewNesneleriniTutucu, position: Int) {
        var tutucu = gelenListe[position]
        holder.gorevismi.text = tutucu.gorev
        holder.delete.setOnClickListener { nesne ->
            var ad = AlertDialog.Builder(mContext)
            ad.setMessage("Silmek istediğinize emin misiniz?")
            ad.setPositiveButton("Sil") { dialogInterface, i ->
                val vt = gorevVeriTabaniYardimcisi(mContext)
                gorevVeriTabaniDao().gorevSil(vt, tutucu.gorevid)
                // Veriyi listeden kaldır gelenListe.removeAt(position)
                // Listenin güncellenmiş halini oluştur
                val newPosition = gelenListe.indexOf(tutucu)
                gelenListe.removeAt(newPosition)
                // RecyclerView'e bu değişikliği bildir
                notifyItemRemoved(newPosition)
                Snackbar.make(nesne, "Görev başarıyla silindi!", Snackbar.LENGTH_SHORT).show()
            }
            ad.setNegativeButton("İptal") { dialogInterface, i ->
            }
            ad.create().show()
        }
    }


    override fun getItemCount(): Int {
        return gelenListe.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardViewNesneleriniTutucu {
        var tasarim=LayoutInflater.from(mContext).inflate(R.layout.thingstodocardview,parent,false)
        return cardViewNesneleriniTutucu(tasarim)
    }
}