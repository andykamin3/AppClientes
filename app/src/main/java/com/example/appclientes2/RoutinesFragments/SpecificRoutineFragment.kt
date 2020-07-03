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
import com.example.appclientes2.R
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_specific_routine.*

class SpecificRoutineFragment : Fragment() {

    lateinit var v : View
    lateinit var txt1 : TextView
    lateinit var specificRoutineIv : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_specific_routine, container, false)
        txt1 = v.findViewById(R.id.txtSpecificRoutine)
        specificRoutineIv = v.findViewById(R.id.specificRoutineImageView)
        return v
    }


    override fun onStart() {
        super.onStart()

        val strNameRoutine = SpecificRoutineFragmentArgs.fromBundle(requireArguments()).strNameRoutine
        val strImageUrlRoutine = SpecificRoutineFragmentArgs.fromBundle(requireArguments()).strImageUrlRoutine
        txt1.text = strNameRoutine
        GlideApp.with(requireContext())
            .load(strImageUrlRoutine)
            .into(specificRoutineIv)
    }
}