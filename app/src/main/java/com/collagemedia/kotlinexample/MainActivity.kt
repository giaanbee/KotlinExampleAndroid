package com.collagemedia.kotlinexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvList.setOnClickListener {
            startActivity(intentFor<ListViewActivity>())
        }

        tvGrid.setOnClickListener {
            startActivity(intentFor<GridViewActivity>())
        }
    }
}
