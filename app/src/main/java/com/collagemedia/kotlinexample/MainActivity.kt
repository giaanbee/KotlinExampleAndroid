package com.collagemedia.kotlinexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.collagemedia.kotlinexample.adapter.ListStudentAdapter
import com.collagemedia.kotlinexample.model.StudentModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val url = "https://avatars0.githubusercontent.com/u/1446536?v=3&s=200"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name: String = getString(R.string.name_list)
        tvMain.text = name

        val lstStudent: ArrayList<StudentModel> = ArrayList()
        lstStudent.add(StudentModel(510111, url, "John", "26/08/1992"))
        lstStudent.add(StudentModel(510111, url, "Dept", "01/01/1994"))
        lstStudent.add(StudentModel(510111, url, "Jana", "09/03/1992"))
        lstStudent.add(StudentModel(510111, url, "Temo", "15/05/1991"))
        lstStudent.add(StudentModel(510111, url, "Catilyn", "09/12/1997"))
        lstStudent.add(StudentModel(510111, url, "Garen", "21/04/1990"))
        lstStudent.add(StudentModel(510111, url, "Yasuo", "16/01/1987"))
        lstStudent.add(StudentModel(510111, url, "Mundo", "30/12/1988"))

        lvMain.adapter = ListStudentAdapter(this@MainActivity, lstStudent)


    }
}
