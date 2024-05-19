package com.example.pomodoro

import android.animation.ObjectAnimator
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pomodoro.databinding.FragmentIstatistikBinding

class IstatistikFragment : Fragment() {


    private lateinit var tasarim:FragmentIstatistikBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim= FragmentIstatistikBinding.inflate(inflater,container,false)
        tasarim.buton.setOnClickListener {


        }
        return tasarim.root
    }




}