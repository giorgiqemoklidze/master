package com.example.davaleba5

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.davaleba5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

    }

    fun init(){
        var autofill = User("firstName", "lastName", "age", "email")
        val users = mutableListOf<User>()
        users.add(autofill)
        var firstName = binding.FirstName.toString()
        var lastName = binding.LastName.toString()
        var age = binding.Age.toString()
        var email = binding.Email.toString()



        binding.addUserButton.setOnClickListener {
            var i = 0
            var user: User = User(firstName, lastName, age, email)
            while (i != users.size) {
                if (users[i].email.toString() == email) {
                    binding.FirstName.setTextColor(Color.rgb(255, 0, 0))
                    binding.LastName.setTextColor(Color.rgb(255, 0, 0))
                    binding.Age.setTextColor(Color.rgb(255, 0, 0))
                    binding.Email.setTextColor(Color.rgb(255, 0, 0))
                    Toast.makeText(applicationContext, "ar daemata", Toast.LENGTH_SHORT).show()
                    i++
                } else {
                    users += user
                    binding.FirstName.setTextColor(Color.rgb(0, 255, 0))
                    binding.LastName.setTextColor(Color.rgb(0, 255, 0))
                    binding.Age.setTextColor(Color.rgb(0, 255, 0))
                    binding.Email.setTextColor(Color.rgb(0, 255, 0))
                    Toast.makeText(applicationContext, "daemata", Toast.LENGTH_SHORT).show()
                    break


                }
            }


        }


        binding.removeUSerButton.setOnClickListener {
            var i = 0
            while (i != users.size) {
                if (users[i].email.toString() == email) {
                    users.removeAt(i)
                    Toast.makeText(applicationContext, "waishala", Toast.LENGTH_SHORT).show()

                    break
                } else {
                    Toast.makeText(applicationContext, "waishala?", Toast.LENGTH_SHORT).show()
                    i++
                }
            }

        }

        binding.updateUserButton.setOnClickListener {
            var i = 0
            var user = User(firstName, lastName, age, email)
            while (i != users.size) {
                if (users[i].email.toString() == email) {
                    users.removeAt(i)
                    users.add(user)
                    Toast.makeText(applicationContext, "ganaxlda", Toast.LENGTH_SHORT).show()
                    break
                } else {
                    i++
                }
            }

        }

        binding.seeResult.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val lastindex = users.lastIndex
            var firstName1 = users[lastindex].firstName
            var lastName1 = users[lastindex].lastName
            var age1 = users[lastindex].age
            var email1 = users[lastindex].email
            intent.putExtra("firstName",firstName1)
            intent.putExtra("lastName",lastName1)
            intent.putExtra("age",age1)
            intent.putExtra("email",email1)
            startActivity(intent)

        }


    }
}