package com.collagemedia.kotlinexample.activity

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.collagemedia.kotlinexample.R
import kotlinx.android.synthetic.main.activity_constrain_layout.*
import org.jetbrains.anko.toast


class ConstrainLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constrain_layout)

        btnStart.setOnClickListener {
            if (checkLogin()) {
                toast("Login success")
            } else {
                toast("Login fail")
            }
        }

        val handle = Handler()
        handle.postDelayed(object : Runnable {
            override fun run() {
                val max = progressbar.max
                progressbar.progress = progressbar.progress + 1
                progressbar.secondaryProgress = progressbar.secondaryProgress + 2
                if (progressbar.progress == max) {
                    progressbar.secondaryProgress = 0
                    progressbar.progress = 0
                }


                handle.postDelayed(this, 100)
            }
        }, 100)

    }

    fun checkLogin(): Boolean {
        return edName.text.isNotEmpty() && edPassword.text.isNotEmpty()
    }
}
