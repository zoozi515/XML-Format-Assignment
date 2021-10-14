package com.example.xmlformatassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var tvMain: TextView
    private lateinit var students: List<Student>
    private lateinit var ids: ArrayList<Int>
    private lateinit var names: ArrayList<String>
    private lateinit var marks: ArrayList<Int>

    lateinit var my_rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ids = ArrayList()
        names = ArrayList()
        marks = ArrayList()

        tvMain = findViewById(R.id.tvMain)
        my_rv = findViewById(R.id.rvMain)
        my_rv.adapter = RecyclerViewAdapter(this,ids,names,marks)
        my_rv.layoutManager = LinearLayoutManager(this)

        try{
            val parser = MyXmlPullParserHandler()
            val iStream = assets.open("students.xml")
            students = parser.parse(iStream)

            var text = ""
            for(student in students){
                text += "${student.id} - ${student.name} - ${student.mark}\n"
                //ids.add(student.id)
                names.add(student.name)
                //marks.add(student.mark)
            }
            //tvMain.text = text
        }catch (e: IOException) {
            println("ISSUE: $e")
        }
    }
}