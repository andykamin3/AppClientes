package com.example.appclientes2.RoutinesFragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.appclientes2.GlideApp
import com.example.appclientes2.MainActivity
import com.example.appclientes2.R
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_specific_routine.*

class SpecificRoutineFragment : Fragment() {

    lateinit var v : View
    lateinit var txtNameSpecificRoutine : TextView
    lateinit var txtBodypartSpecificRoutine : TextView
    lateinit var txtIntensitySpecificRoutine : TextView
    lateinit var txtDurationSpecificRoutine : TextView
    lateinit var specificRoutineIv : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_specific_routine, container, false)
        txtNameSpecificRoutine = v.findViewById(R.id.txtSpecificRoutineName)
        txtBodypartSpecificRoutine = v.findViewById(R.id.txtSpecificRoutineBodypart)
        txtDurationSpecificRoutine = v.findViewById(R.id.txtSpecificRoutineDuration)
        txtIntensitySpecificRoutine = v.findViewById(R.id.txtSpecificRoutineIntensity)
        specificRoutineIv = v.findViewById(R.id.specificRoutineImageView)
        return v
    }

    override fun onStart() {
        super.onStart()

        val strSpecificRoutineName = SpecificRoutineFragmentArgs.fromBundle(requireArguments()).strNameRoutine
        val strSpecificRoutineImageUrl = SpecificRoutineFragmentArgs.fromBundle(requireArguments()).strImageUrlRoutine
        val strSpecificRoutineIntensity = SpecificRoutineFragmentArgs.fromBundle(requireArguments()).strIntensityRoutine
        val strSpecificRoutineBodypart = SpecificRoutineFragmentArgs.fromBundle(requireArguments()).strBodypartRoutine
        val IntSpecificRoutineDuration = SpecificRoutineFragmentArgs.fromBundle(requireArguments()).intDurationRoutine

        txtNameSpecificRoutine.text = strSpecificRoutineName

        GlideApp.with(requireContext())
            .load(strSpecificRoutineImageUrl)
            .into(specificRoutineIv)

        txtIntensitySpecificRoutine.text = strSpecificRoutineIntensity

        txtBodypartSpecificRoutine.text = strSpecificRoutineBodypart

        txtDurationSpecificRoutine.text = IntSpecificRoutineDuration.toString()

        (requireActivity()as MainActivity).changeToolbarName(strSpecificRoutineName)
    }
}