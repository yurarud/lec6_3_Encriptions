package com.example.lec6_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController


class WelcomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)
        val startButton = view.findViewById<Button>(R.id.start)
        startButton.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_welcomeFragment_to_messageFragment)
        }

        val result = WelcomeFragmentArgs.fromBundle(requireArguments()).result
        val resultTxt = view.findViewById<TextView>(R.id.textMassege)
        /*if (result!=" "){
            val enc = Encriptions()
            resultTxt.text=enc.decryptWithAES(result)
        }*/
        resultTxt.text=result

        return view
    }


}