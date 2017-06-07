package com.collagemedia.kotlinexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.sdk25.coroutines.onSeekBarChangeListener

class AnkoLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anko_layout)

        verticalLayout {
            padding = dip(5)
            val name = editText()
            name.hint = "this is edittext"
            button("say hello") {
                onClick {
                    this@button.text = "${name.text}"
                    toast("hello, ${name.text}!")
                }

            }
            themedButton("button with theme", theme = R.style.CustomFontStyle)

            seekBar{
                onSeekBarChangeListener {
                    onProgressChanged{ seekbar, progress, fromuser ->

                    }
                }

            }
        }
    }
}
