package com.example.introduccionkotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var texto:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Log.d("lifeCycle", "onCreate: ")

        texto = findViewById<TextView>(R.id.txtOutput)
        val boton = findViewById<Button>(R.id.btnAccion)

        boton.setOnClickListener {
            //texto.text = "Curso Android"
            navegarSegundaActivity()
        }

    }

    private  fun navegarSegundaActivity(){
        val intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("nombre", "Curso Android")
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                val nombre = data?.getStringExtra("nombre2")
                texto.text = nombre
            }
        }
    }
/*
    override fun onStart(){
        super.onStart()
        Log.d("lifeCycle", "onStart: ")
    }
    override fun onResume() {
        super.onResume()
        Log.d("lifeCycle", "onResume: ")
    }
    override fun onPause() {
        super.onPause()
        Log.d("lifeCycle", "onPause: ")
    }
    override fun onStop() {
        super.onStop()
        Log.d("lifeCycle", "onStop: ")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("lifeCycle", "onRestart: ")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifeCycle", "onDestroy: ")
    }
    */


}