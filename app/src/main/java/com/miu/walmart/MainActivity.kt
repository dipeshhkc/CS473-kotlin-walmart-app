package com.miu.walmart

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.miu.walmart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var userList = mutableListOf(User("user1","one","user1@gmail.com","password"),
        User("user2","two","user2@gmail.com","password"),
        User("user3","three","user3@gmail.com","password"),
        User("user4","four","user4@gmail.com","password"),
        User("user5","five","user5@gmail.com","password"))

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signInBtn.setOnClickListener{
            for(user in userList){
                if(user.userName==binding.email.text.toString() && user.password == binding.password.text.toString()){
                    val intent = Intent(this,Shopping::class.java)
                    intent.putExtra("username",binding.email.text.toString())
                    startActivity(intent)
                    return@setOnClickListener
                }
            }
            Toast.makeText(this,"Invalid User Credential",Toast.LENGTH_LONG).show()
        }

        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { res ->
            if(res.resultCode== Activity.RESULT_OK){
                var user = res.data?.getSerializableExtra("new_user") as? User
                if (user!=null) {
                    userList.add(user)
                }
            }
        }

        binding.registerBtn.setOnClickListener{
            val intent = Intent(this,Register::class.java)
            resultLauncher.launch(intent)
    }

        binding.forgotPasswordBtn.setOnClickListener{
            val user =  userList.find{it.userName==binding.email.text.toString()}
            if(user!=null){
                val intent = Intent(Intent.ACTION_SEND)
                intent.type ="text/plain"
                intent.putExtra(Intent.EXTRA_EMAIL,user.password)
                startActivity(Intent.createChooser(intent,"Send Email"))
            }else{
                Toast.makeText(this,"Email not found",Toast.LENGTH_LONG).show()
            }

        }


}}