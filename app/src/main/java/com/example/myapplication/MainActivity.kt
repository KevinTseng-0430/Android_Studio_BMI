package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)
        //ed_weight
        help.setOnClickListener{
            AlertDialog.Builder(this)
                    .setTitle("BMI")
                    .setMessage("體重(Kg)/身高的平方(m)")
                    .setPositiveButton("OK",null)
                    .show()
        }
    }
    fun bmi(view:View)
    {
        val weight = ed_weight.text.toString().toFloat()
        val height = ed_height.text.toString().toFloat()
        val bmi = weight/(height*height)
        Log.d("BMI",bmi.toString())
        Toast.makeText(this,bmi.toString(),Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
                .setMessage(bmi.toString())
                .setTitle("My BMI: ")
                .setPositiveButton("OK",null)
                .setNeutralButton("Cancel",null)
                .show()
    }
}