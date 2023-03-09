package com.milovanjakovljevic.room_learning.phone_database.entities.relations

import androidx.room.Entity

@Entity(primaryKeys = ["categoryName","appName"])
data class CategoryAppCrossRef (
    val categoryName:String,
    val appName:String
        )