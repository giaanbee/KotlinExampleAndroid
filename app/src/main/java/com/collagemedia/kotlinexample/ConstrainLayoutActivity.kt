package com.collagemedia.kotlinexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_constrain_layout.*
import org.jetbrains.anko.toast

class ConstrainLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constrain_layout)

        btnLogin.setOnClickListener {
            if (checkLogin()) {
                toast("Login success")
            } else {
                toast("Login fail")
            }
        }
    }

    fun checkLogin(): Boolean {
        return edName.text.isNotEmpty() && edPassword.text.isNotEmpty()
    }
}
