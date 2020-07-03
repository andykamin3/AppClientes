package com.example.appclientes2.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.appclientes2.Entities.Routine
import com.example.appclientes2.GlideApp
import com.example.appclientes2.R

class RoutinesListAdapter(private var routinesList: MutableList<Routine>, val context: Context,
val adapterOnClick: (Int) -> Unit) : RecyclerView.Adapter<RoutinesListAdapter.RoutineHolder>(){

    companion object {
        private val TAG = "RoutineListAdapter"
    }

    class RoutineHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var view: View

        init {
            this.view = v
        }

        fun bindItems(model: Routine, context: Context) {
            val txt: TextView = view.findViewById(R.id.txt_routine_item)
            txt.text = model.name
            val imageRoutine : ImageView = view.findViewById(R.id.routineView)
            GlideApp.with(context)
                .load(model.imageUrl)
                .into(imageRoutine)
        }

        fun getCardLayout(): CardView {
            return view.findViewById(R.id.card_package_routine_item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_routine, parent, false)
        return (RoutineHolder(view))
    }

    override fun getItemCount(): Int {
        return routinesList.size
    }

    fun setData(newData: ArrayList<Routine>) {
        this.routinesList = newData
        this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RoutineHolder, position: Int) {
        holder.bindItems(routinesList[position], context)
        holder.getCardLayout().setOnClickListener {
            adapterOnClick(position)
        }
    }
}
