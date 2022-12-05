package com.tests.lifehackstudiotest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tests.lifehackstudiotest.R

const val BASE_URL = "https://lifehack.studio/test_task/"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}