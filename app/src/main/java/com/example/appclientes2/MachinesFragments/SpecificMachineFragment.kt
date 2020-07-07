package com.example.appclientes2.MachinesFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.appclientes2.MainActivity
import com.example.appclientes2.R
import kotlinx.android.synthetic.main.fragment_specific_machine.*


class SpecificMachineFragment : Fragment() {

    lateinit var v : View
    lateinit var txt1 : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_specific_machine, container, false)
        txt1 = v.findViewById(R.id.txtSpecificMachine)
        return v
    }

    override fun onStart() {
        super.onStart()
        val strNameMachine = SpecificMachineFragmentArgs.fromBundle(requireArguments()).strNameMachine
        txt1.text = strNameMachine
        (requireActivity()as MainActivity).changeToolbarName(strNameMachine)
    }
}
