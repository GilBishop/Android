package com.example.introduccionfragments

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


class SegundoFragment : Fragment(R.layout.fragment_segundo) {

    private var nombre: String? = ""
    private var edad: Int? = 0
    val args: SegundoFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nombre = args.nombre
        edad =args.edad



        /*
        Recibe los datos sin  Safe Args
        arguments?.let { bundle ->
            nombre = bundle.getString(miNombre)
            edad = bundle.getInt(miEdad)
        }*/
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.txtOutput)
        val boton = view.findViewById<Button>(R.id.btnEnviarDatos)
        boton.setOnClickListener {
            val result = "Resultado"
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))

            findNavController().navigate(Uri.parse("introduccionfragments://card"))//uso de Deep Link
        }
        text.text = "$nombre $edad"
    }

    /*companion object{
        const val miNombre = "nombre"
        const val miEdad = "edad"

        fun newInstance(nombre: String, edad: Int) = SegundoFragment().apply {
            arguments = bundleOf(miNombre to nombre, miEdad to edad)
        }
    }*/
}