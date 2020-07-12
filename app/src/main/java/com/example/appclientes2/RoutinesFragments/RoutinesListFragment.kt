package com.example.appclientes2.RoutinesFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appclientes2.Adapters.RoutinesListAdapter
import com.example.appclientes2.Entities.Routine
import com.example.appclientes2.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.storage.FirebaseStorage

class RoutinesListFragment : Fragment() {

    lateinit var v : View
    lateinit var recRoutines : RecyclerView

    var routine: MutableList<Routine> = ArrayList<Routine>()

    private lateinit var routinesListAdapter: RoutinesListAdapter
    private lateinit var linearLayoutManager : LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_routines_list, container, false)
        recRoutines= v.findViewById(R.id.rec_routines)

        routine.add(Routine(1,"Rutina 1", "https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/routine_mainfragment_photo.jpg?alt=media&token=fff3a62a-ca3a-4b3d-9650-d4d035fc65e2","Brazos","20","Avanzado","Profesor 1"))
        routine.add(Routine(2,"Rutina 2", "https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/routine_mainfragment_photo.jpg?alt=media&token=fff3a62a-ca3a-4b3d-9650-d4d035fc65e2","Pectorales","45","Principante","Profesor 2"))
        routine.add(Routine(3,"Rutina 3", "https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/routine_mainfragment_photo.jpg?alt=media&token=fff3a62a-ca3a-4b3d-9650-d4d035fc65e2","Abdominales","30","Intermedio","Profesor 3"))
        routine.add(Routine(4,"Rutina 4", "https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/rutinas_lista_phhoto.jpg?alt=media&token=13a83b1b-1a29-41de-a415-2b8571ac87cf","Piernas","60","Avanzado","Profesor 3"))
        routine.add(Routine(5,"Rutina 5", "https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/rutinas_lista_phhoto.jpg?alt=media&token=13a83b1b-1a29-41de-a415-2b8571ac87cf","Espalda","15","Principiado","Profesor 2"))
        routine.add(Routine(6,"Rutina 6", "https://firebasestorage.googleapis.com/v0/b/appclientes-b9820.appspot.com/o/rutinas_lista_phhoto.jpg?alt=media&to<ken=13a83b1b-1a29-41de-a415-2b8571ac87cf","Brazos","90","Intermedio","Profesor 1"))

        return v
    }

    override fun onStart() {
        super.onStart()

        recRoutines.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recRoutines.layoutManager = linearLayoutManager
        routinesListAdapter= RoutinesListAdapter(routine,requireContext()){position -> onItemClick(position)}
        //routinesListAdapter = RoutinesListAdapter(routine)
        recRoutines.adapter = routinesListAdapter
        }

    public fun onItemClick(position : Int){
        Snackbar.make(v,"click", Snackbar.LENGTH_SHORT).show()
        val action1to2 = RoutinesListFragmentDirections.actionDestinationRoutinesToSpecificRoutineFragment(
            routine[position].name,
            routine[position].imageUrl,
            routine[position].level,
            routine[position].duration,
            routine[position].bodyPart
        )
        v.findNavController().navigate(action1to2)
    }

}