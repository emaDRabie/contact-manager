package com.omdacode.contactmanager.one

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.omdacode.contactmanager.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
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

        val backBtn: Button = findViewById(R.id.back_btn)
        val shareBtn: FloatingActionButton = findViewById(R.id.share_fab)

        val intent = Intent(this, MainActivity::class.java)

        backBtn.setOnClickListener {
            startActivity(intent)
            finish()
        }

        shareBtn.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.setType("text/plain")
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out my app ⇱")
            // createChooser() to display the available apps for share
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }



        Log.d("lifeCycle", "▶ SecondActivity • onCreate() called")
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifeCycle", "▶ SecondActivity • onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifeCycle", "▶ SecondActivity • onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifeCycle", "▶ SecondActivity • onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifeCycle", "▶ SecondActivity • onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifeCycle", "▶ SecondActivity • onDestroy() called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("lifeCycle", "▶ SecondActivity • onRestart() called")
    }
}