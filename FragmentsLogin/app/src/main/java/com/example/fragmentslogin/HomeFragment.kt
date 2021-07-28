package com.example.fragmentslogin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AlertDialogLayout
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.fragmentslogin.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var mBinding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentHomeBinding.inflate(inflater)
        return mBinding.root
    }

    var email: String? = ""
    var pass: String? = ""
    val args: HomeFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        email = args.email
        pass = args.pass

        mBinding.apply {
            if(email!=null){
                edTextGetEmail.setText(email)
                edTextGetPass.setText(pass)
            }else{
                Toast.makeText(context, "Los Datos son vacios", Toast.LENGTH_SHORT).show()
            }
            btnLogOut.setOnClickListener {
                activity?.onBackPressed()
                //Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_loginFragment)
            }
        }
    }


}