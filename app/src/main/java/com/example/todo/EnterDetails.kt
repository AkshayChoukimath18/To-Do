package com.example.todo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.todo.databinding.ActivityEnterDetailsBinding

class EnterDetails : AppCompatActivity() {

    private lateinit var binding: ActivityEnterDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_enter_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityEnterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            if (binding.edtTitle.text.toString().trim{it <= ' '}.isNotEmpty() && binding.edtPriority.text.toString().trim{it <= ' '}.isNotEmpty()){
                val title = binding.edtTitle.text.toString()
                val priority = binding.edtPriority.text.toString()
                DataObject.setData(title, priority)
                val intent = Intent(this, MainActivity::class.java)
                this.startActivity(intent)
            }else{
                Toast.makeText(this, "Please Enter Details", Toast.LENGTH_SHORT)
            }
        }
    }
}