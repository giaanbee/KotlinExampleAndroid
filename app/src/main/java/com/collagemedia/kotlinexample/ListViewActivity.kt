package com.collagemedia.kotlinexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.collagemedia.kotlinexample.adapter.ListStudentAdapter
import com.collagemedia.kotlinexample.model.StudentModel
import kotlinx.android.synthetic.main.activity_listview.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast

class ListViewActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

        val lstStudent: ArrayList<StudentModel> = initData()

        lvMain.adapter = ListStudentAdapter(this, R.layout.item_listview, lstStudent)
        lvMain.setOnItemClickListener { parent, view, position, id ->
            toast(lstStudent[position].name)
        }

        lvMain.setOnItemLongClickListener { parent, view, position, id ->
            toast(lstStudent[position].birthday)
            false
        }
    }

    fun initData(): ArrayList<StudentModel> {
        val data: ArrayList<StudentModel> = ArrayList()
        data.add(StudentModel(1, R.mipmap.avatar1, "John", "26/08/1992"))
        data.add(StudentModel(2, R.mipmap.avatar2, "Dept", "01/01/1994"))
        data.add(StudentModel(3, R.mipmap.avatar3, "Jana", "09/03/1992"))
        data.add(StudentModel(4, R.mipmap.avatar4, "Temo", "15/05/1991"))
        data.add(StudentModel(5, R.mipmap.avatar5, "Catilyn", "09/12/1997"))
        data.add(StudentModel(6, R.mipmap.avatar6, "Garen", "21/04/1990"))
        data.add(StudentModel(7, R.mipmap.avatar7, "Yasuo", "16/01/1987"))
        data.add(StudentModel(8, R.mipmap.avatar8, "Mundo", "30/12/1988"))
        data.add(StudentModel(9, R.mipmap.avatar9, "John", "26/08/1992"))
        data.add(StudentModel(10, R.mipmap.avatar10, "Dept", "01/01/1994"))
        data.add(StudentModel(11, R.mipmap.avatar11, "Jana", "09/03/1992"))
        data.add(StudentModel(12, R.mipmap.avatar12, "Temo", "15/05/1991"))
        return data
    }
}
