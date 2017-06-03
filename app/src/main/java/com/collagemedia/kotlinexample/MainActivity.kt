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

        val lstStudent: ArrayList<StudentModel> = ArrayList()
        lstStudent.add(StudentModel(510111, radomUrl(initUrl()), "John", "26/08/1992"))
        lstStudent.add(StudentModel(510111, radomUrl(initUrl()), "Dept", "01/01/1994"))
        lstStudent.add(StudentModel(510111, radomUrl(initUrl()), "Jana", "09/03/1992"))
        lstStudent.add(StudentModel(510111, radomUrl(initUrl()), "Temo", "15/05/1991"))
        lstStudent.add(StudentModel(510111, radomUrl(initUrl()), "Catilyn", "09/12/1997"))
        lstStudent.add(StudentModel(510111, radomUrl(initUrl()), "Garen", "21/04/1990"))
        lstStudent.add(StudentModel(510111, radomUrl(initUrl()), "Yasuo", "16/01/1987"))
        lstStudent.add(StudentModel(510111, radomUrl(initUrl()), "Mundo", "30/12/1988"))
        lstStudent.add(StudentModel(510111, radomUrl(initUrl()), "John", "26/08/1992"))
        lstStudent.add(StudentModel(510111, radomUrl(initUrl()), "Dept", "01/01/1994"))
        lstStudent.add(StudentModel(510111, radomUrl(initUrl()), "Jana", "09/03/1992"))
        lstStudent.add(StudentModel(510111, radomUrl(initUrl()), "Temo", "15/05/1991"))
        lstStudent.add(StudentModel(510111, radomUrl(initUrl()), "Catilyn", "09/12/1997"))
        lstStudent.add(StudentModel(510111, radomUrl(initUrl()), "Garen", "21/04/1990"))
        lstStudent.add(StudentModel(510111, radomUrl(initUrl()), "Yasuo", "16/01/1987"))
        lstStudent.add(StudentModel(510111, radomUrl(initUrl()), "Mundo", "30/12/1988"))

        lvMain.adapter = ListStudentAdapter(this, R.layout.student_item_layout, lstStudent)
        lvMain.setOnItemClickListener { parent, view, position, id ->
            toast(lstStudent[position].name)
        }

        lvMain.setOnItemLongClickListener { parent, view, position, id ->
            toast(lstStudent[position].birthday)
            false
        }
    }

    fun radomUrl(array: ArrayList<String>): String {
        val radom: Random = Random()
        val pos = radom.nextInt(array.size)
        return array[pos]
    }

    fun initUrl(): ArrayList<String> {
        val datas: ArrayList<String> = ArrayList()
        datas.add("https://raw.githubusercontent.com/twitter/twemoji/gh-pages/72x72/1f3b2.png")
        datas.add("https://raw.githubusercontent.com/twitter/twemoji/gh-pages/72x72/1f3bb.png")
        datas.add("https://raw.githubusercontent.com/twitter/twemoji/gh-pages/72x72/1f3e0.png")
        return datas
    }
}
