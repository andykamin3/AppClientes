package com.example.appclientes2.RoutinesFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appclientes2.Adapters.ExercisesListAdapter
import com.example.appclientes2.Entities.Exercise
import com.example.appclientes2.Entities.Routine
import com.example.appclientes2.GlideApp
import com.example.appclientes2.MainActivity
import com.example.appclientes2.R
import com.google.android.material.snackbar.Snackbar

class SpecificRoutineFragment : Fragment() {

    lateinit var v : View
    lateinit var txtBodypartSpecificRoutine : TextView
    lateinit var txtLevelSpecificRoutine : TextView
    lateinit var txtDurationSpecificRoutine : TextView
    lateinit var specificRoutineIv : ImageView

    lateinit var exerciseExamples: Exercise
    lateinit var recExercises : RecyclerView
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

    override fun onStart() {
        super.onStart()

        val routine = SpecificRoutineFragmentArgs.fromBundle(requireArguments()).routine


        GlideApp.with(requireContext())
        .load(routine.imageUrl)
        .circleCrop()
        .into(specificRoutineIv)

        txtLevelSpecificRoutine.text = routine.level

        txtBodypartSpecificRoutine.text = routine.bodyPart

        txtDurationSpecificRoutine.text = routine.duration

        (requireActivity()as MainActivity).changeToolbarName(routine.name)

        recExercises.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recExercises.layoutManager = linearLayoutManager
        exerciseListAdapter= ExercisesListAdapter(routine.exercisesList,requireContext()){model -> onItemClick(model)}
        //routinesListAdapter = RoutinesListAdapter(routine)
        recExercises.adapter = exerciseListAdapter
    }

    public fun onItemClick(model : Exercise){
        Snackbar.make(v, model.name, Snackbar.LENGTH_SHORT).show()
    }
}