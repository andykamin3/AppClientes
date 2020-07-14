package com.example.appclientes2.RoutinesFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appclientes2.Adapters.RoutinesListAdapter
import com.example.appclientes2.Entities.Exercise
import com.example.appclientes2.Entities.Routine
import com.example.appclientes2.R
import com.google.android.material.snackbar.Snackbar

class RoutinesListFragment : Fragment() {

    lateinit var v : View
    lateinit var recRoutines : RecyclerView

    var routine: MutableList<Routine> = ArrayList<Routine>()
    lateinit var favoriteRoutines : MutableList<Routine>
    var exerciseExamples: MutableList<Exercise> = ArrayList<Exercise>()

    private lateinit var routinesListAdapter: RoutinesListAdapter
    private lateinit var linearLayoutManager : LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_routines_list, container, false)
        recRoutines= v.findViewById(R.id.rec_routines)

        favoriteRoutines = mutableListOf<Routine>()

        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        exerciseExamples.add(Exercise(1,"Flexiones", "1","Intermedio","https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/Ejercicios%2FFlexiones.jpg?alt=media&token=84905a85-7520-4e90-a8f3-36bf50830361"))
        exerciseExamples.add(Exercise(2,"Plancha frontal", "1:30","Fácil","https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/Ejercicios%2FPlanchaFrontal.jpg?alt=media&token=3b2c7cf0-28db-4b6c-9f5a-5c9a394b6c78"))
        exerciseExamples.add(Exercise(3,"Peso Muerto", "2","Difícil","https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/Ejercicios%2FPesoMuerto.jpg?alt=media&token=9c72e000-d38e-4829-9ddf-23c2f18cebb0"))
        exerciseExamples.add(Exercise(4, "Levantamiento frontal", "2:15","Difícil","https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/Ejercicios%2FLevantamiento%20frontal.jpg?alt=media&token=ff22850b-af75-4401-87f4-85172418b216"))
        exerciseExamples.add(Exercise(5,"Abdominales", "1:15","Intermedio","https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/Ejercicios%2FAbdominales.jpg?alt=media&token=892a08aa-04ad-4b37-b86b-337d9d73357c"))
        exerciseExamples.add(Exercise(6,"Levantamiento piernas", "0:45","Fácil","https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/Ejercicios%2FLevantamiento%20pierna.jpg?alt=media&token=173b35e4-6edd-4161-8fce-073a5c1e04fd"))

        routine.add(Routine(1,"Rutina 1", "https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/routine_mainfragment_photo.jpg?alt=media&token=fff3a62a-ca3a-4b3d-9650-d4d035fc65e2","Brazos","20 min","Avanzado","Profesor 1", exerciseExamples.filter{exercise -> exercise.id == 1 || exercise.id == 2} as ArrayList<Exercise>))
        routine.add(Routine(2,"Rutina 2", "https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/routine_mainfragment_photo.jpg?alt=media&token=fff3a62a-ca3a-4b3d-9650-d4d035fc65e2","Pectorales","45 min","Principante","Profesor 2", exerciseExamples.filter{exercise -> exercise.id == 3 || exercise.id == 4} as ArrayList<Exercise>))
        routine.add(Routine(3,"Rutina 3", "https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/routine_mainfragment_photo.jpg?alt=media&token=fff3a62a-ca3a-4b3d-9650-d4d035fc65e2","Abdominales","30 min","Intermedio","Profesor 3", exerciseExamples.filter{exercise -> exercise.id == 5 || exercise.id == 6} as ArrayList<Exercise>))
        routine.add(Routine(4,"Rutina 4", "https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/rutinas_lista_phhoto.jpg?alt=media&token=13a83b1b-1a29-41de-a415-2b8571ac87cf","Piernas","60 min","Avanzado","Profesor 3", exerciseExamples.filter{exercise -> exercise.id == 5 || exercise.id == 6} as ArrayList<Exercise>))
        routine.add(Routine(5,"Rutina 5", "https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/rutinas_lista_phhoto.jpg?alt=media&token=13a83b1b-1a29-41de-a415-2b8571ac87cf","Espalda","15 min","Principiado","Profesor 2", exerciseExamples.filter{exercise -> exercise.id == 3 || exercise.id == 4} as ArrayList<Exercise>))
        routine.add(Routine(6,"Rutina 6", "https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/rutinas_lista_phhoto.jpg?alt=media&to<ken=13a83b1b-1a29-41de-a415-2b8571ac87cf","Brazos","90 min","Intermedio","Profesor 1", exerciseExamples.filter{exercise -> exercise.id == 1 || exercise.id == 2} as ArrayList<Exercise>))

    }

    override fun onStart() {
        super.onStart()

        recRoutines.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recRoutines.layoutManager = linearLayoutManager
        routinesListAdapter= RoutinesListAdapter(
            routine,
            requireContext(),
            {position -> onItemClick(position)},
            {model -> toggleFavorites(model)}
        )
        //routinesListAdapter = RoutinesListAdapter(routine)
        recRoutines.adapter = routinesListAdapter
        }

    public fun onItemClick(position : Int){
        Snackbar.make(v,"click", Snackbar.LENGTH_SHORT).show()
        val action1to2 = RoutinesListFragmentDirections.actionDestinationRoutinesToSpecificRoutineFragment(
            routine[position]
        )
        v.findNavController().navigate(action1to2)
    }

    public fun toggleFavorites(model: Routine){
        if(favoriteRoutines.contains(model)){
                favoriteRoutines.remove(model)
            Snackbar.make(v,"Removida", Snackbar.LENGTH_SHORT).show() }
        else{
            favoriteRoutines.add(model)
            Snackbar.make(v,"Agregada", Snackbar.LENGTH_SHORT).show()
        }
    }

}