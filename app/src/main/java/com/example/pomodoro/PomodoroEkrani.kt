package com.example.pomodoro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pomodoro.databinding.FragmentPomodoroEkraniBinding

class PomodoroEkrani : Fragment() {


    private lateinit var tasarim:FragmentPomodoroEkraniBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim= FragmentPomodoroEkraniBinding.inflate(inflater,container,false)


        return tasarim.root
    }
}