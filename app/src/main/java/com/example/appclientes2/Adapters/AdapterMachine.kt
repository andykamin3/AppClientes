package com.example.appclientes2.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.appclientes2.Entities.Machine
import com.example.appclientes2.Entities.Routine
import com.example.appclientes2.R

class MachinesListAdapter (private var machinesList: MutableList<Machine>, val adapterOnClick : (Int) -> Unit) : RecyclerView.Adapter<MachinesListAdapter.MachineHolder>() {

    companion object {

        private val TAG = "MachineListAdapter"
    }

    class MachineHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View

        init {
            this.view = v
        }

        fun bindItems(model: Machine) {
            val txt: TextView = view.findViewById(R.id.txt_machine_item)
            txt.text = model.name
            // itemView.imageIv.setImageResource(model.image)
        }

        fun getCardLayout(): CardView {
            return view.findViewById(R.id.card_package_machine_item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MachineHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_machine, parent, false)
        return (MachineHolder(view))
    }

    override fun getItemCount(): Int {
        return machinesList.size
    }

    fun setData(newData: ArrayList<Machine>) {
        this.machinesList = newData
        this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MachineHolder, position: Int) {
        holder.bindItems(machinesList[position])
        holder.getCardLayout().setOnClickListener {
            adapterOnClick(position)
        }


    }
}