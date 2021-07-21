package com.gilbishopmyloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.gilbishopmyloginapp.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    /*Sin binfding
    lateinit var btnAceptar : Button
    lateinit var edtEmail: EditText
    */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        /*Sin binding
        btnAceptar = findViewById(R.id.btnAceptar)
        edtEmail  = findViewById(R.id.edTextCorreo)
        btnAceptar.setOnClickListener {r
            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
        }*/

        mBinding.apply {

            btnIniciarSesion.setOnClickListener {
                val correo = edTextCorreo.text.toString()
                val contra = edTextPassword.text.toString()

                if (correo != null && contra != null) {
                    val intent = Intent(this@LoginActivity, HomeActivity::class.java)      //Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }else
                    toast("Llena los campos")
            }

            btnRegistrar.setOnClickListener { }
        }



    }


    private fun toast(mensaje: String) {

        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}
