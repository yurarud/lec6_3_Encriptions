package com.example.lec6_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

class EncryptFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_encrypt, container, false)
        val message = EncryptFragmentArgs.fromBundle(requireArguments()).message
        val encryptedView = view.findViewById<TextView>(R.id.encrypted_message)
        val enc=Encriptions()
        encryptedView.text = enc.encrypt(message)

        val toMainButton = view.findViewById<Button>(R.id.button)
        toMainButton.setOnClickListener {
            val action = EncryptFragmentDirections
                .actionEncryptFragmentToWelcomeFragment(encryptedView.text.toString())
            view.findNavController().navigate(action)
        }

        return view
    }
}