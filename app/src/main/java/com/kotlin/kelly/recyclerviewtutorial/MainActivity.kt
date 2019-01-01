package com.kotlin.kelly.recyclerviewtutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.kotlin.kelly.recyclerviewtutorial.data.PersonListAdapter
import com.kotlin.kelly.recyclerviewtutorial.model.Person
import kotlinx.android.synthetic.main.activity_main.recyclerView

class MainActivity : AppCompatActivity() {
    private var adapter : PersonListAdapter? = null
    private var personList : ArrayList<Person>? = null
    private var layoutManager : RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personList = ArrayList<Person>()
        layoutManager = LinearLayoutManager(this)
        adapter = PersonListAdapter(personList!!, this)

        //Setup List for Recycler view
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        //load the data
        for (i in 0..20){
            val person =Person()
            person.name = "Eoin" + i
            person.age = 20 + i
            personList!!.add(person)
        }

        adapter!!.notifyDataSetChanged()
    }
}
