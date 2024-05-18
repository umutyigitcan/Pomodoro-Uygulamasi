package com.example.pomodoro

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.pomodoro.databinding.FragmentGorevlerEkraniBinding
import com.google.android.material.snackbar.Snackbar

class GorevlerEkrani : Fragment() {


    private lateinit var tasarim:FragmentGorevlerEkraniBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim= FragmentGorevlerEkraniBinding.inflate(inflater,container,false)

        tasarim.gorevekle.setOnClickListener {nesne->
            val tasarim=layoutInflater.inflate(R.layout.alert_tasarim,null)
            val edittext=tasarim.findViewById(R.id.edittext) as EditText
            var ad=AlertDialog.Builder(requireContext())
            ad.setView(tasarim)
            ad.setTitle("Görev Ekle")
            //ad.setMessage("Görev ekleyiniz!")
            ad.setIcon(R.drawable.pomodoroimg)
            ad.setPositiveButton("EKLE"){dialogInterface, i->
                val alinantext=edittext.text.toString()
                Toast.makeText(requireContext(),"$alinantext",Toast.LENGTH_SHORT).show()
                Snackbar.make(nesne,"Görev başarıyla eklendi!",Snackbar.LENGTH_SHORT).show()
            }
            ad.setNegativeButton("İptal"){dialogInterface, i->
                Toast.makeText(requireContext(),"İptal Tıklandı!",Toast.LENGTH_SHORT).show()
            }
            ad.create().show()

        }

        tasarim.anasayfadonus.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_gorevlerEkrani_to_pomodoroEkrani)
        }
        return tasarim.root
    }
}