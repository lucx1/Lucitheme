package com.lucx1.substratum.lucitheme

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class PowerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_power)

        val btn1 = findViewById<ImageButton>(R.id.shutdown)
        btn1.setOnClickListener {
            try {
                val proc = Runtime.getRuntime()
                        .exec(arrayOf("su", "-c", "reboot -p"))
                proc.waitFor()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
        val btn2 = findViewById<ImageButton>(R.id.reboot)
        btn2.setOnClickListener {
            try {
                val proc = Runtime.getRuntime()
                        .exec(arrayOf("su", "-c", "reboot"))
                proc.waitFor()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
        val btn3 = findViewById<ImageButton>(R.id.soft_reboot)
        btn3.setOnClickListener {
            try {
                val proc = Runtime.getRuntime()
                        .exec(arrayOf("su", "-c", "setprop ctl.restart zygote"))
                proc.waitFor()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
        val btn4 = findViewById<ImageButton>(R.id.recovery)
        btn4.setOnClickListener {
            try {
                val proc = Runtime.getRuntime()
                        .exec(arrayOf("su", "-c", "reboot recovery"))
                proc.waitFor()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
        val btn5 = findViewById<ImageButton>(R.id.bootloader)
        btn5.setOnClickListener {
            try {
                val proc = Runtime.getRuntime()
                        .exec(arrayOf("su", "-c", "reboot bootloader"))
                proc.waitFor()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
        val btn6 = findViewById<ImageButton>(R.id.screen_off)
        btn6.setOnClickListener {
            try {
                val proc = Runtime.getRuntime()
                        .exec(arrayOf("su", "-c", "input keyevent KEYCODE_POWER"))
                proc.waitFor()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }
}
