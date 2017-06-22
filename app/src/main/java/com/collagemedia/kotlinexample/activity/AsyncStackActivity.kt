package com.collagemedia.kotlinexample.activity

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.collagemedia.kotlinexample.R
import kotlinx.android.synthetic.main.activity_async_stack.*
import java.io.InputStream
import java.net.URL

public class AsyncStackActivity : AppCompatActivity() {
    public var imageLoad: ImageView? = null



//    private val urlImage = "http://geeksnation.org/wp-content/uploads/2016/10/Most-Beautiful-Girl.jpg"
    private val urlImage = "https://scontent.fhan3-1.fna.fbcdn.net/v/t1.0-9/19366489_1503266686402676_2571488945428233476_n.jpg?oh=f7bee4bbe4578267f28edf8a77072b4b&oe=59C56600"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_stack)

        imageLoad = imgLoad

        LoadImage(imageLoad!!).execute(urlImage)

    }

    class LoadImage(imageLoad: ImageView) : AsyncTask<String, Void, Bitmap>() {
        val imageNew = imageLoad


        override fun doInBackground(vararg params: String?): Bitmap {

            var bitmap: Bitmap
            val urlImage = URL(params[0])
            val input: InputStream = urlImage.openConnection().getInputStream();
            bitmap = BitmapFactory.decodeStream(input);

            return bitmap
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            imageNew.setImageBitmap(result)
        }

    }
}
