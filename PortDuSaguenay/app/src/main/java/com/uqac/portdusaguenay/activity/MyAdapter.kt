package com.uqac.geoexplore.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.uqac.geoexplore.R
import com.uqac.geoexplore.model.Course

class MyAdapter( private val courseList : ArrayList<Course>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context)
            .inflate(R.layout.course_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val course : Course = courseList[position]
        holder.name.text = course.name
        holder.description.text = course.miscInfo?.description
        holder.difficulty.text = course.miscInfo?.difficulty.toString()
        holder.rating.text = course.miscInfo?.rating.toString()
    }

    override fun getItemCount() :Int{
        return courseList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name : TextView= itemView.findViewById(R.id.tvName)
        val difficulty : TextView= itemView.findViewById(R.id.tvDifficulty)
        val description : TextView= itemView.findViewById(R.id.tvdescription)
        val rating : TextView= itemView.findViewById(R.id.tvrating)

    }


}