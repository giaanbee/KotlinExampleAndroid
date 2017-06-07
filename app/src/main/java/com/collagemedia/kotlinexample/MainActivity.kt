package com.collagemedia.kotlinexample

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

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

        tvViewPager.setOnClickListener {
            startActivity(intentFor<ViewPagerActivity>())
        }

        tvLambdas.setOnClickListener {
            supportsLollipop {
                showToast()
            }
        }

        tvDataOpenSQLite.setOnClickListener {
            startActivity(intentFor<DataSQLiteActivity>())
        }

        tvAnkoLayout.setOnClickListener {
            startActivity(intentFor<AnkoLayoutActivity>())
        }
    }

    internal fun supportsLollipop(code: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            code()
        }
    }

    fun showToast() {
        toast("Test Xem nào")
    }
}
