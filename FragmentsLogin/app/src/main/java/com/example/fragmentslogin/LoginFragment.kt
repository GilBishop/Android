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
import com.example.fragmentslogin.databinding.FragmentLoginBinding


class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var mBinding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentLoginBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.apply {
            btnLogin.setOnClickListener {
                val email = edTextEmail.text.toString().trimIndent().trim()
                val pass = edTextPass.text.toString().trimIndent().trim()
                if(!isValidEmail(email)){
                    toast("Escribe un correo valido")
                }else if(email != "" && pass != ""){
                    if (pass.length >= 5){
                        //Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
                        val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment(email, pass)
                        findNavController().navigate(action)
                    }else{
                        toast("La contraseña debe tener minimo 5 digitos")
                    }
                }else{
                    toast("!Llene todos los datos!")
                }
            }
            btnRegistrer.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }
    }

    private fun toast(message: String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun isValidEmail(target: CharSequence?) = if (TextUtils.isEmpty(target)){
        false
    }else{
        Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}