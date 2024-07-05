package com.example.crudadmin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crudadmin.databinding.ActivityDeleteBinding
import com.example.crudadmin.databinding.ActivityUpdateBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DeleteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDeleteBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.deleteButton.setOnClickListener {
            val deletePhone = binding.deletePhone.text.toString()
            if (deletePhone.isNotEmpty()) {

                deleteData(deletePhone)
            } else {
                Toast.makeText(this, "Please Enter Phone Number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun deleteData(deletePhone: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(deletePhone).removeValue().addOnSuccessListener {
            binding.deletePhone.text.clear()
            Toast.makeText(this, "Data Deleted", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }.addOnFailureListener{
            Toast.makeText(this,"Failed to Delete",Toast.LENGTH_SHORT).show()
        }

    }
}