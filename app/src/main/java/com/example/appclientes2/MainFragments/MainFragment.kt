package com.example.appclientes2.MainFragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide.with
import com.example.appclientes2.GlideApp
import com.example.appclientes2.MyGlideModuleApp

import com.example.appclientes2.R
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    lateinit var v : View
    val storage = FirebaseStorage.getInstance()
    val gsReference = storage.getReferenceFromUrl("gs://appclientes-b9820.appspot.com/routine_mainfragment_photo.jpg")
    lateinit var imageView : ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_main, container, false)
        imageView = v.findViewById(R.id.imageview)

        return v
    }

    override fun onStart() {
        super.onStart()

        GlideApp.with(requireActivity() as Context)
            .load(gsReference)
            .into(imageview)
    }
}
