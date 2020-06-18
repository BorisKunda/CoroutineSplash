package com.boriskunda.coroutinesplash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityScope.launch {

            delay(3000)

            Intent(this@MainActivity, MainActivity2::class.java).let {
                startActivity(it)
                finish()
            }

        }

    }

    override fun onPause() {
        activityScope.cancel()
        super.onPause()
    }

}