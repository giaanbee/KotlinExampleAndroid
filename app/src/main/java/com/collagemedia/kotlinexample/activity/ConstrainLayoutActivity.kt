package com.collagemedia.kotlinexample.activity

import org.jetbrains.anko.toast

class ConstrainLayoutActivity : android.support.v7.app.AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.collagemedia.kotlinexample.R.layout.activity_constrain_layout)

        kotlinx.android.synthetic.main.activity_constrain_layout.btnLogin.setOnClickListener {
            if (checkLogin()) {
                toast("Login success")
            } else {
                toast("Login fail")
            }
        }
    }

    fun checkLogin(): Boolean {
        return kotlinx.android.synthetic.main.activity_constrain_layout.edName.text.isNotEmpty() && kotlinx.android.synthetic.main.activity_constrain_layout.edPassword.text.isNotEmpty()
    }
}
