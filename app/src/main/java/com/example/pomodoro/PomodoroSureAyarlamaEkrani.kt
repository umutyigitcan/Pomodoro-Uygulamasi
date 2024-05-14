package com.example.pomodoro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.pomodoro.databinding.FragmentPomodoroSureAyarlamaEkraniBinding

class PomodoroSureAyarlamaEkrani : Fragment() {


    private lateinit var tasarim:FragmentPomodoroSureAyarlamaEkraniBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim= FragmentPomodoroSureAyarlamaEkraniBinding.inflate(inflater,container,false)

        tasarim.anasayfadonus.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_pomodoroSureAyarlamaEkrani_to_pomodoroEkrani)
        }


        return tasarim.root
    }
}