package com.mashup.patatoinvitation.utils

import android.content.Context
import android.content.SharedPreferences

object PreferenceUtils {
    private val TAG = PreferenceUtils::class.java.simpleName

    private const val PREFERENCES_NAME = "preference_util"

    private const val DEFAULT_STRING = ""
    private const val DEFAULT_BOOLEAN = false
    private const val DEFAULT_BOOLEAN_TRUE = true
    private const val DEFAULT_INT = 0
    private const val DEFAULT_LONG = 0L
    private const val DEFAULT_FLOAT = 0f

    lateinit var prefs: SharedPreferences

    fun setInstance(context: Context) {
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    /**
     * Preferences 초기화.
     */
    fun clearPreferences() {
        if (::prefs.isInitialized) {
            val editor = prefs.edit()
            editor.clear()
            editor.apply()
        }
    }

    /**
     * String 저장
     */
    fun putString(key: String?, value: String?) {
        if (::prefs.isInitialized) {
            val editor = prefs.edit()
            editor.putString(key, value)
            editor.apply()
        }
    }

    /**
     * boolean 저장
     */
    fun putBoolean(key: String?, value: Boolean) {
        if (PreferenceUtils::prefs.isInitialized) {
            val editor = prefs.edit()
            editor.putBoolean(key, value)
            editor.apply()
        }
    }

    /**
     * int 저장
     */
    fun putInt(key: String?, value: Int) {
        if (::prefs.isInitialized) {
            val editor = prefs.edit()
            editor.putInt(key, value)
            editor.apply()
        }
    }

    /**
     * long 저장
     */
    fun putLong(key: String?, value: Long) {
        if (::prefs.isInitialized) {
            val editor = prefs.edit()
            editor.putLong(key, value)
            editor.apply()
        }
    }

    /**
     * float 저장
     */
    fun putFloat(key: String?, value: Float) {
        if (::prefs.isInitialized) {
            val editor = prefs.edit()
            editor.putFloat(key, value)
            editor.apply()
        }
    }

    /**
     * String 가져오기
     */
    fun getString(key: String?, defaultValue: String): String {
        return if (::prefs.isInitialized) {
            prefs.getString(key, defaultValue) ?: defaultValue
        } else {
            defaultValue
        }
    }

    /**
     * String 가져오기
     */
    fun getString(key: String?): String {
        return getString(
            key,
            DEFAULT_STRING
        )
    }

    /**
     * boolean 가져오기
     */
    fun getBoolean(key: String?, defaultValue: Boolean): Boolean {
        return prefs.getBoolean(key, defaultValue)
    }

    /**
     * boolean 가져오기
     */
    fun getBoolean(key: String?): Boolean {
        return getBoolean(
            key,
            DEFAULT_BOOLEAN
        )
    }

    /**
     * boolean 가져오기
     * default true
     */
    fun getBooleanTrue(key: String?): Boolean {
        return getBoolean(
            key,
            DEFAULT_BOOLEAN_TRUE
        )
    }

    /**
     * int 가져오기
     */
    fun getInt(key: String?, defaultValue: Int): Int {
        return prefs.getInt(key, defaultValue)
    }

    /**
     * int 가져오기
     */
    fun getInt(key: String?): Int {
        return getInt(
            key,
            DEFAULT_INT
        )
    }

    /**
     * long 가져오기
     */
    fun getLong(key: String?, defaultValue: Long): Long {
        return prefs.getLong(key, defaultValue)
    }

    /**
     * long 가져오기
     */
    fun getLong(key: String?): Long {
        return getLong(
            key,
            DEFAULT_LONG
        )
    }

    /**
     * float 가져오기
     */
    fun getFloat(key: String?, defaultValue: Float): Float {
        return prefs.getFloat(key, defaultValue)
    }

    /**
     * float 가져오기
     */
    fun getFloat(key: String?): Float {
        return getFloat(
            key,
            DEFAULT_FLOAT
        )
    }

    /**
     * 키에 맞는 값의 존재여부를 반환한다.
     */
    fun contains(key: String?): Boolean {
        return prefs.contains(key)
    }

    fun remove(key: String?) {
        if (::prefs.isInitialized) {
            val editor = prefs.edit()
            editor.remove(key)
            editor.apply()
        }
    }
}