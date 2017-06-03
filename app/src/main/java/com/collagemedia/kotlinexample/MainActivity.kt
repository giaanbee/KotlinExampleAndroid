package com.collagemedia.kotlinexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.collagemedia.kotlinexample.adapter.ListStudentAdapter
import com.collagemedia.kotlinexample.model.StudentModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name: String = getString(R.string.name_list)
        tvMain.text = name
        tvMain.setOnClickListener {
            startActivity(intentFor<GalleryActivity>())
        }

        val lstStudent: ArrayList<StudentModel> = initData()

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
        data.add(StudentModel(1, randomUrl(initUrl()), "John", "26/08/1992"))
        data.add(StudentModel(2, randomUrl(initUrl()), "Dept", "01/01/1994"))
        data.add(StudentModel(3, randomUrl(initUrl()), "Jana", "09/03/1992"))
        data.add(StudentModel(4, randomUrl(initUrl()), "Temo", "15/05/1991"))
        data.add(StudentModel(5, randomUrl(initUrl()), "Catilyn", "09/12/1997"))
        data.add(StudentModel(6, randomUrl(initUrl()), "Garen", "21/04/1990"))
        data.add(StudentModel(7, randomUrl(initUrl()), "Yasuo", "16/01/1987"))
        data.add(StudentModel(8, randomUrl(initUrl()), "Mundo", "30/12/1988"))
        data.add(StudentModel(9, randomUrl(initUrl()), "John", "26/08/1992"))
        data.add(StudentModel(10, randomUrl(initUrl()), "Dept", "01/01/1994"))
        data.add(StudentModel(11, randomUrl(initUrl()), "Jana", "09/03/1992"))
        data.add(StudentModel(12, randomUrl(initUrl()), "Temo", "15/05/1991"))
        data.add(StudentModel(13, randomUrl(initUrl()), "Catilyn", "09/12/1997"))
        data.add(StudentModel(14, randomUrl(initUrl()), "Garen", "21/04/1990"))
        data.add(StudentModel(15, randomUrl(initUrl()), "Yasuo", "16/01/1987"))
        data.add(StudentModel(16, randomUrl(initUrl()), "Mundo", "30/12/1988"))

        data.add(StudentModel(17, randomUrl(initUrl()), "John", "26/08/1992"))
        data.add(StudentModel(18, randomUrl(initUrl()), "Dept", "01/01/1994"))
        data.add(StudentModel(19, randomUrl(initUrl()), "Jana", "09/03/1992"))
        data.add(StudentModel(20, randomUrl(initUrl()), "Temo", "15/05/1991"))
        data.add(StudentModel(21, randomUrl(initUrl()), "Catilyn", "09/12/1997"))
        data.add(StudentModel(22, randomUrl(initUrl()), "Garen", "21/04/1990"))
        data.add(StudentModel(23, randomUrl(initUrl()), "Yasuo", "16/01/1987"))
        data.add(StudentModel(24, randomUrl(initUrl()), "Mundo", "30/12/1988"))
        data.add(StudentModel(25, randomUrl(initUrl()), "John", "26/08/1992"))
        data.add(StudentModel(26, randomUrl(initUrl()), "Dept", "01/01/1994"))
        data.add(StudentModel(27, randomUrl(initUrl()), "Jana", "09/03/1992"))
        data.add(StudentModel(28, randomUrl(initUrl()), "Temo", "15/05/1991"))
        data.add(StudentModel(29, randomUrl(initUrl()), "Catilyn", "09/12/1997"))
        data.add(StudentModel(30, randomUrl(initUrl()), "Garen", "21/04/1990"))
        data.add(StudentModel(31, randomUrl(initUrl()), "Yasuo", "16/01/1987"))
        data.add(StudentModel(32, randomUrl(initUrl()), "Mundo", "30/12/1988"))
        return data
    }
}
