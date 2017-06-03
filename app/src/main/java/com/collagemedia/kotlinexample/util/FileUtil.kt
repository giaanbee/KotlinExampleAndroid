package com.collagemedia.kotlinexample.util

import android.os.Environment
import java.io.File

/*
 * Created by Gia An Bee on 6/3/2017.
 */
class FileUtil {
    companion object {
        fun getMyAlbum(): String {
            val cacheDir: File = File(Environment.getExternalStorageDirectory().toString() + Config.PATH_FOLDER)
            if (!cacheDir.exists()) cacheDir.mkdir()
            return Environment.getExternalStorageDirectory().toString() + Config.PATH_FOLDER
        }
    }
}