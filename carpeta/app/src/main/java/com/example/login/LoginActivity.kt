package com.example.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.login.databinding.LoginActivityBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var mBinding: LoginActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.apply {
            title = "Login"
            btnLogin.setOnClickListener {
                val email = edTextEmail.text.toString().trimIndent().trim()
                val pass = edTextPassword.text.toString().trimIndent().trim()
                if (!isValidEmail(email)) {
                    toast("Escribe un correo valido")
                } else if (email != "" && pass != "") {
                    val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                            .putExtra("Correo", email)
                            .putExtra("Contrasena", pass)
                    startActivity(intent)
                } else {
                    toast("Llena los campos!")
                }
            }
            btnRegistrer.setOnClickListener {
                val intent = Intent(this@LoginActivity, RegistrerActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun toast(messege: String) {
        Toast.makeText(this, messege, Toast.LENGTH_SHORT).show()
    }

    private fun isValidEmail(target: CharSequence?) = if (TextUtils.isEmpty(target)) {
        false
    } else {
        Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

}