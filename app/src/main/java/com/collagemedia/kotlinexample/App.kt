package com.collagemedia.kotlinexample

import android.app.Application

/*
 * Created by Gia An Bee on 6/6/2017.
 */
class App : Application() {
    companion object {
        private var instance: Application? = null;
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}