package com.example.appclientes2.EventsFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appclientes2.MainActivity
import com.example.appclientes2.R


class EventsListFragment : Fragment() {

    lateinit var v : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_events_list, container, false)

        return v
    }

    override fun onStart() {
        super.onStart()
        (requireActivity()as MainActivity).changeToolbarName("Eventos")
    }
}