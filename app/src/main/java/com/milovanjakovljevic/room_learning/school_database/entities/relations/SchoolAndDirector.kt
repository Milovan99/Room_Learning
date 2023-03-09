package com.milovanjakovljevic.room_learning.school_database.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.milovanjakovljevic.room_learning.school_database.entities.Director
import com.milovanjakovljevic.room_learning.school_database.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )

    val director: Director
)
