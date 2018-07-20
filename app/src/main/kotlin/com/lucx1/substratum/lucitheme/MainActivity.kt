package com.lucx1.substratum.lucitheme

import android.content.ComponentName
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.open_substratum)
        btn1.setOnClickListener {
            val i = Intent()
            val n = ComponentName("projekt.substratum",
                    "projekt.substratum.LauncherActivity")
            i.component = n
            startActivity(i)
        }
        val btn2 = findViewById<ImageButton>(R.id.BtnShutdown)
        btn2.setOnClickListener {
            try {
                val proc = Runtime.getRuntime()
                        .exec(arrayOf("su", "-c", "reboot -p"))
                proc.waitFor()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
        val btn3 = findViewById<ImageButton>(R.id.BtnReboot)
        btn3.setOnClickListener {
            try {
                val proc = Runtime.getRuntime()
                        .exec(arrayOf("su", "-c", "reboot"))
                proc.waitFor()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
        val btn4 = findViewById<Button>(R.id.powerOptions)
        btn4.setOnClickListener {
            startActivity(Intent(this@MainActivity, PowerActivity::class.java))
        }
    }
}
