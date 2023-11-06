package com.miu.walmart

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.miu.walmart.databinding.ActivityRegisterBinding
import com.miu.walmart.databinding.ActivityShoppingBinding

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener{
            val user = User(binding.firstname.text.toString(),binding.lastname.text.toString(),binding.email.text.toString(),binding.password.text.toString())

            Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()

            val userIntent = Intent()
            userIntent.putExtra("new_user",user)
            setResult(Activity.RESULT_OK, userIntent)
            finish()
        }


    }
}