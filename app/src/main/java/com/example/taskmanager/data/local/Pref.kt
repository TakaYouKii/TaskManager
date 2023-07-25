package com.example.taskmanager.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.net.Uri

class Pref(private val context: Context) {
    private val pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

    fun isOnBoardingShow(): Boolean{
        return pref.getBoolean(SHOWED_KEY, false)
    }

    fun onOnBoardingShowed(){
        return pref.edit().putBoolean(SHOWED_KEY, true).apply()
    }

    fun saveName(name:String){
        pref.edit().putString(NAME_KEY, name).apply()
    }

    fun getName():String? {
        return pref.getString(NAME_KEY, null)
    }

    fun saveImage(img: String){
        pref.edit().putString(IMAGE_KEY, img).apply()
    }

    fun getImage(): String? {
        return pref.getString(IMAGE_KEY, null)
    }


    companion object{
        const val PREF_NAME = "pref.name"
        const val SHOWED_KEY = "seen.key"
        const val NAME_KEY = "name.key"
        const val IMAGE_KEY = "image.key"
    }
}