package com.collagemedia.kotlinexample.activity

import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.sdk25.coroutines.onSeekBarChangeListener

class AnkoLayoutActivity : android.support.v7.app.AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.collagemedia.kotlinexample.R.layout.activity_anko_layout)

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
            themedButton("button with theme", theme = com.collagemedia.kotlinexample.R.style.CustomFontStyle)

            seekBar{
                onSeekBarChangeListener {
                    onProgressChanged{ seekbar, progress, fromuser ->

                    }
                }

            }
            imageView {
                setImageResource(com.collagemedia.kotlinexample.R.mipmap.avatar10)
            }
        }
    }
}
