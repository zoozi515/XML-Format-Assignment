package com.example.xmlformatassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var tvMain: TextView
    private lateinit var students: List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvMain = findViewById(R.id.tvMain)

        try{
            val parser = MyXmlPullParserHandler()
            val iStream = assets.open("students.xml")
            students = parser.parse(iStream)

            var text = ""
            for(student in students){
                text += "${student.id} - ${student.name} - ${student.mark}\n"
            }
            tvMain.text = text
        }catch (e: IOException) {
            println("ISSUE: $e")
        }
    }
}