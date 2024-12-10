package com.example.shemoqmedeba

import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.shemoqmedeba.databinding.ActivityMainBinding
data class Users(val name: String ,val lastname : String , val email : String)
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var listOfUsers = mutableListOf<Users>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonSend.setOnClickListener {
            val name = binding.nameET.text.toString()
            val lastname = binding.lastnameET.text.toString()
            val email = binding.emailET.text.toString()
            if(nameFun(name) && lastnameFun(lastname) && emailFun(email)){
                listOfUsers.add(Users(name,lastname,email))
                Toast.makeText(this,"Added succesfully!",Toast.LENGTH_LONG).show()
            }

        }



    }
    fun nameFun(name :String) : Boolean {
        return if (name.length < 10 || name.isEmpty()){
            Toast.makeText(this,"name should be contain at least 10 char",Toast.LENGTH_LONG).show()
            false
        }else{
            true
        }

    }
    fun lastnameFun(lastname: String): Boolean {
        return if (lastname.length < 12 || lastname.isEmpty()){
            Toast.makeText(this,"lastname should be contain at least 12 char",Toast.LENGTH_LONG).show()
            false
        }else{
            true
        }

    }
    fun emailFun(email: String) : Boolean{
        return if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() || email.isEmpty()){
            Toast.makeText(this,"Wrond email address",Toast.LENGTH_LONG).show()
            false
        }else{
            true
        }
    }
}