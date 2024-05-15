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

class PomodoroSureAyarlamaEkrani : Fragment() {


    private lateinit var tasarim:FragmentPomodoroSureAyarlamaEkraniBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim= FragmentPomodoroSureAyarlamaEkraniBinding.inflate(inflater,container,false)

        tasarim.anasayfadonus.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_pomodoroSureAyarlamaEkrani_to_pomodoroEkrani)
        }

        var vt=VeriTabaniYardimcisi(requireContext())


        tasarim.tamam.setOnClickListener {
            var pomodorosuresi=tasarim.pomodoro.text.toString().toInt()
            var molasuresi=tasarim.mola.text.toString().toInt()
            var molatekrari=tasarim.molatekrari.text.toString().toInt()
            VeriTabaniDao().ayardegistir(vt,pomodorosuresi,molasuresi,molatekrari)
            Log.e("a",pomodorosuresi.toString())
            Log.e("b",molasuresi.toString())
            Log.e("c",molatekrari.toString())

            Toast.makeText(requireContext(),"Pomodoro ayarlandı...",Toast.LENGTH_SHORT).show()
        }


















        return tasarim.root
    }
}