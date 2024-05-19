package com.example.pomodoro

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pomodoro.databinding.FragmentGorevlerEkraniBinding
import com.google.android.material.snackbar.Snackbar

class GorevlerEkrani : Fragment() {


    private lateinit var tasarim:FragmentGorevlerEkraniBinding
    private lateinit var gorevList:ArrayList<GorevlerData>
    private lateinit var adapter:RVAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim= FragmentGorevlerEkraniBinding.inflate(inflater,container,false)
        var vt2=gorevVeriTabaniYardimcisi(requireContext())
        gorevList= ArrayList()
        tasarim.rv.setHasFixedSize(true)
        tasarim.rv.layoutManager=StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)

        val datagetir=gorevVeriTabaniDao().gorevListele(vt2)
        for(k in datagetir){
            gorevList.add(GorevlerData(k.gorevAdi,k.gorevId))
        }



       tasarim.gorevekle.setOnClickListener {nesne->
            val tasarim=layoutInflater.inflate(R.layout.alert_tasarim,null)
            val edittext=tasarim.findViewById(R.id.edittext) as EditText
            val ad=AlertDialog.Builder(requireContext())
            ad.setView(tasarim)
            ad.setTitle("Görev Ekle")
            //ad.setMessage("Görev ekleyiniz!")
            ad.setIcon(R.drawable.pomodoroimg)
            ad.setPositiveButton("EKLE"){dialogInterface, i->
                val alinantext=edittext.text.toString()
                if(alinantext.length>0){
                    gorevList.clear()
                    gorevVeriTabaniDao().gorevEkle(vt2,alinantext)
                    val datagetir2=gorevVeriTabaniDao().gorevListele(vt2)
                    for(k in datagetir2){
                        gorevList.add(GorevlerData(k.gorevAdi,k.gorevId))
                    }
                    Snackbar.make(nesne,"Görev başarıyla eklendi!",Snackbar.LENGTH_SHORT).show()

                }else{
                 Snackbar.make(nesne,"Görev ismi uzunluğu sıfır olmamalı!",Snackbar.LENGTH_SHORT).show()
                    var listele=gorevVeriTabaniDao().gorevListele(vt2)
                    for(k in listele){
                        Log.e("Görev İd: ",k.gorevId.toString())
                        Log.e("Göred Adı: ",k.gorevAdi)
                    }
                }
            }
            ad.setNegativeButton("İptal"){dialogInterface, i->
                
            }
            ad.create().show()
           adapter.notifyDataSetChanged()
        }

        tasarim.anasayfadonus.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_gorevlerEkrani_to_pomodoroEkrani)
        }
        adapter=RVAdapter(requireContext(),gorevList)
        tasarim.rv.adapter=adapter
        return tasarim.root
    }
}