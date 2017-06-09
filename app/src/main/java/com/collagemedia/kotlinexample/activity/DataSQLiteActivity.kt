package com.collagemedia.kotlinexample.activity
import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.collagemedia.kotlinexample.R
import com.collagemedia.kotlinexample.activity.ViewPagerActivity
import com.collagemedia.kotlinexample.adapter.ListViewAdapter
import com.collagemedia.kotlinexample.model.StudentModel
import com.collagemedia.kotlinexample.sqlite.DataOpenHelper
import com.collagemedia.kotlinexample.util.Config
import kotlinx.android.synthetic.main.activity_data_sqlite.*
import kotlinx.coroutines.experimental.Deferred
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.coroutines.experimental.Ref
import org.jetbrains.anko.coroutines.experimental.asReference
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.uiThread

class DataSQLiteActivity : AppCompatActivity(), AnkoLogger {
    var dataSQL: DataOpenHelper? = null

    var list: ArrayList<StudentModel> = ArrayList()
    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_sqlite)

        dataSQL = DataOpenHelper.Companion.getInstance(this)
        progressDialog = ProgressDialog(this)
        progressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressDialog!!.setTitle("Loading...")
//        loadData()

//        initView()
        loadAndShowData()
    }


    /*--------Using Anko Coroutines --------*/

    //------------bg()---------------
    fun getData(): ArrayList<StudentModel> {
//        progressDialog!!.show()
        var data: ArrayList<StudentModel> = ArrayList()
        if (dataSQL!!.getCount() == 0) {
            for (item in Config.initData())
                dataSQL!!.addData(item)
        }
        data = dataSQL!!.getAllData()
        return data
    }

    fun initView() {
        progressDialog!!.show()
        kotlinx.coroutines.experimental.async(kotlinx.coroutines.experimental.android.UI) {
            val data: Deferred<ArrayList<StudentModel>> = bg {
                // Chạy trong background
                getData()
            }

            // UI
            showData(data.await())
        }
    }
    //---------------asReference()------------

    fun loadAndShowData() {
        progressDialog!!.show()
        // Ref<T> uses the WeakReference under the hood
        val ref: Ref<DataSQLiteActivity> = this.asReference()

        kotlinx.coroutines.experimental.async(kotlinx.coroutines.experimental.android.UI) {
            val data = getData()

            // Use ref() instead of this@MyActivity
            ref().showData(data)
        }
    }


    /*-------Normal--------*/
    private fun loadData() {
        async {
            if (dataSQL!!.getCount() == 0) {
                for (item in Config.initData())
                    dataSQL!!.addData(item)
            }
            list = dataSQL!!.getAllData()

            uiThread {
                showData(list)
            }
        }
    }

    private fun showData(data: ArrayList<StudentModel>) {
        progressDialog!!.dismiss()
        lvData.adapter = ListViewAdapter(this, R.layout.item_listview, data)
        lvData.setOnItemClickListener { _, _, position, _ ->
            startActivity(intentFor<ViewPagerActivity>("pos" to position))
        }
    }
}
