package com.example.quizgamev.main

import android.content.Context

interface LocalStorage {

    fun save(value: String, key: String)

    fun read(key: String, default: String): String

    fun save(value: Int, key: String)

    fun read(key: String, default: Int): Int

    fun save(value: Boolean, key: String)

    fun read(key: String, default: Boolean): Boolean

    class Base(context: Context) : LocalStorage {

        private val sharedPref = context.getSharedPreferences("quizGameData", Context.MODE_PRIVATE)

        override fun save(value: String, key: String) {
            sharedPref.edit().putString(key, value).apply()
        }

        override fun save(value: Int, key: String) {
            sharedPref.edit().putInt(key, value).apply()
        }

        override fun save(value: Boolean, key: String) {
            sharedPref.edit().putBoolean(key, value).apply()
        }

        override fun read(key: String, default: String): String {
            return sharedPref.getString(key, default) ?: default
        }

        override fun read(key: String, default: Int): Int {
            return sharedPref.getInt(key, default)
        }

        override fun read(key: String, default: Boolean): Boolean {
            return sharedPref.getBoolean(key, default)
        }
    }
}
