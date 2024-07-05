package com.example.crudadmin

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.crudadmin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
   lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainUpload.setOnClickListener {
            startActivity(Intent(this, UploadActivity::class.java))

        }
        binding.mainUpdate.setOnClickListener {
            startActivity(Intent(this, UpdateActivity::class.java))
        }
        binding.mainDelete.setOnClickListener{
            startActivity(Intent(this, DeleteActivity::class.java))
        }

    }
}