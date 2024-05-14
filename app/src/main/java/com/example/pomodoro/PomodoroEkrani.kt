package com.example.pomodoro

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.pomodoro.databinding.FragmentPomodoroEkraniBinding


class PomodoroEkrani : Fragment() {


    private lateinit var tasarim:FragmentPomodoroEkraniBinding
    private var myHandler=Handler()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim= FragmentPomodoroEkraniBinding.inflate(inflater,container,false)
        tasarim.ayarlar.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_pomodoroEkrani_to_pomodoroSureAyarlamaEkrani)
        }


        tasarim.baslatdurdur.setOnClickListener {
            myHandler.post(runnable)
        }



        return tasarim.root
    }

    private var runnable=object:Runnable{
        override fun run() {



            myHandler.postDelayed(this,1000)
        }
    }

}