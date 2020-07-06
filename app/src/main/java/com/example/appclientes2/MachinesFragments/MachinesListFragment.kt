package com.example.appclientes2.MachinesFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appclientes2.Adapters.MachinesListAdapter
import com.example.appclientes2.Adapters.RoutinesListAdapter
import com.example.appclientes2.Entities.Machine
import com.example.appclientes2.Entities.Routine
import com.example.appclientes2.R
import com.google.android.material.snackbar.Snackbar

class MachinesListFragment : Fragment() {

    lateinit var v : View
    lateinit var recMachines : RecyclerView

    var machine: MutableList<Machine> = ArrayList<Machine>()

    private lateinit var machinesListAdapter: MachinesListAdapter
    private lateinit var linearLayoutManager : LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_machines_list, container, false)
        recMachines= v.findViewById(R.id.rec_machines)
        return v
    }

    override fun onStart() {
        super.onStart()
        machine.add(Machine("Maquina 1"))
        machine.add(Machine("Maquina 2"))
        machine.add(Machine("Maquina 3"))
        machine.add(Machine("Maquina 4"))
        machine.add(Machine("Maquina 5"))
        machine.add(Machine("Maquina 6"))

        recMachines.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recMachines.layoutManager = linearLayoutManager
        machinesListAdapter= MachinesListAdapter(machine){position -> onItemClick(position)}
        //routinesListAdapter = RoutinesListAdapter(routine)
        recMachines.adapter = machinesListAdapter
    }

    public fun onItemClick(position : Int){
        Snackbar.make(v,"click", Snackbar.LENGTH_SHORT).show()

       val action3to4 = MachinesListFragmentDirections.actionDestinationMachinesToSpecificMachineFragment(
        machine[position].name
        )

        v.findNavController().navigate(action3to4)
    }
}