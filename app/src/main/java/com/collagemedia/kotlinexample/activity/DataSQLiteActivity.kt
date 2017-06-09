package com.collagemedia.kotlinexample.activity

import com.collagemedia.kotlinexample.R
import com.collagemedia.kotlinexample.model.StudentModel
import org.jetbrains.anko.*
import org.jetbrains.anko.coroutines.experimental.asReference
import org.jetbrains.anko.custom.async

class DataSQLiteActivity : android.support.v7.app.AppCompatActivity(), org.jetbrains.anko.AnkoLogger {
    var dataSQL: com.collagemedia.kotlinexample.sqlite.DataOpenHelper? = null

    var list: ArrayList<com.collagemedia.kotlinexample.model.StudentModel> = ArrayList()
    var progressDialog: android.app.ProgressDialog? = null

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.collagemedia.kotlinexample.R.layout.activity_data_sqlite)

        dataSQL = com.collagemedia.kotlinexample.sqlite.DataOpenHelper.Companion.getInstance(this)
        progressDialog = android.app.ProgressDialog(this)
        progressDialog!!.setProgressStyle(android.app.ProgressDialog.STYLE_SPINNER)
        progressDialog!!.setTitle("Loading...")
//        loadData()

//        initView()
        loadAndShowData()
    }



    /*--------Using Anko Coroutines --------*/

    //------------bg()---------------
    fun getData(): ArrayList<com.collagemedia.kotlinexample.model.StudentModel> {
//        progressDialog!!.show()
        var data: ArrayList<com.collagemedia.kotlinexample.model.StudentModel> = ArrayList()
        if (dataSQL!!.getCount() == 0) {
            for (item in com.collagemedia.kotlinexample.util.Config.initData())
                dataSQL!!.addData(item)
        }
        data = dataSQL!!.getAllData()
        return data
    }

    fun initView() {
        progressDialog!!.show()
        kotlinx.coroutines.experimental.async(kotlinx.coroutines.experimental.android.UI) {
            val data: kotlinx.coroutines.experimental.Deferred<ArrayList<StudentModel>> = org.jetbrains.anko.coroutines.experimental.bg {
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
        val ref: org.jetbrains.anko.coroutines.experimental.Ref<DataSQLiteActivity> = this.asReference()

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
                for (item in com.collagemedia.kotlinexample.util.Config.initData())
                    dataSQL!!.addData(item)
            }
            list = dataSQL!!.getAllData()

            uiThread {
                showData(list)
            }
        }
    }

    private fun showData(data: ArrayList<com.collagemedia.kotlinexample.model.StudentModel>) {
        progressDialog!!.dismiss()
        kotlinx.android.synthetic.main.activity_data_sqlite.lvData.adapter = com.collagemedia.kotlinexample.adapter.ListViewAdapter(this, R.layout.item_listview, data)
        kotlinx.android.synthetic.main.activity_data_sqlite.lvData.setOnItemClickListener { _, _, position, _ ->
            startActivity(intentFor<ViewPagerActivity>("pos" to position))
        }
    }
}
