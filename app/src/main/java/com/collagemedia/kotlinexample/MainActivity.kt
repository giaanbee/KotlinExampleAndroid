package com.collagemedia.kotlinexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.collagemedia.kotlinexample.adapter.ListStudentAdapter
import com.collagemedia.kotlinexample.model.StudentModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name: String = getString(R.string.name_list)
        tvMain.text = name

        val lstStudent: ArrayList<StudentModel> = initData()
        lstStudent.add(StudentModel(510111, randomUrl(initUrl()), "John", "26/08/1992"))
        lstStudent.add(StudentModel(510111, randomUrl(initUrl()), "Dept", "01/01/1994"))
        lstStudent.add(StudentModel(510111, randomUrl(initUrl()), "Jana", "09/03/1992"))
        lstStudent.add(StudentModel(510111, randomUrl(initUrl()), "Temo", "15/05/1991"))
        lstStudent.add(StudentModel(510111, randomUrl(initUrl()), "Catilyn", "09/12/1997"))
        lstStudent.add(StudentModel(510111, randomUrl(initUrl()), "Garen", "21/04/1990"))
        lstStudent.add(StudentModel(510111, randomUrl(initUrl()), "Yasuo", "16/01/1987"))
        lstStudent.add(StudentModel(510111, randomUrl(initUrl()), "Mundo", "30/12/1988"))
        lstStudent.add(StudentModel(510111, randomUrl(initUrl()), "John", "26/08/1992"))
        lstStudent.add(StudentModel(510111, randomUrl(initUrl()), "Dept", "01/01/1994"))
        lstStudent.add(StudentModel(510111, randomUrl(initUrl()), "Jana", "09/03/1992"))
        lstStudent.add(StudentModel(510111, randomUrl(initUrl()), "Temo", "15/05/1991"))
        lstStudent.add(StudentModel(510111, randomUrl(initUrl()), "Catilyn", "09/12/1997"))
        lstStudent.add(StudentModel(510111, randomUrl(initUrl()), "Garen", "21/04/1990"))
        lstStudent.add(StudentModel(510111, randomUrl(initUrl()), "Yasuo", "16/01/1987"))
        lstStudent.add(StudentModel(510111, randomUrl(initUrl()), "Mundo", "30/12/1988"))

        lvMain.adapter = ListStudentAdapter(this, R.layout.student_item_layout, lstStudent)
        lvMain.setOnItemClickListener { parent, view, position, id ->
            toast(lstStudent[position].name)
        }

        lvMain.setOnItemLongClickListener { parent, view, position, id ->
            toast(lstStudent[position].birthday)
            false
        }
    }

    fun randomUrl(array: ArrayList<String>): String {
        val random: Random = Random()
        val pos = random.nextInt(array.size)
        return array[pos]
    }

    fun initUrl(): ArrayList<String> {
        val data: ArrayList<String> = ArrayList()
        data.add("https://raw.githubusercontent.com/twitter/twemoji/gh-pages/72x72/1f3b2.png")
        data.add("https://raw.githubusercontent.com/twitter/twemoji/gh-pages/72x72/1f3bb.png")
        data.add("https://raw.githubusercontent.com/twitter/twemoji/gh-pages/72x72/1f3e0.png")
        return data
    }

    fun initData(): ArrayList<StudentModel> {
        val data: ArrayList<StudentModel> = ArrayList()
        data.add(StudentModel(510111, randomUrl(initUrl()), "John", "26/08/1992"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Dept", "01/01/1994"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Jana", "09/03/1992"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Temo", "15/05/1991"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Catilyn", "09/12/1997"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Garen", "21/04/1990"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Yasuo", "16/01/1987"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Mundo", "30/12/1988"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "John", "26/08/1992"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Dept", "01/01/1994"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Jana", "09/03/1992"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Temo", "15/05/1991"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Catilyn", "09/12/1997"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Garen", "21/04/1990"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Yasuo", "16/01/1987"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Mundo", "30/12/1988"))

        data.add(StudentModel(510111, randomUrl(initUrl()), "John", "26/08/1992"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Dept", "01/01/1994"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Jana", "09/03/1992"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Temo", "15/05/1991"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Catilyn", "09/12/1997"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Garen", "21/04/1990"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Yasuo", "16/01/1987"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Mundo", "30/12/1988"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "John", "26/08/1992"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Dept", "01/01/1994"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Jana", "09/03/1992"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Temo", "15/05/1991"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Catilyn", "09/12/1997"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Garen", "21/04/1990"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Yasuo", "16/01/1987"))
        data.add(StudentModel(510111, randomUrl(initUrl()), "Mundo", "30/12/1988"))
        return data
    }
}
