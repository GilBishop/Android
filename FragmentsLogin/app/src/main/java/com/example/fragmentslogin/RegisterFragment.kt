package com.example.fragmentslogin

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.fragmentslogin.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(R.layout.fragment_register) {
    private lateinit var mBinding: FragmentRegisterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentRegisterBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.apply {
            btnRegisterReg.setOnClickListener {
                val email = edTextEmailReg.text.toString().trimIndent().trim()
                val pass = edTextPassReg.text.toString().trimIndent().trim()
                val confirmPass = edTextConfirmPass.text.toString().trimIndent().trim()
                if(!isValidEmail(email)){
                    toast("Escribe un correo valido")
                }else if(email != "" && pass != "" && confirmPass != ""){
                    if (pass.length >= 5 && confirmPass.length >= 5){
                        if(pass == confirmPass){
                            val action = RegisterFragmentDirections.actionRegisterFragmentToHomeFragment(email, pass)
                            findNavController().navigate(action)
                        }else{
                            toast("¡La Contraseña no coincide!")
                        }
                    }else{
                        toast("La contraseña debe tener minimo 5 digitos")
                    }
                }else{
                    toast("¡Llena todos los campos!")
                }
            }
            txtVLogin.setOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

    private fun toast(messege: String){
        Toast.makeText(context, messege, Toast.LENGTH_SHORT).show()
    }

    private fun isValidEmail(target: CharSequence?) = if (TextUtils.isEmpty(target)) {
        false
    } else {
        Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}