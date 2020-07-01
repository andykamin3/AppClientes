package com.example.appclientes2.RoutinesFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appclientes2.Adapters.RoutinesListAdapter
import com.example.appclientes2.Entities.Routine
import com.example.appclientes2.R
import com.google.android.material.snackbar.Snackbar

class RoutinesListFragment : Fragment() {

    lateinit var v : View
    lateinit var recRoutines : RecyclerView

    var routine: MutableList<Routine> = ArrayList<Routine>()

    private lateinit var routinesListAdapter: RoutinesListAdapter
    private lateinit var gridLayoutManager : GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_routines_list, container, false)
        recRoutines= v.findViewById(R.id.rec_routines)
        return v
    }

    override fun onStart() {
        super.onStart()

        routine.add(Routine("Rutina 1"))
        routine.add(Routine("Rutina 2"))
        routine.add(Routine("Rutina 3"))
        routine.add(Routine("Rutina 4"))
        routine.add(Routine("Rutina 5"))
        routine.add(Routine("Rutina 6"))

        recRoutines.setHasFixedSize(true)
        gridLayoutManager = GridLayoutManager(context,2, LinearLayoutManager.VERTICAL,false)
        recRoutines.layoutManager = gridLayoutManager
        routinesListAdapter= RoutinesListAdapter(routine!!){position -> onItemClick(position)}
        //routinesListAdapter = RoutinesListAdapter(routine)
        recRoutines.adapter = routinesListAdapter

    }

    public fun onItemClick(position : Int){
        Snackbar.make(v,"click", Snackbar.LENGTH_SHORT).show()

        val action1to2 = RoutinesListFragmentDirections.actionDestinationRoutinesToSpecificRoutineFragment(
            routine[position].name
        )
        v.findNavController().navigate(action1to2)
    }

}