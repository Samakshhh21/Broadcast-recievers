package com.sampam.staticbroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val am=headset()
        val i=IntentFilter().apply {
            addAction(Intent.ACTION_HEADSET_PLUG)
        }
        registerReceiver(am,i)

    }
    inner class headset:BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            if (p1==null) return
            if (p1?.action == Intent.ACTION_HEADSET_PLUG) {
                Toast.makeText(this@MainActivity, "headset pluged", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this@MainActivity, "headset removed", Toast.LENGTH_SHORT).show()
            }
        }
    }

}