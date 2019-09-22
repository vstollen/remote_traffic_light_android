package io.vstollen.trafficlightcontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.net.Socket

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_green.setOnClickListener {
            Log.d("MainActivity","Green")

            Thread {
                val client = Socket("raspberrypi.lan", 10000)
                client.outputStream.write("GREEN".toByteArray())
                client.close()
            }.start()
        }

        button_red.setOnClickListener {
            Log.d("MainActivity", "Red")

            Thread {
                val client = Socket("raspberrypi.lan", 10000)
                client.outputStream.write("RED".toByteArray())
                client.close()
            }.start()
        }
    }
}
