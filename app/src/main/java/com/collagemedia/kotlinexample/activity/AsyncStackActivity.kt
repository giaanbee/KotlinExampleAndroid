package com.collagemedia.kotlinexample.activity

import android.app.ProgressDialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.collagemedia.kotlinexample.R
import kotlinx.android.synthetic.main.activity_async_stack.*
import java.io.InputStream
import java.net.URL


public class AsyncStackActivity : AppCompatActivity() {

    var imageLoad: ImageView? = null
    var progress: ProgressDialog? = null

    private var urlMain = ""

    private val urlImage = "http://geeksnation.org/wp-content/uploads/2016/10/Most-Beautiful-Girl.jpg"
    private val urlImage1 = "https://scontent.fhan3-1.fna.fbcdn.net/v/t1.0-9/19366489_1503266686402676_2571488945428233476_n.jpg?oh=f7bee4bbe4578267f28edf8a77072b4b&oe=59C56600"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_stack)

        urlMain = urlImage
        imageLoad = imgLoad

        btnLoadImage.setOnClickListener {
            LoadImage().execute(urlMain)
        }

        val list = ArrayList<String>()
        list.add("Link 1")
        list.add("Link 2")

        val urls = ArrayList<String>()
        urls.add(urlImage)
        urls.add(urlImage1)

        val dataAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
        spinner.adapter = dataAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.e("TAG", "position = " + position)
                urlMain = urls[position]
            }

        }
        progress = ProgressDialog(this)
        progress!!.setTitle("Load Image")
        progress!!.setCancelable(false)
    }

    inner class LoadImage() : AsyncTask<String, Void, Bitmap>() {

        override fun onPreExecute() {
            super.onPreExecute()
            progress!!.show()
            progress!!.setMessage("Loading")
        }


        override fun doInBackground(vararg params: String?): Bitmap {

            var bitmap: Bitmap
            val urlImage = URL(params[0])
            val input: InputStream = urlImage.openConnection().getInputStream();
            bitmap = BitmapFactory.decodeStream(input);

            return bitmap
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            imageLoad!!.setImageBitmap(result)
            progress!!.dismiss()
        }

    }
}
