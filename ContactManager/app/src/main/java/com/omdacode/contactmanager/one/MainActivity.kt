package com.omdacode.contactmanager.one

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.omdacode.contactmanager.R
import com.omdacode.contactmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val scale = resources.displayMetrics.density
            val desiredPx = (18 * scale + 0.5f).toInt()
            v.setPadding(
                systemBars.left + desiredPx,
                systemBars.top + desiredPx,
                systemBars.right + desiredPx,
                systemBars.bottom + desiredPx,
            )
            insets
        }

        val intent = Intent(this, SecondActivity::class.java)
        binding.welcomeBtn.setOnClickListener {
            startActivity(intent)
        }

        Log.d("lifeCycle", "▶ MainActivity • onCreate() called")
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifeCycle", "▶ MainActivity • onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifeCycle", "▶ MainActivity • onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifeCycle", "▶ MainActivity • onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifeCycle", "▶ MainActivity • onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifeCycle", "▶ MainActivity • onDestroy() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("lifeCycle", "▶ MainActivity • onRestart() called")
    }
}