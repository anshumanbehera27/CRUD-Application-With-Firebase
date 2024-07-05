package com.example.crudadmin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.example.crudadmin.databinding.ActivityUpdateBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class UpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.updateButton.setOnClickListener {
            val referencePhone = binding.referencePhone.text.toString()
            val updateName = binding.updateName.text.toString()
            val updateOperator = binding.updateOperator.text.toString()
            val updateLocation = binding.updateLocation.text.toString()

            updateData(referencePhone, updateName, updateOperator, updateLocation)

        }
    }

        private fun updateData(referencePhone: String, updateName: String, updateOperator: String, updateLocation: String) {
            database = FirebaseDatabase.getInstance().getReference("Users")
            val user = mapOf<String, String>(
                "name" to updateName,
                "operator" to updateOperator,
                "location" to updateLocation
            )
            database.child(referencePhone).updateChildren(user).addOnSuccessListener {
                binding.referencePhone.text.clear()
                binding.updateName.text.clear()
                binding.updateOperator.text.clear()
                binding.updateLocation.text.clear()
                Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener{
                Toast.makeText(this,"Failed to Update",Toast.LENGTH_SHORT).show()
            }
        }


}