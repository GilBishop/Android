package com.example.login

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.login.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var mBindingHome: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBindingHome = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(mBindingHome.root)

        val bundle = intent.extras
        val email = bundle?.getString("Correo")
        val pass = bundle?.getString("Contrasena")

        mBindingHome.apply {
            if (email != null) {
                edTextGetEmail.setText(email)
                edTextGetPass.setText(pass)
            } else {
                Toast.makeText(this@HomeActivity, "Los datos son vacios", Toast.LENGTH_SHORT).show()
            }
            title = "Home"
            btnSignOff.setOnClickListener {
                onBackPressed()
            }
        }
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Deseas salir de la aplicacion?")
        builder.setMessage("Mensaje")
        builder.setPositiveButton("Salir") { dialog, which ->
            super.onBackPressed()
        }
        builder.setNegativeButton("Mantener") { dialog, which ->
            Toast.makeText(this, "Sigues en la aplicacion", Toast.LENGTH_SHORT).show()
        }


        val dialog = builder.create()
        dialog.show()
        Log.e("hvhvjh", "jgjkgkjg")
    }
}