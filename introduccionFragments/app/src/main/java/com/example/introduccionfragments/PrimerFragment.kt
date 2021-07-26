package com.example.introduccionfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController


class PrimerFragment : Fragment(R.layout.fragment_primer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.btnNavegar)
        val resultado = view.findViewById<TextView>(R.id.txtOutput1)

        setFragmentResultListener("requestKey"){key, bundle->
            val result = bundle.getString("bundleKey")
            resultado.text =result
        }

        button.setOnClickListener {
            val action = PrimerFragmentDirections.actionPrimerFragmentToSegundoFragment("Gil", 25)
            findNavController().navigate(action)

            //como se pasaban datos sin SafeArgs
            //findNavController().navigate(R.id.action_primerFragment_to_segundoFragment, bundleOf( SegundoFragment.miNombre to "Gil", SegundoFragment.miEdad to 25))

            /*
            Ejemplo de ir al otro fragment enviando datos sin NavigationComponent
            requireActivity().supportFragmentManager.commit {
                replace(R.id.fragmentContainerView, SegundoFragment.newInstance("Gil", 26))
                addToBackStack("primerFragment")
            }
            * */

        }
    }

}