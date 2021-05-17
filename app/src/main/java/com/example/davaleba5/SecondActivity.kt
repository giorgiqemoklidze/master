package com.example.davaleba5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.davaleba5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val firstName = intent.getStringExtra("firstName").toString()
        val lastName = intent.getStringExtra("lastName").toString()
        val age = intent.getStringExtra("age").toString()
        val email = intent.getStringExtra("email").toString()

        binding.FirstName1.text = firstName
        binding.LastName1.text = lastName
        binding.age.text = age
        binding.email1.text = email


    }
}