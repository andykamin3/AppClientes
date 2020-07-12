package com.example.appclientes2.RoutinesFragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appclientes2.Adapters.ExercisesListAdapter
import com.example.appclientes2.Adapters.RoutinesListAdapter
import com.example.appclientes2.Entities.Exercise
import com.example.appclientes2.GlideApp
import com.example.appclientes2.MainActivity
import com.example.appclientes2.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_specific_routine.*

class SpecificRoutineFragment : Fragment() {

    lateinit var v : View
    lateinit var txtBodypartSpecificRoutine : TextView
    lateinit var txtLevelSpecificRoutine : TextView
    lateinit var txtDurationSpecificRoutine : TextView
    lateinit var specificRoutineIv : ImageView

    lateinit var recExercises : RecyclerView

    var exercise: MutableList<Exercise> = ArrayList<Exercise>()

    lateinit var exerciseListAdapter : ExercisesListAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_specific_routine, container, false)
       txtBodypartSpecificRoutine = v.findViewById(R.id.txtSpecificRoutineBodypart)
        txtDurationSpecificRoutine = v.findViewById(R.id.txtSpecificRoutineDuration)
        txtLevelSpecificRoutine = v.findViewById(R.id.txtSpecificRoutineLevel)
        specificRoutineIv = v.findViewById(R.id.specificRoutineImageView)
        recExercises = v.findViewById(R.id.rec_exercises)
        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exercise.add(Exercise(1,"Flexiones", "1","Intermedio","https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/Ejercicios%2FFlexiones.jpg?alt=media&token=84905a85-7520-4e90-a8f3-36bf50830361"))
        exercise.add(Exercise(2,"Plancha frontal", "1:30","Fácil","https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/Ejercicios%2FPlanchaFrontal.jpg?alt=media&token=3b2c7cf0-28db-4b6c-9f5a-5c9a394b6c78"))
        exercise.add(Exercise(3,"Peso Muerto", "2","Difícil","https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/Ejercicios%2FPesoMuerto.jpg?alt=media&token=9c72e000-d38e-4829-9ddf-23c2f18cebb0"))
        exercise.add(Exercise(4,"Levantamiento frontal", "2:15","Difícil","https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/Ejercicios%2FLevantamiento%20frontal.jpg?alt=media&token=ff22850b-af75-4401-87f4-85172418b216"))
        exercise.add(Exercise(5,"Abdominales", "1:15","Intermedio","https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/Ejercicios%2FAbdominales.jpg?alt=media&token=892a08aa-04ad-4b37-b86b-337d9d73357c"))
        exercise.add(Exercise(6,"Levantamiento piernas", "0:45","Fácil","https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/Ejercicios%2FLevantamiento%20pierna.jpg?alt=media&token=173b35e4-6edd-4161-8fce-073a5c1e04fd"))
    }

    override fun onStart() {
        super.onStart()

        recExercises.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recExercises.layoutManager = linearLayoutManager
        exerciseListAdapter= ExercisesListAdapter(exercise,requireContext()){position -> onItemClick(position)}
        //routinesListAdapter = RoutinesListAdapter(routine)
        recExercises.adapter = exerciseListAdapter

        val strSpecificRoutineName = SpecificRoutineFragmentArgs.fromBundle(requireArguments()).strNameRoutine
        val strSpecificRoutineImageUrl = SpecificRoutineFragmentArgs.fromBundle(requireArguments()).strImageUrlRoutine
        val strSpecificRoutineLevel = SpecificRoutineFragmentArgs.fromBundle(requireArguments()).strLevelRoutine
        val strSpecificRoutineBodypart = SpecificRoutineFragmentArgs.fromBundle(requireArguments()).strBodypartRoutine
        val strSpecificRoutineDuration = SpecificRoutineFragmentArgs.fromBundle(requireArguments()).strDurationRoutine

        GlideApp.with(requireContext())
        .load(strSpecificRoutineImageUrl)
        .circleCrop()
        .into(specificRoutineIv)

        txtLevelSpecificRoutine.text = strSpecificRoutineLevel

        txtBodypartSpecificRoutine.text = strSpecificRoutineBodypart

        txtDurationSpecificRoutine.text = strSpecificRoutineDuration.toString()

        (requireActivity()as MainActivity).changeToolbarName(strSpecificRoutineName)
    }

    public fun onItemClick(position : Int){
       Snackbar.make(v, exercise[position].name, Snackbar.LENGTH_SHORT).show()
    }
}