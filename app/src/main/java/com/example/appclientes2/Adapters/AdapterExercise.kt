package com.example.appclientes2.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.appclientes2.Entities.Exercise
import com.example.appclientes2.Entities.Routine
import com.example.appclientes2.GlideApp
import com.example.appclientes2.R

class ExercisesListAdapter(private var exerciseList: MutableList<Exercise>, var context : Context,
val adapterOnClick: (Int) -> Unit) : RecyclerView.Adapter<ExercisesListAdapter.ExerciseHolder>(){

    class ExerciseHolder(v : View) : RecyclerView.ViewHolder(v){

        private var view: View

        init {
            this.view = v
        }

        fun bindItems(model: Exercise, context: Context) {
            val txtName: TextView = view.findViewById(R.id.txt_exercise_name)
            txtName.text = model.name
            val imageExercise : ImageView = view.findViewById(R.id.exerciseView)
            GlideApp.with(context)
                .load(model.imageUrl)
                .circleCrop()
                .into(imageExercise)
            val txtLevel: TextView = view.findViewById(R.id.txt_exercise_level)
            txtLevel.text = model.level
            val txtDuration: TextView = view.findViewById(R.id.txt_exercise_duration)
            txtDuration.text = model.duration
        }

        fun getCardLayout(): CardView {
            return view.findViewById(R.id.card_package_exercise_item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExercisesListAdapter.ExerciseHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exercise, parent, false)
        return (ExercisesListAdapter.ExerciseHolder(view))
    }

    override fun getItemCount(): Int {
        return exerciseList.size
    }

    fun setData(newData: ArrayList<Exercise>) {
        this.exerciseList = newData
        this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ExercisesListAdapter.ExerciseHolder, position: Int) {
        holder.bindItems(exerciseList[position], context)
        holder.getCardLayout().setOnClickListener {
            adapterOnClick(position)
        }
    }

}