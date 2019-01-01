package com.kotlin.kelly.recyclerviewtutorial.data

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.kotlin.kelly.recyclerviewtutorial.R
import com.kotlin.kelly.recyclerviewtutorial.model.Person

class PersonListAdapter(private val list: ArrayList<Person>, private val context: Context):
    RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonListAdapter.ViewHolder {
        //create view from xml file and return a view holder
        val view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PersonListAdapter.ViewHolder, position: Int) {
        holder?.bindItem(list[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(person: Person){
            var name = itemView.findViewById<TextView>(R.id.name)
            var age = itemView.findViewById<TextView>(R.id.age)

            name.text = person.name
            age.text = person.age.toString()

            itemView.setOnClickListener{
                Toast.makeText(context, name.text, Toast.LENGTH_LONG).show()
            }
        }
    }
}