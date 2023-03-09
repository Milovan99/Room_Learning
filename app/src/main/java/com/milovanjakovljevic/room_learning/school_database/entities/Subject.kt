package com.milovanjakovljevic.room_learning.school_database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Subject (
    @PrimaryKey(autoGenerate = false)
    val subjectName :String

        )