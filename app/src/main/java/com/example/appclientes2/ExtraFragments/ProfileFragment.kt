package com.example.appclientes2.ExtraFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.appclientes2.Entities.Routine
import com.example.appclientes2.Entities.User
import com.example.appclientes2.GlideApp
import com.example.appclientes2.MainActivity
import com.example.appclientes2.R
import com.google.firebase.firestore.FirebaseFirestore

class ProfileFragment : Fragment() {

    lateinit var v : View
    lateinit var ProfilseUserIv : ImageView
    lateinit var txtName : TextView
    lateinit var txtBirthdate : TextView
    lateinit var txtWeight : TextView
    lateinit var txtHeight : TextView
    lateinit var txtObjective : TextView
    lateinit var btnSignOff : Button
    lateinit var btnChangeProfileData : Button

    lateinit var user : User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_profile, container, false)
        ProfilseUserIv = v.findViewById(R.id.imageViewUser)
        txtName = v.findViewById(R.id.textViewNameUser)
        txtBirthdate = v.findViewById(R.id.textViewBirthdate)
        txtWeight = v.findViewById(R.id.textViewWeight)
        txtHeight = v.findViewById(R.id.textViewHeight)
        txtObjective = v.findViewById(R.id.textViewObjective)


        user = User("Alejandro Magno", "28/02/97",100.42,194,"Disminuir grasa corporal","https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/User1.jpg?alt=media&token=153b6f2f-d74e-4afb-b7ef-1c0319f3b996","Buenos Aires")

        return v
    }

    override fun onStart() {
        super.onStart()
        (requireActivity()as MainActivity).changeToolbarName("Perfil")

        txtName.text =  user.name
        txtBirthdate.text = requireContext().getString(R.string.textviewBirthdate,user.birthDate)
        txtWeight.text = requireContext().getString(R.string.textviewWeight,user.weight.toString())
        txtHeight.text = requireContext().getString(R.string.textviewHeight,user.height.toString())
        txtObjective.text = requireContext().getString(R.string.textviewObjective,user.localidad)
        GlideApp.with(requireContext())
            .load(user.image)
            .circleCrop()
            .into(ProfilseUserIv)

        /*btnChangeProfileData.setOnClickListener{

        }

        btnSignOff.setOnClickListener{

        }*/
    }
}