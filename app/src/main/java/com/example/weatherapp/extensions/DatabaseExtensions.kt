package com.example.weatherapp.extensions

import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.MapRowParser
import org.jetbrains.anko.db.SelectQueryBuilder

/**
 * created by Sunday
 * on 2019-06-26 09:43
 */
fun <T : Any> SelectQueryBuilder.parseList(parser: (Map<String, Any?>) -> T): List<T> =
    parseList(object : MapRowParser<T> {
        override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
    })

fun <T : Any> SelectQueryBuilder.parseOpt(parser: (Map<String, Any?>) -> T): T? =
    parseOpt(object : MapRowParser<T> {
        override fun parseRow(columns: Map<String, Any?>): T = parser(columns)
    })

fun SQLiteDatabase.clear(tableName: String) {
    execSQL("delete from $tableName")
}