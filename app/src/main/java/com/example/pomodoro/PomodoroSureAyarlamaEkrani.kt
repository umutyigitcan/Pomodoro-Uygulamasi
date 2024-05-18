package com.example.pomodoro

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.pomodoro.databinding.FragmentPomodoroSureAyarlamaEkraniBinding
import com.google.android.material.snackbar.Snackbar

class PomodoroSureAyarlamaEkrani : Fragment() {


    private lateinit var tasarim:FragmentPomodoroSureAyarlamaEkraniBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim= FragmentPomodoroSureAyarlamaEkraniBinding.inflate(inflater,container,false)
        Toast.makeText(requireContext(),"Süreleri dakika cinsinden giriniz!",Toast.LENGTH_SHORT).show()


        tasarim.anasayfadonus.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_pomodoroSureAyarlamaEkrani_to_pomodoroEkrani)


        }


        var vt=VeriTabaniYardimcisi(requireContext())


        tasarim.tamam.setOnClickListener {nesne->
            var pomodorosuresi=tasarim.pomodoro.text.toString().toInt()
            var molasuresi=tasarim.mola.text.toString().toInt()
            var molatekrari=tasarim.molatekrari.text.toString().toInt()
            VeriTabaniDao().ayardegistir(vt,pomodorosuresi,molasuresi,molatekrari)
            Log.e("a",pomodorosuresi.toString())
            Log.e("b",molasuresi.toString())
            Log.e("c",molatekrari.toString())
            Snackbar.make(nesne,"Pomodoro Oluşturuldu...",Snackbar.LENGTH_SHORT).show()
            Navigation.findNavController(nesne).navigate(R.id.action_pomodoroSureAyarlamaEkrani_to_pomodoroEkrani)
        }


















        return tasarim.root
    }
}