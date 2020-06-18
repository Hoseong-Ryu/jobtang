@file:Suppress("DEPRECATION")

package com.example.sharedpreferencesingleton

import android.content.Context
import android.preference.PreferenceManager

class PreferenceManager(context : Context) {

    private val pref = PreferenceManager.getDefaultSharedPreferences(context)

    fun getData(key: String): String? = pref.getString(key, null)

    fun setData(key : String, value : String) = pref.edit().putString(key, value).commit()
}