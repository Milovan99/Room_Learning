package com.milovanjakovljevic.room_learning.phone_database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person (
    @PrimaryKey(autoGenerate = false)
    val personName:String,
    val phoneName:String
        )