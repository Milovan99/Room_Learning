package com.milovanjakovljevic.room_learning.phone_database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Phone (
    @PrimaryKey(autoGenerate = false)
    val phoneName:String
        )