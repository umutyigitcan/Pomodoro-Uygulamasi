package com.example.pomodoro

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.example.pomodoro.databinding.FragmentPomodoroEkraniBinding


class PomodoroEkrani : Fragment() {


    private lateinit var tasarim:FragmentPomodoroEkraniBinding
    var zamanidurdur:Long=0
    var sayi=-1
    var molasaniye=0
    var toplamsaniye=0

    private var handler=Handler(Looper.getMainLooper())
    private var dersDurum=true
    private var myHandler=Handler(Looper.getMainLooper())
    private var myRunnable=object :Runnable{
        override fun run() {
            if(sayi==toplamsaniye&&dersDurum==true){
                handler.removeCallbacks(runnable)
                tasarim.kronometre.stop()
                zamanidurdur=0
                sayi=-1
                tasarim.constraintlayout.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.blue))
                tasarim.constraintLayout2.setBackgroundColor(ContextCompat.getColor(requireContext() ,R.color.blue2))
                tasarim.kronometre.base=SystemClock.elapsedRealtime()
                tasarim.kronometre.start()
                handler.post(runnable)
                dersDurum=false
            }
            if(sayi==toplamsaniye&&dersDurum==false){
                handler.removeCallbacks(runnable)
                tasarim.kronometre.stop()
                zamanidurdur=0
                sayi=-1
                tasarim.constraintlayout.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.arkaplankırmızı))
                tasarim.constraintLayout2.setBackgroundColor(ContextCompat.getColor(requireContext() ,R.color.onkirmizi))
                tasarim.kronometre.base=SystemClock.elapsedRealtime()
                tasarim.kronometre.start()
                dersDurum=true
                handler.post(runnable)
            }
            myHandler.postDelayed(this,100)
        }
    }
    private var runnable=object :Runnable{
        override fun run() {
            sayi++
            tasarim.sayidegeri.text=sayi.toString()
            var vt=VeriTabaniYardimcisi(requireContext())
            var gelendata=VeriTabaniDao().ayargetir(vt)
            for(k in gelendata){
                toplamsaniye=(k.pomodorosuresi)*60
                molasaniye=(k.molasuresi)*60
            }
            handler.postDelayed(this,1000)
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim= FragmentPomodoroEkraniBinding.inflate(inflater,container,false)
        myHandler.post(myRunnable)
        tasarim.baslat.setOnClickListener {
            tasarim.baslat.visibility=View.INVISIBLE
            tasarim.durdur.visibility=View.VISIBLE
            tasarim.kronometre.base=SystemClock.elapsedRealtime()+zamanidurdur
            tasarim.kronometre.start()
            handler.post(runnable)
        }
        tasarim.ayarlar.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_pomodoroEkrani_to_pomodoroSureAyarlamaEkrani)
        }

        tasarim.durdur.setOnClickListener {
            tasarim.baslat.visibility=View.VISIBLE
            tasarim.durdur.visibility=View.INVISIBLE
            zamanidurdur=tasarim.kronometre.base-SystemClock.elapsedRealtime()
            tasarim.kronometre.stop()
            sayi--
            handler.removeCallbacks(runnable)
        }

        return tasarim.root
    }


}