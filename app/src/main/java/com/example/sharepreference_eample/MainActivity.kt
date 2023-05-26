package com.example.sharepreference_eample

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var nametextview:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val save:Button=findViewById(R.id.savebtn)
        val enteredname:EditText=findViewById(R.id.namefield)
        nametextview=findViewById(R.id.textview)

        displayedsavedname()
        save.setOnClickListener(){

            val edittext:String=enteredname.text.toString()
            sharedpreference(edittext)
            Toast.makeText(applicationContext, "saved $edittext", Toast.LENGTH_SHORT).show()

        }
        displayedsavedname()

    }

    private fun sharedpreference(name: String) {

        val sharedpreference: SharedPreferences = getSharedPreferences("name", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedpreference.edit()
        editor.putString("name", name)
        editor.commit()
    }

        fun displayedsavedname() {
            val sharepreference: SharedPreferences = getSharedPreferences("name", MODE_PRIVATE)
            val saved: String? = sharepreference.getString("name", "")
            nametextview.setText(saved)

        }
    }
