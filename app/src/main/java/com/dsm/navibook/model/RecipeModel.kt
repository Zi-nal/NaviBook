package com.dsm.navibook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Recipe")
data class RecipeModel(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "time")
    var time: String,

    @ColumnInfo(name = "type")
    var type: String,

    @ColumnInfo(name = "ingredient")
    var ingredient: String,

    @ColumnInfo(name = "condiment")
    var condiment: String,

    @ColumnInfo(name = "content")
    var content: String
) {
    constructor() : this(null, "", "", "", "", "", "")
}