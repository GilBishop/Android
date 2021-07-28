package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.example.login.databinding.ActivityRegistrerBinding


class RegistrerActivity : AppCompatActivity() {

    private lateinit var mBindingReg: ActivityRegistrerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBindingReg = ActivityRegistrerBinding.inflate(layoutInflater)
        setContentView(mBindingReg.root)

        mBindingReg.apply {
            title = "Register"
            btnRegisterReg.setOnClickListener {
                val email = edTextEmailReg.text.toString().trimIndent().trim()
                val pass = edTextPassReg.text.toString().trimIndent().trim()
                val confirmPass = edTextConfirmPass.text.toString().trimIndent().trim()

                if (!isValidEmail(email)) {
                    toast("Escribe un correo valido")
                }else if (email != "" && pass != "" && confirmPass != ""){
                    if (pass == confirmPass){
                        val intentRegistrer = Intent(this@RegistrerActivity, HomeActivity::class.java).apply {
                            putExtra("Correo", email)
                            putExtra("Contrasena", pass)
                        }
                        startActivity(intentRegistrer)
                    }else{
                        toast("!Las contraseñas NO coinciden!")
                    }
                }else{
                    toast("Llena Todos los Datos!")
                }
            }

            txtVLogin.setOnClickListener{
                val intent = Intent(this@RegistrerActivity, LoginActivity::class.java)
                startActivity(intent)
            }

        }
    }

    private fun toast(messege: String){
        Toast.makeText(this, messege, Toast.LENGTH_SHORT).show()
    }

    private fun isValidEmail(target: CharSequence?) = if (TextUtils.isEmpty(target)) {
        false
    } else {
        Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}