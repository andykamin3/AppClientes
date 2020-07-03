package com.example.appclientes2.MainFragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.navigation.findNavController
import com.bumptech.glide.Glide.with
import com.example.appclientes2.GlideApp
import com.example.appclientes2.MyGlideModuleApp

import com.example.appclientes2.R
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    lateinit var v: View
    lateinit var RoutinesImageButton: ImageButton
    lateinit var MachinesImageButton: ImageButton
    lateinit var EventsImageButton: ImageButton


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_main, container, false)
        RoutinesImageButton = v.findViewById(R.id.imageButtonRoutines)
        MachinesImageButton = v.findViewById(R.id.imageButtonMachines)
        EventsImageButton = v.findViewById(R.id.imageButtonEvents)

        return v
    }

    override fun onStart() {
        super.onStart()

        GlideApp.with(requireActivity() as Context)
            .load("https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/routine_mainfragment_photo.jpg?alt=media&token=fff3a62a-ca3a-4b3d-9650-d4d035fc65e2")
            .into(RoutinesImageButton)

        GlideApp.with(requireActivity() as Context)
            .load("https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/MachinesPhoto.jpg?alt=media&token=ee265b50-b505-408c-b19f-d5c7d35ca828")
            .into(MachinesImageButton)

        GlideApp.with(requireActivity() as Context)
            .load("https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/EventsPhoto.jpg?alt=media&token=70bae0a4-c594-4940-b625-dadc1d1efb34")
            .into(EventsImageButton)

        RoutinesImageButton.setOnClickListener {
            val action1to2 = MainFragmentDirections.actionMainFragmentToDestinationRoutines()
            v.findNavController().navigate(action1to2)
        }
        MachinesImageButton.setOnClickListener {
            val action1to3 = MainFragmentDirections.actionMainFragmentToDestinationMachines()
            v.findNavController().navigate(action1to3)
        }
        EventsImageButton.setOnClickListener {
            val action1to4 = MainFragmentDirections.actionMainFragmentToDestinationEvents()
            v.findNavController().navigate(action1to4)
        }
    }
}
