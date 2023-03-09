package com.milovanjakovljevic.room_learning.phone_database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class App (
    @PrimaryKey(autoGenerate = false)
    val appName:String,
    val phoneName:String
        )