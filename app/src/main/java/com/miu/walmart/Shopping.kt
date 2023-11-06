package com.miu.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.miu.walmart.databinding.ActivityMainBinding
import com.miu.walmart.databinding.ActivityShoppingBinding

class Shopping : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username =  intent.getStringExtra("username")
        binding.intro.text="Welcome, $username"

        binding.beautyView.setOnClickListener{
            Toast.makeText(this,"You clicked Beauty Category", Toast.LENGTH_SHORT).show()
        }

        binding.electronicView.setOnClickListener{
            Toast.makeText(this,"You clicked Electronic Category", Toast.LENGTH_SHORT).show()
        }

        binding.clothView.setOnClickListener{
            Toast.makeText(this,"You clicked Cloth Category", Toast.LENGTH_SHORT).show()
        }

        binding.foodView.setOnClickListener{
            Toast.makeText(this,"You clicked Food Category", Toast.LENGTH_SHORT).show()
        }
    }
}