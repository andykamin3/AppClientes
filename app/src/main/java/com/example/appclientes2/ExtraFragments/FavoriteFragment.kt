package com.example.appclientes2.ExtraFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appclientes2.Entities.Routine
import com.example.appclientes2.MainActivity
import com.example.appclientes2.R

class FavoriteFragment : Fragment() {

    lateinit var v : View
    lateinit var recFavorites : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_favorite, container, false)

        return v
    }

    override fun onStart() {
        super.onStart()
        (requireActivity()as MainActivity).changeToolbarName("Favoritos")
    }
}